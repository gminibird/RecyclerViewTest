package com.example.a.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by a on 2018/4/25.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private View mView;
    private SparseArray<View> mViewMap = new SparseArray<>();

    public <T extends RecyclerItem> RecyclerViewHolder(Context context, T item, ViewGroup parent) {
        super(item.getView(context, parent));
        mView = itemView;
        mView.requestFocusFromTouch();
    }

    //返回根View
    public View getView() {
        return mView;
    }

    /**
     * 根据View的id来返回view实例
     */
    public <T extends View> T getViewById(int ResId) {
        View view = mViewMap.get(ResId);
        if (view == null) {
            view = mView.findViewById(ResId);
            mViewMap.put(ResId, view);
        }
        return (T) view;
    }
}