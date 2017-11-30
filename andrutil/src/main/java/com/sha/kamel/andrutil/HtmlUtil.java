package com.sha.kamel.andrutil;

import android.text.Html;
import android.text.Spanned;

/**
 * Created by Sha on 9/25/17.
 */

public final class HtmlUtil {


    public static String textFromHtml(String text){
       Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
            result = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        else
            result = Html.fromHtml(text);

           return result.toString();
    }
}
