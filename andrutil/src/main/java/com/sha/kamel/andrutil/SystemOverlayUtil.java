package com.sha.kamel.andrutil;

import android.app.Activity;
import android.os.Build;
import android.provider.Settings;

/**
 * Created by Sha on 11/20/17.
 */

public class SystemOverlayUtil {
    public static final int OVERLAY_REQUEST_CODE = 251;

    public static boolean canDrawOverlays(Activity activity) {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(activity);
    }

}
