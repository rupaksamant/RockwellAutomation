package com.rockwell.catalog.utils;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Techjini on 1/4/2017.
 */

public class DisplayMetrics {
    private static int sDisplayWidth = 0;
    private static int sDisplayHeight = 0;
    private static float sDisplayDensity = 0;

    private static void setDisplayMetrics(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        display.getMetrics(displayMetrics);
        sDisplayWidth = displayMetrics.widthPixels;
        sDisplayHeight = displayMetrics.heightPixels;
        sDisplayDensity = displayMetrics.density;
    }

    public static int getDisplayWidth(Context context) {
        if (sDisplayWidth == 0) {
            setDisplayMetrics(context);
        }
        return sDisplayWidth;
    }

    public static int getDisplayHeight(Context context) {
        if (sDisplayHeight == 0) {
            setDisplayMetrics(context);
        }
        return sDisplayHeight;
    }

    public static float getDisplayDensity(Context context) {
        if (sDisplayDensity == 0) {
            setDisplayMetrics(context);
        }
        return sDisplayDensity;
    }
}
