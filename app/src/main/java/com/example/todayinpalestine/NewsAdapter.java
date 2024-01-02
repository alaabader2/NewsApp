package com.example.todayinpalestine;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.List;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsAdapter.ViewHolder holder, int position) {
        final News news = newsList.get(position);
        holder.newTitle.setText(news.getTitle());
        holder.newsDesc.setText(news.getDesc());
        holder.newsDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(news.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });

        holder.newsName.setText(news.getName());
        Glide.with(context).load(news.getImageUrl())
                .thumbnail(0.5f)
                .into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView newTitle;
        TextView newsDesc;
        TextView newsName;
        ImageView newsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newTitle = itemView.findViewById(R.id.title_news);
            newsDesc = itemView.findViewById(R.id.desc_news);
            newsName = itemView.findViewById(R.id.name_news);
            newsImage = itemView.findViewById(R.id.image_news);
        }
    }

}