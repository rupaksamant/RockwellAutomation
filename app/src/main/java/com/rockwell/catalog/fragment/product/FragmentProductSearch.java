package com.rockwell.catalog.fragment.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.controller.ProductScreenController;
import com.rockwell.catalog.customview.ProductHeaderLayout;

/**
 * Created by Techjini on 1/10/2017.
 */

public class FragmentProductSearch extends BaseFragment {
    private ProductScreenController mHeaderInteractionListener;
    private View mSearchRootView;

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

        headerLayout = (ProductHeaderLayout) mSearchRootView.findViewById(R.id.browse_header_layout);
        headerLayout.findViewById(R.id.product_browse_tab_layout).setVisibility(View.VISIBLE);
        headerLayout.setHeaderInteractionListener(mHeaderInteractionListener);
//        headerLayout.setHeaderInteractionListener(mHeaderInteractionListener);
        // Tablayout initialization
//        mProdController = new ProductBrowseController(this);
//        mProdController.initViews();

        return mSearchRootView;
    }
    ProductHeaderLayout headerLayout;
    public void setBrowseSearchChangeListener(ProductScreenController browseSearchChangeListener) {
        this.mHeaderInteractionListener = browseSearchChangeListener;
    }
}
