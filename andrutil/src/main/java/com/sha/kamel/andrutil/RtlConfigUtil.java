package com.sha.kamel.andrutil;

import com.sha.kamel.andrutil.init.Andrutil;

/**
 * Created by Sha on 11/30/17.
 */

public class RtlConfigUtil {

    public static boolean isRtl(){
        return Andrutil.instance().context().getResources().getBoolean(R.bool.is_right_to_left);
    }

}
