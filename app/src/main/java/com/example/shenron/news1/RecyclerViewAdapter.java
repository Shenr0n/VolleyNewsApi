package com.example.shenron.news1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shenron on 03-02-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<News> news = new ArrayList<>();
    Context context;
    public RecyclerViewAdapter(List<News> news,Context context) {
        this.news = news;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycler,parent,false);
    return new ViewHolder(rootview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.vol_title.setText(news.get(position).getClass_title());
        holder.vol_desc.setText(news.get(position).getClass_description());
        holder.vol_published.setText(news.get(position).getClass_published());
        Glide.with(context).load(news.get(position).getClass_img_url()).into(holder.vol_img);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView vol_title,vol_desc,vol_published;
        ImageView vol_img;
        public ViewHolder(View itemView) {
            super(itemView);
            vol_title = itemView.findViewById(R.id.volley_title);
            vol_desc = itemView.findViewById(R.id.volley_description);
            vol_published = itemView.findViewById(R.id.volley_published);
            vol_img = itemView.findViewById((R.id.volley_image));

        }
    }
}
