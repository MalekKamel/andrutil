package com.sha.kamel.andrutil.drawable;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.sha.kamel.andrutil.R;

/**
 * Created by Sha on 10/14/17.
 */

public final class DrawableUtil extends ContextWrapper{
    
    public DrawableUtil(Context context) {
        super(context);
    }

    public int getIdentifier(String name){
        return   getResources()
                .getIdentifier(
                        name,
                        "drawable",
                        getPackageName()
                );
    }

    public void setCustomDrawable(TextView tv, Context context, AttributeSet attrs)  throws Exception {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CompoundVectorTv);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);

            if (attr == R.styleable.CompoundVectorTv_drawable_top) {
                tv.setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        new VectorDrawableUtil(this).getByPath(a.getString(attr)),
                        null,
                        null);

            } else if (attr == R.styleable.CompoundVectorTv_drawable_bottom) {
                tv.setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        null,
                        null,
                        new VectorDrawableUtil(this).getByPath(a.getString(attr)));

            } else if (attr == R.styleable.CompoundVectorTv_drawable_left) {
                tv.setCompoundDrawablesWithIntrinsicBounds(
                        new VectorDrawableUtil(this).getByPath(a.getString(attr)),
                        null,
                        null,
                        null);

            } else if (attr == R.styleable.CompoundVectorTv_drawable_right) {
                tv.setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        null,
                        new VectorDrawableUtil(this).getByPath(a.getString(attr)),
                        null);

            }
        }
        a.recycle();
    }

}
