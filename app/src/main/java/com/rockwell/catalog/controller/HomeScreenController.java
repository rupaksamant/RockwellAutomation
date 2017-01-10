package com.rockwell.catalog.controller;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;

import com.rockwell.catalog.R;
import com.rockwell.catalog.fragment.product.FragmentProductHomeScreen;


/**
 * Created by Techjini on 1/6/2017.
 */

public class HomeScreenController {

    private Activity mActivity;
    private FragmentManager mFragmentManager;

    private CoordinatorLayout mLeftPanel;
    private CoordinatorLayout mRightPanel;

    public HomeScreenController(Activity activity, FragmentManager fm) {
        mActivity = activity;
        mFragmentManager = fm;
    }

    public void initViews(View leftView, View rightView){
        mRightPanel = (CoordinatorLayout) rightView;
        mLeftPanel = (CoordinatorLayout) leftView;
        initLeftView();
        initRightView();
    }

    private void initLeftView() {

    }

    private void initRightView() {
        // TODO - On the basis of left panel selected item, right fragment has to set
        Bundle args = new Bundle();
        args.putString(ProductScreenController.FRAGMENT_TO_SHOW, ProductScreenController.BROWSE_FRAGMENT);
        Fragment rightFragment = FragmentProductHomeScreen.newInstance(args);
        replaceFragment(rightFragment);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.replace(R.id.home_right_panel, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
