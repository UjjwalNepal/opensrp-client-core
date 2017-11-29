package org.smartregister.repository.mock;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.annotation.StyleRes;
import android.view.Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kaderchowdhury on 19/11/17.
 */

public class ContextMock {
    
    public static Context getContext(){
        return new Context() {
            @Override
            public AssetManager getAssets() {
                return null;
            }

            @Override
            public Resources getResources() {
                return null;
            }

            @Override
            public PackageManager getPackageManager() {
                return null;
            }

            @Override
            public ContentResolver getContentResolver() {
                return null;
            }

            @Override
            public Looper getMainLooper() {
                return null;
            }

            @Override
            public Context getApplicationContext() {
                return null;
            }

            @Override
            public void setTheme(@StyleRes int i) {

            }

            @Override
            public Resources.Theme getTheme() {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }

            @Override
            public String getPackageName() {
                return null;
            }

            @Override
            public ApplicationInfo getApplicationInfo() {
                return null;
            }

            @Override
            public String getPackageResourcePath() {
                return null;
            }

            @Override
            public String getPackageCodePath() {
                return null;
            }

            @Override
            public SharedPreferences getSharedPreferences(String s, int i) {
                return null;
            }

            @Override
            public FileInputStream openFileInput(String s) throws FileNotFoundException {
                return null;
            }

            @Override
            public FileOutputStream openFileOutput(String s, int i) throws FileNotFoundException {
                return null;
            }

            @Override
            public boolean deleteFile(String s) {
                return false;
            }

            @Override
            public File getFileStreamPath(String s) {
                return null;
            }

            @Override
            public File getFilesDir() {
                return new File("/");
            }

            @Override
            public File getNoBackupFilesDir() {
                return null;
            }

            @Nullable
            @Override
            public File getExternalFilesDir(@Nullable String s) {
                return null;
            }

            @Override
            public File[] getExternalFilesDirs(String s) {
                return new File[0];
            }

            @Override
            public File getObbDir() {
                return null;
            }

            @Override
            public File[] getObbDirs() {
                return new File[0];
            }

            @Override
            public File getCacheDir() {
                return null;
            }

            @Override
            public File getCodeCacheDir() {
                return null;
            }

            @Nullable
            @Override
            public File getExternalCacheDir() {
                return null;
            }

            @Override
            public File[] getExternalCacheDirs() {
                return new File[0];
            }

            @Override
            public File[] getExternalMediaDirs() {
                return new File[0];
            }

            @Override
            public String[] fileList() {
                return new String[0];
            }

            @Override
            public File getDir(String s, int i) {
                return null;
            }

            @Override
            public SQLiteDatabase openOrCreateDatabase(String s, int i, SQLiteDatabase.CursorFactory cursorFactory) {
                return null;
            }

            @Override
            public SQLiteDatabase openOrCreateDatabase(String s, int i, SQLiteDatabase.CursorFactory cursorFactory, @Nullable DatabaseErrorHandler databaseErrorHandler) {
                return null;
            }

            @Override
            public boolean deleteDatabase(String s) {
                return false;
            }

            @Override
            public File getDatabasePath(String s) {
                return null;
            }

            @Override
            public String[] databaseList() {
                return new String[0];
            }

            @Override
            public Drawable getWallpaper() {
                return null;
            }

            @Override
            public Drawable peekWallpaper() {
                return null;
            }

            @Override
            public int getWallpaperDesiredMinimumWidth() {
                return 0;
            }

            @Override
            public int getWallpaperDesiredMinimumHeight() {
                return 0;
            }

            @Override
            public void setWallpaper(Bitmap bitmap) throws IOException {
                System.out.println();
            }

            @Override
            public void setWallpaper(InputStream inputStream) throws IOException {
                System.out.println();
            }

            @Override
            public void clearWallpaper() throws IOException {
                System.out.println();
            }

            @Override
            public void startActivity(Intent intent) {
                System.out.println();
            }

            @Override
            public void startActivity(Intent intent, @Nullable Bundle bundle) {
                System.out.println();
            }

            @Override
            public void startActivities(Intent[] intents) {
                System.out.println();
            }

            @Override
            public void startActivities(Intent[] intents, Bundle bundle) {
                System.out.println();
            }

            @Override
            public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i1, int i2) throws IntentSender.SendIntentException {
                System.out.println();
            }

            @Override
            public void startIntentSender(IntentSender intentSender, @Nullable Intent intent, int i, int i1, int i2, Bundle bundle) throws IntentSender.SendIntentException {
                System.out.println();
            }

            @Override
            public void sendBroadcast(Intent intent) {
                System.out.println();
            }

            @Override
            public void sendBroadcast(Intent intent, @Nullable String s) {
                System.out.println();
            }

            @Override
            public void sendOrderedBroadcast(Intent intent, @Nullable String s) {
                System.out.println();
            }

            @Override
            public void sendOrderedBroadcast(@NonNull Intent intent, @Nullable String s, @Nullable BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i, @Nullable String s1, @Nullable Bundle bundle) {
                System.out.println();
            }

            @Override
            public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
                System.out.println();
            }

            @Override
            public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, @Nullable String s) {
                System.out.println();
            }

            @Override
            public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, @Nullable String s, BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i, @Nullable String s1, @Nullable Bundle bundle) {
                System.out.println();
            }

            @Override
            public void sendStickyBroadcast(Intent intent) {
                System.out.println();
            }

            @Override
            public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i, @Nullable String s, @Nullable Bundle bundle) {
                System.out.println();
            }

            @Override
            public void removeStickyBroadcast(Intent intent) {
                System.out.println();
            }

            @Override
            public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
                System.out.println();
            }

            @Override
            public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i, @Nullable String s, @Nullable Bundle bundle) {
                System.out.println();
            }

            @Override
            public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
                System.out.println();
            }

            @Nullable
            @Override
            public Intent registerReceiver(@Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
                return null;
            }

            @Nullable
            @Override
            public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable String s, @Nullable Handler handler) {
                return null;
            }

            @Override
            public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
                System.out.println();
            }

            @Nullable
            @Override
            public ComponentName startService(Intent intent) {
                return null;
            }

            @Override
            public boolean stopService(Intent intent) {
                return false;
            }

            @Override
            public boolean bindService(Intent intent, @NonNull ServiceConnection serviceConnection,  int i) {
                return false;
            }

            @Override
            public void unbindService(@NonNull ServiceConnection serviceConnection) {
                System.out.println();
            }

            @Override
            public boolean startInstrumentation(@NonNull ComponentName componentName, @Nullable String s, @Nullable Bundle bundle) {
                return false;
            }

            @Override
            public Object getSystemService(@NonNull String s) {
                return null;
            }

            @Override
            public int checkPermission(@NonNull String s, int i, int i1) {
                return PackageManager.PERMISSION_GRANTED;
            }

            @Override
            public int checkCallingPermission(@NonNull String s) {
                return PackageManager.PERMISSION_GRANTED;
            }

            @Override
            public int checkCallingOrSelfPermission(@NonNull String s) {
                return PackageManager.PERMISSION_GRANTED;
            }

            @Override
            public void enforcePermission(@NonNull String s, int i, int i1, @Nullable String s1) {

            }

            @Override
            public void enforceCallingPermission(@NonNull String s, @Nullable String s1) {
                System.out.println();
            }

            @Override
            public void enforceCallingOrSelfPermission(@NonNull String s, @Nullable String s1) {
                System.out.println();
            }

            @Override
            public void grantUriPermission(String s, Uri uri, int i) {
                System.out.println();
            }

            @Override
            public void revokeUriPermission(Uri uri, int i) {
                System.out.println();
            }

            @Override
            public int checkUriPermission(Uri uri, int i, int i1,  int i2) {
                return 0;
            }

            @Override
            public int checkCallingUriPermission(Uri uri,  int i) {
                return 0;
            }

            @Override
            public int checkCallingOrSelfUriPermission(Uri uri,  int i) {
                return 0;
            }

            @Override
            public int checkUriPermission(@Nullable Uri uri, @Nullable String s, @Nullable String s1, int i, int i1,  int i2) {
                return 0;
            }

            @Override
            public void enforceUriPermission(Uri uri, int i, int i1,  int i2, String s) {
                System.out.println();
            }

            @Override
            public void enforceCallingUriPermission(Uri uri,  int i, String s) {
                System.out.println();
            }

            @Override
            public void enforceCallingOrSelfUriPermission(Uri uri,  int i, String s) {
                System.out.println();
            }

            @Override
            public void enforceUriPermission(@Nullable Uri uri, @Nullable String s, @Nullable String s1, int i, int i1,  int i2, @Nullable String s2) {
                System.out.println();
            }

            @Override
            public Context createPackageContext(String s, int i) throws PackageManager.NameNotFoundException {
                return null;
            }

            @Override
            public Context createConfigurationContext(@NonNull Configuration configuration) {
                return null;
            }

            @Override
            public Context createDisplayContext(@NonNull Display display) {
                return null;
            }
        };
    }
}
