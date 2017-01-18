package com.femtoapp.rootsence.lydaudition;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {

    RecyclerView recyclerView;

    private ItemAdapter itemAdapter;

    /** 选中的item */
    public static final int SELECTOR = 10;

    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        itemAdapter = new ItemAdapter(getApplicationContext());
        recyclerView.setAdapter(itemAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(layoutManager.findLastVisibleItemPosition()==SELECTOR||layoutManager.findFirstVisibleItemPosition()==SELECTOR){ //判断列表的显示区域的第一或最后一个是否是选中的item
                    recyclerView.stopScroll();
                    recyclerView.scrollToPosition(10);
                }
            }
        });

    }
}
