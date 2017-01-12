package com.rockwell.catalog.controller;

import android.view.View;

import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.customview.ProductHeaderLayout;
import com.rockwell.catalog.fragment.product.FragmentProductHomeScreen;
import com.rockwell.catalog.fragment.product.FragmentProductSearch;

/**
 * Created by Techjini on 1/12/2017.
 */

public class ProductSearchController {
    private FragmentProductSearch mSearchFragment;
    private ProductHeaderLayout headerLayout;


    public ProductSearchController(BaseFragment fragment) {
        mSearchFragment = (FragmentProductSearch) fragment;
    }

    public void initViews() {
//        initFragments();
        initTabs();
    }

    private void initTabs() {

        FragmentProductHomeScreen parentFrag = (FragmentProductHomeScreen)mSearchFragment.getParentFragment();
        ProductHomeScreenController parentController = parentFrag.getProductHomeScreenController();


        headerLayout = (ProductHeaderLayout) parentController.getHeaderLayout();

        headerLayout.tablayout.setVisibility(View.GONE);


        /*mTabs = headerLayout.tabs;

        mTabs .removeAllTabs();

        bindTabsWithEvent();

        RelativeLayout tabOne = (RelativeLayout) LayoutInflater.from(mBrowseFragment.getActivity()).inflate(R.layout.custom_tab, null);
        ((TextView)tabOne.findViewById(R.id.tab)).setText(mBrowseFragment.getString(R.string.tab_rw_automation));

        RelativeLayout tabTwo = (RelativeLayout) LayoutInflater.from(mBrowseFragment.getActivity()).inflate(R.layout.custom_tab, null);
        ((TextView)tabTwo.findViewById(R.id.tab)).setText(mBrowseFragment.getString(R.string.tab_encompass_partners));

        mTabs.addTab(mTabs.newTab().setCustomView(tabOne),true);
        mTabs.addTab(mTabs.newTab().setCustomView(tabTwo));*/


    }
}
