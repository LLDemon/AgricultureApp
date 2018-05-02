package com.example.kimdemon.agricultureapp.Utils;

import android.content.Context;
import android.util.TypedValue;

public class ScreenUtil {

    //常用单位转换的辅助类

    public ScreenUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");

    }

    public static int dp2px(Context context,float dpVal){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal,context.getResources().getDisplayMetrics());

    }
}
