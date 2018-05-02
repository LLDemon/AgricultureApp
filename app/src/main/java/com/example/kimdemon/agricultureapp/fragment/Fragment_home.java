package com.example.kimdemon.agricultureapp.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.example.kimdemon.agricultureapp.R;
import com.example.kimdemon.agricultureapp.View.HomeGridView;
import com.example.kimdemon.agricultureapp.View.HomeListView;
import com.example.kimdemon.agricultureapp.activity.AgricultureProfessorActivity;
import com.example.kimdemon.agricultureapp.adapter.HomeMenuAdapter;
import com.example.kimdemon.agricultureapp.adapter.HomeNewsAdapter;
import com.example.kimdemon.agricultureapp.models.HomeMenus;
import com.example.kimdemon.agricultureapp.models.HomeNews;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Fragment_home extends Fragment {

    private Banner banner;
    private HomeGridView homeGridView;
    private HomeListView homeListView;
    private HomeMenuAdapter homeMenuAdapter;
    private HomeNewsAdapter homeNewsAdapter;

    private List<HomeMenus> menus;
    private List<HomeMenus> menus1;
    private List<HomeNews> homeNews;
    private List<HomeNews> homeNews1;
    private ArrayList<String> list_path;

    public Fragment_home(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        RefreshLayout refreshLayout = view.findViewById(R.id.home_refresh);
        banner = view.findViewById(R.id.home_banner);
        homeListView = view.findViewById(R.id.home_lv_news);
        homeGridView = view.findViewById(R.id.home_gv_menus);

        creatHomeMenus();
        initDate();
        initbanner();
        refreshlistener(refreshLayout);
    }


    //HomeMenus
    private void creatHomeMenus() {
        menus = new ArrayList<>();
        HomeMenus marketSate = new HomeMenus(R.mipmap.ic_launcher,"市场行情",
                AgricultureProfessorActivity.class);
        HomeMenus agricultureProfessorActivity = new HomeMenus(R.mipmap.ic_launcher,"农业专家",
                AgricultureProfessorActivity.class);
        HomeMenus cooperate = new HomeMenus(R.mipmap.ic_launcher,"专业合作",
                AgricultureProfessorActivity.class);
        HomeMenus seasonable = new HomeMenus(R.mipmap.ic_launcher,"应时农事",
                AgricultureProfessorActivity.class);
        HomeMenus technology = new HomeMenus(R.mipmap.ic_launcher,"农业科技",
                AgricultureProfessorActivity.class);
        HomeMenus policy = new HomeMenus(R.mipmap.ic_launcher,"农业政策",
                AgricultureProfessorActivity.class);
        HomeMenus project = new HomeMenus(R.mipmap.ic_launcher,"科技专项",
                AgricultureProfessorActivity.class);
        HomeMenus typical = new HomeMenus(R.mipmap.ic_launcher,"示范典型",
                AgricultureProfessorActivity.class);

        menus.add(marketSate);
        menus.add(agricultureProfessorActivity);
        menus.add(cooperate);
        menus.add(seasonable);
        menus.add(technology);
        menus.add(policy);
        menus.add(project);
        menus.add(typical);
        homeMenuAdapter = new HomeMenuAdapter(menus,getActivity());
        homeGridView.setAdapter(homeMenuAdapter);

        //新闻数据
        homeNews = new ArrayList<>();
        for (int i = 0 ; i < 4 ; i++ ){
            homeNewsAdapter = new HomeNewsAdapter(homeNews,getActivity());
            homeListView.setAdapter(homeNewsAdapter);
        }

            homeNews1 = new ArrayList<>();
    }



    //下拉刷新
    private void refreshlistener(RefreshLayout refreshLayout) {

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                   refreshLayout.finishRefresh(2000);


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {

                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    refreshLayout.finishLoadMore(2000);
        }
    });

    }

    //轮播图
    private void initbanner() {
        banner.setFocusable(true);
        banner.setFocusableInTouchMode(true);
        banner.requestFocus();
        banner.setImageLoader(new MyLoader());
        banner.setImages(list_path);
        banner.setBannerAnimation(Transformer.Default);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();

    }

    private void initDate() {
        list_path = new ArrayList<>();
        list_path.add("http://object.jsnjy.net.cn/OSS/20180420/c4c048d7df1f48f696c235479a0e5dfd.JPG");
        list_path.add("http://object.jsnjy.net.cn/OSS/20171121/20171121145500487.jpg");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180418/25a724f273594598a892dfb14f2e7303.jpg");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180409/079c9dc1ca74470e9beffaac25350e83.jpg");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180309/20180309002607779.JPG");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180103/20180103190917483.jpg");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180328/20180328145730090.jpg");

    }

    public void onBannerClick(int position){
        Log.i("tag","你点了第" + position + "张轮播图");
    }

    private class MyLoader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
