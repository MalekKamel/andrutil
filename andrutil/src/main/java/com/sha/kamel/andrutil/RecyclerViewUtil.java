package com.sha.kamel.andrutil;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sha.kamel.andrutil.init.Andrutil;

/**
 * Created by Sha on 9/22/17.
 */

public class RecyclerViewUtil{
    private RecyclerView rv;

    public enum Layout {
        L,
        G
    }

    public RecyclerViewUtil(RecyclerView rv) {
        this.rv = rv;
    }

    public void layoutManager(RecyclerViewUtil.Layout layout){
        setLayout(layout, 2);
    }

    public void layoutManager(RecyclerViewUtil.Layout layout, int SpanCount){
        setLayout(layout, SpanCount);
    }

    private void setLayout(RecyclerViewUtil.Layout layout, int spanCount) {

        switch (layout){
            case L:
                rv.setLayoutManager(new LinearLayoutManager(Andrutil.instance().context()));
                break;
            case G:
                rv.setLayoutManager(new GridLayoutManager(Andrutil.instance().context(), spanCount));
                break;
        }
    }


}
