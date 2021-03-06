package com.rockwell.catalog.fragment.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.controller.ProductHomeScreenController;
import com.rockwell.catalog.controller.ProductSearchController;

/**
 * Created by Techjini on 1/10/2017.
 */

public class FragmentProductSearch extends BaseFragment {
    private ProductHomeScreenController mHeaderInteractionListener;
    private View mSearchRootView;
    private ProductSearchController mProdSearchController;

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
        mSearchRootView = inflater.inflate(R.layout.fragment_product_search, container, false);

        mProdSearchController = new ProductSearchController(this);
        mProdSearchController.initViews();
        return mSearchRootView;
    }


    public void setBrowseSearchChangeListener(ProductHomeScreenController browseSearchChangeListener) {
        this.mHeaderInteractionListener = browseSearchChangeListener;
    }
}
