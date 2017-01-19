package com.femtoapp.rootsence.lydaudition;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import static com.femtoapp.rootsence.lydaudition.MainActivity.SELECTOR;

/**
 * Created by mac on 2017/1/19 10:05.
 * 描述：
 */

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float downX,downY;

    @Override
    public boolean onInterceptTouchEvent (MotionEvent ev) {
        LinearLayout layout = (LinearLayout) this.getChildAt(0);
        RecyclerView recyclerView = (RecyclerView) layout.getChildAt(1);
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX = ev.getX();
                downY = ev.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                if(layoutManager.findLastVisibleItemPosition()==SELECTOR&&ev.getY()-downY>0){
                    Log.e("lyd","下滑拦截");

                    return true;
                }

                if(layoutManager.findFirstVisibleItemPosition()==SELECTOR&&ev.getY()-downY<0){
                    Log.e("lyd","上滑拦截");
                    return true;
                }
                break;
        }

        return super.onInterceptTouchEvent (ev);
    }
}
