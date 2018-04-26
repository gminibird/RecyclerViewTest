package com.example.a.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by a on 2018/4/25.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<RecyclerItem> mItemList;
    private Context mContext;
    //保存当前 ViewHolder 在 Adapter 中的位置
    private int mPosition;
    private OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;

    public RecyclerAdapter(Context context, List<RecyclerItem> itemList) {
        mContext = context;
        mItemList = itemList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(mContext, mItemList.get(mPosition), parent);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        setListener(holder);
        mItemList.get(position).convert(holder);
    }

    @Override
    public int getItemViewType(int position) {
        mPosition = position;
        return mItemList.get(position).getType();
    }


    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public Context getContext() {
        return mContext;
    }

    protected void setListener(final RecyclerViewHolder holder) {
        if (mClickListener != null && !holder.getView().hasOnClickListeners()) {
            holder.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onClick(holder);
                }
            });
        }
        if (mLongClickListener != null && !holder.getView().hasOnClickListeners()) {
            holder.getView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mLongClickListener.onLongClick(holder);
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        mClickListener = l;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener l) {
        mLongClickListener = l;
    }

    public interface OnItemClickListener {
        void onClick(RecyclerViewHolder holder);
    }

    public interface OnItemLongClickListener {
        boolean onLongClick(RecyclerViewHolder holder);
    }
}