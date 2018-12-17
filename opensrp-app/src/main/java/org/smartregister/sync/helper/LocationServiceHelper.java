package org.smartregister.sync.helper;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NoHttpResponseException;
import org.joda.time.DateTime;
import org.smartregister.CoreLibrary;
import org.smartregister.domain.Location;
import org.smartregister.domain.LocationProperty;
import org.smartregister.domain.Response;
import org.smartregister.repository.AllSharedPreferences;
import org.smartregister.repository.LocationRepository;
import org.smartregister.repository.StructureRepository;
import org.smartregister.service.HTTPAgent;
import org.smartregister.util.DateTimeTypeConverter;
import org.smartregister.util.PropertiesConverter;

import java.util.List;

import static org.smartregister.AllConstants.OPERATIONAL_AREAS;

public class LocationServiceHelper {

    private AllSharedPreferences allSharedPreferences = CoreLibrary.getInstance().context().allSharedPreferences();

    protected final Context context;
    private LocationRepository locationRepository;
    private StructureRepository structureRepository;

    public static final String LOCATION_STRUCTURE_URL = "/rest/location/sync";
    public static final String STRUCTURES_LAST_SYNC_DATE = "STRUCTURES_LAST_SYNC_DATE";
    public static final String LOCATION_LAST_SYNC_DATE = "LOCATION_LAST_SYNC_DATE";

    private static Gson locationGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .registerTypeAdapter(DateTime.class, new DateTimeTypeConverter())
            .registerTypeAdapter(LocationProperty.class, new PropertiesConverter()).create();
    protected static LocationServiceHelper instance;

    public static LocationServiceHelper getInstance() {
        if (instance == null) {
            instance = new LocationServiceHelper(CoreLibrary.getInstance().context().getLocationRepository(), CoreLibrary.getInstance().context().getStructureRepository());
        }
        return instance;
    }

    @VisibleForTesting
    public LocationServiceHelper(LocationRepository locationRepository, StructureRepository structureRepository) {
        this.context = CoreLibrary.getInstance().context().applicationContext();
        this.locationRepository = locationRepository;
        this.structureRepository = structureRepository;
    }

    protected void syncLocationsStructures(boolean isJurisdiction) {
        long serverVersion = 0;
        String currentServerVersion = allSharedPreferences.getPreference(isJurisdiction ? LOCATION_LAST_SYNC_DATE : STRUCTURES_LAST_SYNC_DATE);
        try {
            serverVersion = (StringUtils.isEmpty(currentServerVersion)? 0: Long.parseLong(currentServerVersion));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            List<String> parentIds = locationRepository.getAllLocationIds();
            String featureResponse = fetchLocationsOrStructures(isJurisdiction, serverVersion, TextUtils.join(",", parentIds));
            List<Location> locations = locationGson.fromJson(featureResponse, new TypeToken<List<Location>>() {
            }.getType());

            for (Location location : locations) {
                try {
                    if (isJurisdiction)
                        locationRepository.addOrUpdate(location);
                    else
                        structureRepository.addOrUpdate(location);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String maxServerVersion = getMaxServerVersion(locations, serverVersion);
            String updateKey = isJurisdiction ? LOCATION_LAST_SYNC_DATE : STRUCTURES_LAST_SYNC_DATE;
            allSharedPreferences.savePreference(maxServerVersion, updateKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String makeURL(boolean isJurisdiction, long serverVersion, String parentId) {
        String baseUrl = CoreLibrary.getInstance().context().
                configuration().dristhiBaseURL();
        String endString = "/";
        if (baseUrl.endsWith(endString)) {
            baseUrl = baseUrl.substring(0, baseUrl.lastIndexOf(endString));
        }
        if (isJurisdiction) {
            String preferenceLocationNames = allSharedPreferences.getPreference(OPERATIONAL_AREAS);
            return baseUrl + LOCATION_STRUCTURE_URL + "?is_jurisdiction=" + isJurisdiction + "&location_names=" + preferenceLocationNames + "&serverVersion=" + serverVersion;
        }
        return baseUrl + LOCATION_STRUCTURE_URL + "?parent_id=" + parentId + "&isJurisdiction=" + isJurisdiction + "&serverVersion=" + serverVersion;

    }

    private String fetchLocationsOrStructures(boolean isJurisdiction, Long serverVersion, String parentId) throws Exception {

        HTTPAgent httpAgent = CoreLibrary.getInstance().context().getHttpAgent();
        if (httpAgent == null) {
            throw new IllegalArgumentException(LOCATION_STRUCTURE_URL + " http agent is null");
        }

        Response resp = httpAgent.fetch(makeURL(isJurisdiction, serverVersion, parentId));
        if (resp.isFailure()) {
            throw new NoHttpResponseException(LOCATION_STRUCTURE_URL + " not returned data");
        }

        return resp.payload().toString();
    }

    private String getMaxServerVersion(List<Location> locations, long serverVersionParam) {
        long currentServerVersion = serverVersionParam;
        for (Location location : locations) {
            long serverVersion = location.getServerVersion();
            if (serverVersion > currentServerVersion) {
                currentServerVersion = serverVersion;
            }
        }
        return String.valueOf(currentServerVersion);
    }

    public void fetchLocationsStructures() {
        syncLocationsStructures(true);
        syncLocationsStructures(false);
    }

}
