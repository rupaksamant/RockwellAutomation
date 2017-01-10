package com.rockwell.catalog.controller;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.fragment.product.FragmentProductBrowse;
import com.rockwell.catalog.fragment.product.FragmentProductHomeScreen;
import com.rockwell.catalog.fragment.product.FragmentProductSearch;
import com.rockwell.catalog.listener.OnProductHeaderListener;

/**
 * Created by Techjini on 1/6/2017.
 */

public class ProductScreenController implements OnProductHeaderListener {
    private FragmentProductHomeScreen mParentFrag;
    private FragmentProductBrowse mBrowseFragment;
    private FragmentProductSearch mSearchFragment;

    public static final String FRAGMENT_TO_SHOW = "fragment_to_show";
    public static final String BROWSE_FRAGMENT = "browse_fragment";
    public static final String SEARCH_FRAGMENT = "search_fragment";

    public ProductScreenController(BaseFragment fragment) {
        mParentFrag = (FragmentProductHomeScreen) fragment;
    }

    public void initViews() {
//        Button mBrowseButton = (Button) mParentFrag.mRootView.findViewById(R.id.btn_browse);
//        mBrowseButton.setOnClickListener(this);
        displayDesiredFragment();
//        initTabs();
    }

    private void initTabs() {
        /*mTabs = (TabLayout) mParentFrag.mRootView.findViewById(R.id.product_parent_tabs);

        bindTabsWithEvent();

        RelativeLayout tabOne = (RelativeLayout) LayoutInflater.from(mParentFrag.getActivity()).inflate(R.layout.custom_tab, null);
        ((TextView)tabOne.findViewById(R.id.tab)).setText(mParentFrag.getString(R.string.tab_rw_automation));

        RelativeLayout tabTwo = (RelativeLayout) LayoutInflater.from(mParentFrag.getActivity()).inflate(R.layout.custom_tab, null);
        ((TextView)tabTwo.findViewById(R.id.tab)).setText(mParentFrag.getString(R.string.tab_encompass_partners));

        mTabs.addTab(mTabs.newTab().setCustomView(tabOne),true);
        mTabs.addTab(mTabs.newTab().setCustomView(tabTwo));*/


    }

    /*private void bindTabsWithEvent() {
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
    }*/

    /*private void setCurrentTabFragment(int tabPosition)
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
    }*/

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = (mParentFrag).getChildFragmentManager().beginTransaction();
        ft.replace(R.id.prodcut_parent_frag_container, fragment);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public void mRemoveFragment(Fragment fragment){
        android.app.FragmentTransaction ft = (mParentFrag.getActivity()).getFragmentManager().beginTransaction();
//        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.remove(fragment);
        ft.commit();
    }

    private void displayDesiredFragment() {
        if(mParentFrag.getArguments().get(FRAGMENT_TO_SHOW).equals(BROWSE_FRAGMENT)){
            Bundle args = new Bundle();
//            if(mBrowseFragment == null) {
                mBrowseFragment = FragmentProductBrowse.newInstance(args);
//            }
            mRemoveFragment(mSearchFragment);
//            replaceFragment(mBrowseFragment);
            mBrowseFragment.setProductHeaderListener(this);
        } else {
//            if(mSearchFragment == null) {
                mSearchFragment = new FragmentProductSearch();
//            }
            replaceFragment(mSearchFragment);
            mSearchFragment.setBrowseSearchChangeListener(this);
        }
    }

    public void onClick(int id) {
        switch (id) {
            case R.id.btn_browse:
                if(!mParentFrag.getArguments().get(FRAGMENT_TO_SHOW).equals(BROWSE_FRAGMENT)) {
                    mParentFrag.getArguments().putString(FRAGMENT_TO_SHOW, BROWSE_FRAGMENT);
                    displayDesiredFragment();
                }
            case R.id.icon_search:
                if(!mParentFrag.getArguments().get(FRAGMENT_TO_SHOW).equals(SEARCH_FRAGMENT)) {
                    mParentFrag.getArguments().putString(FRAGMENT_TO_SHOW, SEARCH_FRAGMENT);
                    displayDesiredFragment();
                }
                break;

        }
    }

    @Override
    public void onBrowseSearchSwitched(int viewId) {
        onClick(viewId);
    }

    @Override
    public void onExpandCollapseClicked(int viewId) {

    }
}
