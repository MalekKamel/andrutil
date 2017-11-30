package com.sha.kamel.andrutil.init;

import android.content.Context;

/**
 * Created by Sha on 11/30/17.
 */

public class Andrutil {
    private static final Andrutil ourInstance = new Andrutil();

    public Context applicationContext;

    public static Andrutil instance() {
        return ourInstance;
    }

    private Andrutil() {}

    public Context context(){
        if (applicationContext == null)
            throw new RuntimeException("You must initialize Andrutil with application Context.");
        return applicationContext;
    }
}
