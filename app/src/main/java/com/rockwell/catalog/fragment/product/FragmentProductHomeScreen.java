package com.rockwell.catalog.fragment.product;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rockwell.catalog.R;
import com.rockwell.catalog.base.BaseFragment;
import com.rockwell.catalog.controller.ProductHomeScreenController;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentProductHomeScreen.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentProductHomeScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProductHomeScreen extends BaseFragment {
    public View mProductRootView;

    private ProductHomeScreenController mProductHomeScreenController;

    private OnFragmentInteractionListener mListener;

    public FragmentProductHomeScreen() {
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
    public static FragmentProductHomeScreen newInstance(Bundle args) {
        FragmentProductHomeScreen fragment = new FragmentProductHomeScreen();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mProductRootView = inflater.inflate(R.layout.fragment_product_home_screen, container, false);

        // Tablayout initialization
        mProductHomeScreenController = new ProductHomeScreenController(this);
        mProductHomeScreenController.initViews();

        return mProductRootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mHeaderListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public ProductHomeScreenController getProductHomeScreenController() {
        return mProductHomeScreenController;
    }
}
