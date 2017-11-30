package com.sha.kamel.andrutil;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.ContextWrapper;

/**
 * Created by Sha on 11/3/17.
 */

public final class KeyguardManagerUtil extends ContextWrapper{

    public KeyguardManagerUtil(Context base) {
        super(base);
    }

    public boolean isScreenLocked() {
        KeyguardManager kgm = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        return kgm != null && kgm.inKeyguardRestrictedInputMode();
    }

}
