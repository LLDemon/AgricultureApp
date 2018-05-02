package com.example.kimdemon.agricultureapp.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.kimdemon.agricultureapp.R;
import com.example.kimdemon.agricultureapp.fragment.Fragment_exchange;
import com.example.kimdemon.agricultureapp.fragment.Fragment_home;
import com.example.kimdemon.agricultureapp.fragment.Fragment_know;
import com.example.kimdemon.agricultureapp.fragment.Fragment_mine;
import com.example.kimdemon.agricultureapp.fragment.Fragment_question;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    Fragment_home fragmentHome;
    Fragment_know fragmentKnow;
    Fragment_question fragmentQuestion;
    Fragment_exchange fragmentExchange;
    Fragment_mine fragmentMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.main_frameLayout_main, new Fragment_home());
        fragmentTransaction.commit();

        radioGroup = (RadioGroup)findViewById(R.id.main_rb_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.main_rb_navigation_home:
                        if (fragmentHome==null){
                            fragmentHome = new Fragment_home();
                        }
                        changFragment(fragmentHome);
                        break;
                    case R.id.main_rb_navigation_know:
                        if (fragmentKnow==null){
                            fragmentKnow = new Fragment_know();
                        }
                        changFragment(fragmentKnow);
                        break;
                    case R.id.main_rb_navigation_question:
                        if (fragmentQuestion==null){
                            fragmentQuestion = new Fragment_question();
                        }
                        changFragment(fragmentQuestion);
                        break;
                    case R.id.main_rb_navigation_exchange:
                        if (fragmentExchange==null){
                            fragmentExchange = new Fragment_exchange();
                        }
                        changFragment(fragmentExchange);
                        break;
                    case R.id.main_rb_navigation_me:
                        if (fragmentMine==null){
                            fragmentMine = new Fragment_mine();
                        }
                        changFragment(fragmentExchange);
                        break;
                }
            }
        });
    }

    private void changFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frameLayout_main,fragment);
        fragmentTransaction.commit();
    }
}
