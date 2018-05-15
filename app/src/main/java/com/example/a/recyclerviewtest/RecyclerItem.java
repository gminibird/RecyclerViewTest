package com.example.a.recyclerviewtest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by a on 2018/4/25.
 */

public interface RecyclerItem {

    /**
     *@return 返回item的type,当使用多item时必须保证每个item返回不同的type
     */
    int getType();

    /**
     * 此方法在{@link RecyclerAdapter#onCreateViewHolder(ViewGroup, int)}
     * 内调用，你应该在此方法的实现中返回item的view对象
     * @return item view
     */
    View getView(Context context, ViewGroup parent);

    /**
     * 此方法在{@link RecyclerAdapter#onBindViewHolder(RecyclerViewHolder, int)}
     * 内调用,你应该在此方法的实现中进行item的view与数据的绑定
     * @param holder 当前item的{@link RecyclerViewHolder}
     */
    void convert(RecyclerViewHolder holder);
}