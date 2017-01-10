package com.rockwell.catalog.customview;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rockwell.catalog.R;
import com.rockwell.catalog.controller.ProductHeaderController;
import com.rockwell.catalog.listener.OnProductHeaderListener;

/**
 * Created by Techjini on 1/10/2017.
 */

public class ProductHeaderLayout extends LinearLayout {
    public Button browseButton;
    public LinearLayout tablayout;
    public ImageView expandCollapse;
    public TabLayout tabs;
    public ImageView search;
    public OnProductHeaderListener headerInteractionListener;

    public ProductHeaderLayout(Context context) {
        super(context);
        init(context);
    }

    public ProductHeaderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProductHeaderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View header = inflate(getContext(), R.layout.product_header_layout, this);

        this.tabs = (TabLayout)findViewById(R.id.product_browse_tabs);
        this.expandCollapse = (ImageView)findViewById(R.id.expand_collapse);
        this.tablayout = (LinearLayout)findViewById(R.id.product_browse_tab_layout);
        this.search = (ImageView)findViewById(R.id.icon_search);
        this.browseButton = (Button)findViewById(R.id.btn_browse);

        controller = new ProductHeaderController(this);
    }
    ProductHeaderController controller;
    public void setHeaderInteractionListener(OnProductHeaderListener headerInteractionListener) {
        this.headerInteractionListener = headerInteractionListener;
        controller.setEventListener(headerInteractionListener);
    }


    /*public ProductHeaderLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/
}
