package com.example.lenovo.nongjiyun.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by CAI on 2018/5/2.
 */

public class myListView extends ListView {
    public myListView(Context context) {
        super(context);
    }

    public myListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public myListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
