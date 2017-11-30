package com.sha.kamel.andrutil;

import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Sha on 11/3/17.
 */

public final class WindowUtil {

    public static void notTitle(AppCompatActivity activity){
        activity.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public static void showInLockMode(Window w){
        // TODO: put 'android:showOnLockScreen="true"' in activity tag in Manifest
        w.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON|
                WindowManager.LayoutParams.FLAG_DIM_BEHIND|
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        );
    }
}
