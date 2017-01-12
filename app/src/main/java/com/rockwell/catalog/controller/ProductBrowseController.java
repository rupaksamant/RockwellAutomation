package com.rockwell.catalog.controller;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.customview.ProductHeaderLayout;
import com.rockwell.catalog.fragment.product.FragmentOne;
import com.rockwell.catalog.fragment.product.FragmentProductBrowse;
import com.rockwell.catalog.fragment.product.FragmentProductHomeScreen;
import com.rockwell.catalog.fragment.product.FragmentTwo;
import com.rockwell.catalog.listener.OnProductHeaderInteractionListener;

/**
 * Created by Techjini on 1/6/2017.
 */

public class ProductBrowseController {

    private FragmentProductBrowse mBrowseFragment;
    private TabLayout mTabs;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private OnProductHeaderInteractionListener headerInterActionListener;
    private ProductHeaderLayout headerLayout;
//    private FragmentProductBrowse mBrowseFragment;


    public ProductBrowseController(BaseFragment fragment) {
        mBrowseFragment = (FragmentProductBrowse) fragment;
    }

    public void initViews() {
        initFragments();
        initTabs();
    }

    private void initTabs() {

        FragmentProductHomeScreen parentFrag = (FragmentProductHomeScreen)mBrowseFragment.getParentFragment();
        ProductHomeScreenController parentController = parentFrag.getProductHomeScreenController();


        headerLayout = (ProductHeaderLayout) parentController.getHeaderLayout();

        headerLayout.tablayout.setVisibility(View.VISIBLE);


        mTabs = headerLayout.tabs;

        mTabs .removeAllTabs();

        bindTabsWithEvent();

        RelativeLayout tabOne = (RelativeLayout) LayoutInflater.from(mBrowseFragment.getActivity()).inflate(R.layout.custom_tab, null);
        ((TextView)tabOne.findViewById(R.id.tab)).setText(mBrowseFragment.getString(R.string.tab_rw_automation));

        RelativeLayout tabTwo = (RelativeLayout) LayoutInflater.from(mBrowseFragment.getActivity()).inflate(R.layout.custom_tab, null);
        ((TextView)tabTwo.findViewById(R.id.tab)).setText(mBrowseFragment.getString(R.string.tab_encompass_partners));

        mTabs.addTab(mTabs.newTab().setCustomView(tabOne),true);
        mTabs.addTab(mTabs.newTab().setCustomView(tabTwo));


    }

    private void bindTabsWithEvent() {
        mTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setCurrentTabFragment(int tabPosition)
    {
        switch (tabPosition)
        {
            case 0 :
                replaceFragment(fragmentOne);
                break;
            case 1 :
                replaceFragment(fragmentTwo);
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = (mBrowseFragment).getChildFragmentManager().beginTransaction();
        ft.replace(R.id.prodcut_browse_frag_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    private void initFragments() {
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
    }

    public void setHeaderInterActionListener(OnProductHeaderInteractionListener headerInterActionListener) {
        this.headerInterActionListener = headerInterActionListener;
        headerLayout.setHeaderInteractionListener(mBrowseFragment.mHeaderInteractionListener);
    }
}
