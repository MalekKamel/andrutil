package com.sha.kamel.andrutil.drawable;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import com.sha.kamel.andrutil.R;


/**
 * Created by Sha on 10/14/17.
 */

public final class VectorDrawableUtil extends ContextWrapper{

    public VectorDrawableUtil(Context context) {
        super(context);
    }

    public VectorDrawableCompat getById(int res){
        return VectorDrawableCompat.create(
                getResources(),
                res,
                null);
    }

//     public static VectorDrawableCompat createFromPath(String path){
//        return VectorDrawableCompat.create(path);
//    }

    public VectorDrawableCompat getByPath(String path) {
        String name = path.split("/")[2].replace(".xml", "");
        return getById(new DrawableUtil(this).getIdentifier(name));
    }

    public void setCustomDrawable(TextView tv, Context context, AttributeSet attrs)  throws Exception {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CompoundVectorTv);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);

            if (attr == R.styleable.CompoundVectorTv_drawable_top) {
                tv.setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        getByPath(a.getString(attr)),
                        null,
                        null);

            } else if (attr == R.styleable.CompoundVectorTv_drawable_bottom) {
                tv.setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        null,
                        null,
                        getByPath(a.getString(attr)));

            } else if (attr == R.styleable.CompoundVectorTv_drawable_left) {
                tv.setCompoundDrawablesWithIntrinsicBounds(
                        getByPath(a.getString(attr)),
                        null,
                        null,
                        null);

            } else if (attr == R.styleable.CompoundVectorTv_drawable_right) {
                tv.setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        null,
                        getByPath(a.getString(attr)),
                        null);

            }
        }
        a.recycle();
    }
}
