package com.rockwell.catalog.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseActivity;
import com.rockwell.catalog.controller.HomeScreenController;

public class HomeScreenActivity extends BaseActivity {

    private HomeScreenController mHomeScreenController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();
    }

    private void initializeView() {
        if(mHomeScreenController == null) {
            mHomeScreenController = new HomeScreenController(this, getFragmentManager());
        }
        mHomeScreenController.initViews(mRootView.findViewById(R.id.home_left_panel),
                mRootView.findViewById(R.id.home_right_panel));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home_screen;
    }
}
