package com.rockwell.catalog.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseActivity;
import com.rockwell.catalog.utils.Constants;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            startHomeActivity();
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash_screen;
    }

    private void startHomeActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, HomeScreenActivity.class);
                startActivity(i);
                finish();
            }
        }, Constants.SPLASH_TIME_OUT);
    }
}
