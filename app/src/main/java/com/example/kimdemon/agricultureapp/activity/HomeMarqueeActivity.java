package com.example.kimdemon.agricultureapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kimdemon.agricultureapp.R;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class HomeMarqueeActivity extends Activity{
    private MarqueeView marqueeView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);


        marqueeView = (MarqueeView) findViewById(R.id.home_mq_marqueeView);
        List<String> info = new ArrayList<>();
        info.add("1.大家好，我是");
        info.add("2.欢迎大家关注我");
        info.add("4.GitHub");
        info.add("5.新浪微博：");
        info.add("5.个人博客");
        info.add("6.微信公众号");
        marqueeView.startWithList(info);
        //点击事件
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(getApplicationContext(),String.valueOf(marqueeView.getPosition())+" . " + textView.getText(),Toast.LENGTH_LONG ).show();
            }
        });


    }

    public void onStart(){
        super.onStart();
        marqueeView.startFlipping();
    }

    public void onStop(){
        super.onStop();
        marqueeView.stopFlipping();
    }
}
