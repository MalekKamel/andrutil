package com.sha.kamel.andrutil;

import android.support.v4.app.FragmentManager;

/**
 * Created by Sha on 10/19/17.
 */

public class BackStackUtil {

    public static void clearBackStackOfFragments(FragmentManager fm){
        try{
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
