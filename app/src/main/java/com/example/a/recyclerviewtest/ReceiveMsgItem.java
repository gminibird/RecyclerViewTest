package com.example.a.recyclerviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by a on 2018/4/25.
 */

public class ReceiveMsgItem implements RecyclerItem, CheckObservable.Observer {

    boolean isVisible = false;
    boolean isChecked = false;
    String mMsg;


    public ReceiveMsgItem(String msg){
        mMsg = msg;
        CheckObservable.getInstance().registerObserver(this);
    }

    @Override
    public int getType() {
        return getClass().getName().hashCode();
    }

    @Override
    public View getView(Context context, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_receive_msg, parent, false);
    }

    @Override
    public void convert(RecyclerViewHolder holder) {
        final CheckBox checkBox = holder.getViewById(R.id.check_box);
        TextView textView = holder.getViewById(R.id.msg_receive);
        textView.setText(mMsg);
        View view = holder.getView();
        if (isVisible) {
            checkBox.setVisibility(View.VISIBLE);
            checkBox.setChecked(isChecked);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isChecked = !isChecked;
                    checkBox.setChecked(isChecked);
                }
            });
        } else {
            checkBox.setVisibility(View.GONE);
            view.setOnClickListener(null);
            isChecked = false;
        }
    }

    @Override
    public void changed() {
        isVisible = !isVisible;
    }
}
