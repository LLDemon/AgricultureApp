package com.example.kimdemon.agricultureapp.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class HomeListView extends ListView{
    public HomeListView(Context context) {
        super(context);
    }

    public HomeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    重写该方法，达到使ListView适应ScrollView的效果
    protected void onMeasure(int widthMeasureSpec , int heightMeasureSpec){
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2 ,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec,expandSpec);
    }
}
