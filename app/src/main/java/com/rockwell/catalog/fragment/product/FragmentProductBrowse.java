package com.rockwell.catalog.fragment.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.controller.ProductBrowseController;
import com.rockwell.catalog.controller.ProductScreenController;
import com.rockwell.catalog.listener.OnProductHeaderListener;

/**
 * Created by Techjini on 1/6/2017.
 */

public class FragmentProductBrowse extends BaseFragment {

    public View mBrowseRootView;
    private ProductBrowseController mProdController;
    public OnProductHeaderListener mHeaderInteractionListener;

    public FragmentProductBrowse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param args Parameter 1.
     * @return A new instance of fragment FragmentProductHomeScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProductBrowse newInstance(Bundle args) {
        FragmentProductBrowse fragment = new FragmentProductBrowse();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mBrowseRootView = inflater.inflate(R.layout.fragment_product_browse, container, false);

        // Tablayout initialization
        mProdController = new ProductBrowseController(this);
        mProdController.initViews();
        mProdController.setHeaderInterActionListener(mHeaderInteractionListener);
        return mBrowseRootView;
    }

    public void setProductHeaderListener(OnProductHeaderListener browseSearchChangeListener) {
        this.mHeaderInteractionListener = browseSearchChangeListener;

    }
}
