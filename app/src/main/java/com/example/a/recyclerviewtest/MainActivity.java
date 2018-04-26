package com.example.a.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<RecyclerItem> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        final RecyclerAdapter adapter = new RecyclerAdapter(this, dataList);
        initData();
        adapter.setOnItemLongClickListener(new RecyclerAdapter.OnItemLongClickListener() {
            @Override
            public boolean onLongClick(RecyclerViewHolder holder) {
                CheckObservable.getInstance().notifyChanged();
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        RecyclerItem item;
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                item = new SendMsgItem("Nice to meet you. "+i);
            } else {
                item = new ReceiveMsgItem("Nice to meet you too. "+i);
            }
            dataList.add(item);
        }
    }
}
