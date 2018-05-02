package com.example.kimdemon.agricultureapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.example.kimdemon.agricultureapp.R;
import com.example.kimdemon.agricultureapp.Utils.ScreenUtil;
import com.example.kimdemon.agricultureapp.models.HomeMenus;

import java.util.List;

public class HomeMenuAdapter extends BaseAdapter{
    private List<HomeMenus> menus;
    private Context context;

    public HomeMenuAdapter(List<HomeMenus> menus, Context context) {
        this.menus = menus;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int i) {
        return menus.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        RadioButton radioButton = new RadioButton(context);
        if (i == 8){
            radioButton.setText("更多");
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundColor(Color.WHITE);
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_launcher,0,0);
            radioButton.setCompoundDrawablePadding(ScreenUtil.dp2px(context,5));
            radioButton.setGravity(Gravity.CENTER);

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,HomeMenuAdapter.class);
                    context.startActivity(intent);
                }
            });
        }else {
            radioButton.setButtonDrawable(null);
            radioButton.setText(menus.get(i).getName());
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setBackgroundColor(Color.WHITE);
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0,menus.get(i).getImage(),0,0);
            radioButton.setCompoundDrawablePadding(ScreenUtil.dp2px(context,5));
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,menus.get(i).getUrl());
                    context.startActivity(intent);
                }
            });
        }
        return radioButton;
    }
}
