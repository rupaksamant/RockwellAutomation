package com.rockwell.catalog.fragment.product;


import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


import com.rockwell.catalog.R;
import com.rockwell.catalog.RockwellApplication;
import com.rockwell.catalog.adapter.GridViewAdapter;
import com.rockwell.catalog.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Mehul Rughani on 01-Dec-2015.
 */
public class FragmentOne extends BaseFragment {

    private GridView gridView;
    ArrayList<Drawable> allDrawableImages = new ArrayList<>();
    private TypedArray allImages;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_one, null);
        getAllWidgets(rootView);
        setAdapter();
        return rootView;
    }

    private void getAllWidgets(View view) {
        gridView = (GridView) view.findViewById(R.id.gridViewFragmentOne);
        allImages = getResources().obtainTypedArray(R.array.all_images);
    }

    private void setAdapter()
    {
        for (int i = 0; i < allImages.length(); i++) {
            allDrawableImages.add(allImages.getDrawable(i));
        }

        GridViewAdapter gridViewAdapter = new GridViewAdapter(RockwellApplication.getContext(), allDrawableImages);
        gridView.setAdapter(gridViewAdapter);
    }
}
