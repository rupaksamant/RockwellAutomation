package com.rockwell.catalog.base;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rockwell.catalog.RockwellApplication;
import com.rockwell.catalog.utils.Utils;

public abstract class BaseActivity extends AppCompatActivity {
    protected View mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Utils.isTablet(this)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            RockwellApplication.getInstance().setIsTablet(true);
//            getSupportActionBar().hide();
        } else {
            // For Phone set the configuration
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//            RockwellApplication.getInstance().setIsTablet(false);
        }
        mRootView = getLayoutInflater().inflate(getLayoutResourceId(), null);

        setContentView(mRootView);
    }

    protected abstract int getLayoutResourceId();
}
