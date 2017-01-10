package com.rockwell.catalog.fragment.product;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rockwell.catalog.R;
import com.rockwell.catalog.RockwellApplication;
import com.rockwell.catalog.adapter.ListViewAdapter;
import com.rockwell.catalog.base.BaseFragment;

import java.util.ArrayList;


/**
 * Created by Mehul on 03-Dec-2015.
 */
public class FragmentTwo extends BaseFragment
{
    private ListView listView;
    TypedArray allContacts;
    ArrayList<String> allContactNames = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_two, null);
        getAllWidgets(rootView);
        setAdapter();
        return rootView;
    }

    private void getAllWidgets(View view) {
        listView = (ListView) view.findViewById(R.id.listFragmentTwo);

        allContacts = getResources().obtainTypedArray(R.array.all_contacts);

    }

    private void setAdapter()
    {
        for (int i = 0; i < allContacts.length(); i++) {
            allContactNames.add(allContacts.getString(i));
        }

        ListViewAdapter listViewAdapter= new ListViewAdapter(RockwellApplication.getContext(), allContactNames);
        listView.setAdapter(listViewAdapter);
    }
}
