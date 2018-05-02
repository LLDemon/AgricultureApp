package com.example.kimdemon.agricultureapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimdemon.agricultureapp.R;
import com.example.kimdemon.agricultureapp.models.HomeNews;

import java.util.List;

public class HomeNewsAdapter extends BaseAdapter{
    private List<HomeNews> homeNews;
    private Context context;

    public HomeNewsAdapter(List<HomeNews> homeNews, Context context) {
        this.homeNews = homeNews;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return homeNews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_home_list_news,null);

        if (convertView == null){
            ImageView pic = convertView.findViewById(R.id.home_tv_news_pic);
            TextView title = convertView.findViewById(R.id.home_tv_news_title);
            TextView date = convertView.findViewById(R.id.home_tv_news_date);
            TextView read = convertView.findViewById(R.id.home_tv_news_read);

            pic.setImageResource(homeNews.get(position).getImage());
            title.setText(homeNews.get(position).getTitle());
            date.setText(homeNews.get(position).getDate());
            read.setText(homeNews.get(position).getRead());

        }
        return convertView;
    }
}
