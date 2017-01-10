package com.rockwell.catalog;

import android.app.Application;
import android.content.Context;

/**
 * Created by Techjini on 1/4/2017.
 */

public class RockwellApplication extends Application {

    private static RockwellApplication sInstance;
    private boolean mIsTablet;

    @Override
    public void onCreate() {
        super.onCreate();

//        NetworkManager.updateConnectivityStatus(this);

        sInstance = this;

//        TypefaceUtil.overrideFont(getApplicationContext());

        //Used to dump Out of memory exception
//        OomExceptionHandler.install(this);
    }

    public static Context getContext() {
        return sInstance;
    }

    public static synchronized RockwellApplication getInstance() {
        return sInstance;
    }

    public void setIsTablet(boolean isTablet) {
        mIsTablet = isTablet;
    }

    public boolean isTablet() {
        return mIsTablet;
    }
}
