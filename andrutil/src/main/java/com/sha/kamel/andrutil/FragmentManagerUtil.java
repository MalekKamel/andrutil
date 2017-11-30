package com.sha.kamel.andrutil;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Sha on 10/29/17.
 */

public final class FragmentManagerUtil {

    public static Fragment getActiveFragment(FragmentManager fm) {
        if (fm.getBackStackEntryCount() == 0) {
            return null;
        }
        String tag = fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 1).getName();
        return fm.findFragmentByTag(tag);
    }

}
