package com.rockwell.catalog.controller;

import android.view.View;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.customview.ProductHeaderLayout;
import com.rockwell.catalog.fragment.product.FragmentProductBrowse;
import com.rockwell.catalog.listener.OnProductHeaderListener;

/**
 * Created by Techjini on 1/10/2017.
 */

public class ProductHeaderController implements View.OnClickListener{

    private OnProductHeaderListener mHeaderListener;

    public ProductHeaderController(View view) {
        init((ProductHeaderLayout)view);
    }

    private void init(ProductHeaderLayout view) {
        mHeaderListener = view.headerInteractionListener;

        view.browseButton.setOnClickListener(this);
        view.search.setOnClickListener(this);
        view.expandCollapse.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_browse:
                mHeaderListener.onBrowseSearchSwitched(view.getId());
                break;
            case R.id.icon_search:
                mHeaderListener.onBrowseSearchSwitched(view.getId());
                break;
            case R.id.expand_collapse:
                mHeaderListener.onExpandCollapseClicked(view.getId());
                break;
        }
    }

    public void setEventListener(OnProductHeaderListener eventListener) {
        this.mHeaderListener = eventListener;
    }
}
