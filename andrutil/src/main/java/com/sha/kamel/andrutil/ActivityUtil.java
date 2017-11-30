package com.sha.kamel.andrutil;

import android.app.Activity;
import android.view.View;

/**
 * Created by Sha on 10/23/17.
 */

public final class ActivityUtil {

    public static View rootView(Activity activity){
        View v = activity.findViewById(android.R.id.content);
        // some devices you have to use
        if (v == null)
            v = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        return v;
    }
}
