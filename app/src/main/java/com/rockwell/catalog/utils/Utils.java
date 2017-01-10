package com.rockwell.catalog.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by Techjini on 1/4/2017.
 */

public class Utils {

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
