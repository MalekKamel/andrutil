package com.sha.kamel.andrutil;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.sha.kamel.andrutil.init.Andrutil;

/**
 * Created by Sha on 10/23/17.
 */

public final class KeyboardUtil{

    public static void toggle(boolean shouldShow) {
        InputMethodManager imm = (InputMethodManager) Andrutil.instance().context().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm == null) return;

        if (shouldShow)
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
        else
            imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
    }

    public static void toggle(boolean shouldShow, View view) {
        if(view == null) return;
        InputMethodManager imm = (InputMethodManager)Andrutil.instance().context().getSystemService(Context.INPUT_METHOD_SERVICE);

        if(imm == null) return;

        if (shouldShow)
            imm.showSoftInput(view, 0);
        else
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
