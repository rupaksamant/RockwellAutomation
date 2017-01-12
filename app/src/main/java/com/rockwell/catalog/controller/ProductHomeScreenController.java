package com.rockwell.catalog.controller;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.customview.ProductHeaderLayout;
import com.rockwell.catalog.fragment.product.FragmentOne;
import com.rockwell.catalog.fragment.product.FragmentProductBrowse;
import com.rockwell.catalog.fragment.product.FragmentProductHomeScreen;
import com.rockwell.catalog.fragment.product.FragmentProductSearch;
import com.rockwell.catalog.listener.OnProductHeaderInteractionListener;

/**
 * Created by Techjini on 1/6/2017.
 */

public class ProductHomeScreenController implements OnProductHeaderInteractionListener {

    private FragmentProductHomeScreen mProductHomeFrag;

    private FragmentProductBrowse mBrowseFragment;
    private FragmentProductSearch mSearchFragment;

//    private DummyFragment mDummyFragment;
    private ProductHeaderLayout mHeaderLayout;

    public static OnProductHeaderInteractionListener mHeaderListener;

    public static final String FRAGMENT_TO_SHOW = "fragment_to_show";
    public static final String BROWSE_FRAGMENT = "browse_fragment";
    public static final String SEARCH_FRAGMENT = "search_fragment";

    public ProductHomeScreenController(BaseFragment fragment) {
        mProductHomeFrag = (FragmentProductHomeScreen) fragment;
        mHeaderListener = this;
    }

    public void initViews() {
        initHeaderLayout();
        displayDesiredFragment();
    }

    private void initHeaderLayout() {
        mHeaderLayout = (ProductHeaderLayout) mProductHomeFrag.mProductRootView.findViewById(R.id.product_home_header_layout);

//        mHeaderLayout.
//        mHeaderLayout.search.setOnClickListener(this);
//        mHeaderLayout.browseButton.setOnClickListener(this);
        /*mTabs = (TabLayout) mProductHomeFrag.mProductRootView.findViewById(R.id.product_header_layout);

        bindTabsWithEvent();

        RelativeLayout tabOne = (RelativeLayout) LayoutInflater.from(mProductHomeFrag.getActivity()).inflate(R.layout.custom_tab, null);
        ((TextView)tabOne.findViewById(R.id.tab)).setText(mProductHomeFrag.getString(R.string.tab_rw_automation));

        RelativeLayout tabTwo = (RelativeLayout) LayoutInflater.from(mProductHomeFrag.getActivity()).inflate(R.layout.custom_tab, null);
        ((TextView)tabTwo.findViewById(R.id.tab)).setText(mProductHomeFrag.getString(R.string.tab_encompass_partners));

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
        FragmentTransaction ft = mProductHomeFrag.getChildFragmentManager().beginTransaction();
        ft.replace(R.id.prodcut_parent_frag_container, fragment);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    private void displayDesiredFragment() {
//        for(int entry = 0; entry < (mProductHomeFrag).getChildFragmentManager().getBackStackEntryCount(); entry++){
//            System.out.println("Found fragment: " + (mProductHomeFrag).getChildFragmentManager() .getBackStackEntryAt(entry).getId());
//        }
        if(mProductHomeFrag.getArguments().get(FRAGMENT_TO_SHOW).equals(BROWSE_FRAGMENT)){
//            initHeaderLayout(true);
            Bundle args = new Bundle();
//            if(mBrowseFragment == null) {
                mBrowseFragment = FragmentProductBrowse.newInstance(args);
//            }
//            mRemoveFragment(mSearchFragment);
            if(mSearchFragment != null && mSearchFragment.isVisible()){
//                mRemoveFragment(mSearchFragment);
                replaceFragment(new FragmentOne());
            } else {
            }
            replaceFragment(mBrowseFragment);
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
                if(!mProductHomeFrag.getArguments().get(FRAGMENT_TO_SHOW).equals(BROWSE_FRAGMENT)) {
                    mProductHomeFrag.getArguments().putString(FRAGMENT_TO_SHOW, BROWSE_FRAGMENT);
                    displayDesiredFragment();
                }
                break;
            case R.id.icon_search:
                if(!mProductHomeFrag.getArguments().get(FRAGMENT_TO_SHOW).equals(SEARCH_FRAGMENT)) {
                    mProductHomeFrag.getArguments().putString(FRAGMENT_TO_SHOW, SEARCH_FRAGMENT);
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

    public ProductHeaderLayout getHeaderLayout() {
        return mHeaderLayout;
    }
}
