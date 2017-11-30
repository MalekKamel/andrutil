package com.sha.kamel.andrutil;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Sha on 10/27/17.
 */

public final class PhoneUtil {

    public static void call(String phone, Activity activity) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phone));
        activity.startActivity(callIntent);
    }
}
