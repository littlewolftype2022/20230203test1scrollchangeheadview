package com.example.a20230203test1scrollchangeheadview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class ScrollChangeHeadView extends ListView {

    private final View viewHead;
    private View topBar;

    @SuppressLint("InflateParams")
    public ScrollChangeHeadView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context,attrs,defStyleAttrs);

        viewHead = LayoutInflater.from(context).inflate(R.layout.scroll_change_head,null);
        addHeaderView(viewHead);//拿到listview事件


        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {//拿到listview事件

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (topBar!=null) {

                    int headTop = viewHead.getTop();//滚动中，获取高度变化
                    headTop = Math.abs(headTop);

                    topBar.getBackground().setAlpha(headTop * (255 / 100));//0-255,0是全透明。
                }
            }
        });

    }

    public void setTopBar(View v){
        topBar = v;
    }
}
