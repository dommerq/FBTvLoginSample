package me.kentin.fbtvloginsample;

import android.app.Application;

import com.facebook.FacebookSdk;

public class FbTVLoginSample extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
