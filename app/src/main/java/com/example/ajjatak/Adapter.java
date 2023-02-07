package com.example.ajjatak;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_xml, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder,@SuppressLint("RecyclerView")  int position) {

        ModelClass data = modelClassArrayList.get(position);
        Glide.with(context)
        .load(data.getUrlToImage())
                .into(holder.mimageview);
        holder.mheading.setText(data.getTitle());

        holder.mcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,WebViewActivity.class);
                intent.putExtra("url",data.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {return modelClassArrayList.size();}

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView mheading, mauthor, mtime;
            CardView mcardview;
            ImageView mimageview;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                mauthor = itemView.findViewById(R.id.auther);
                mheading = itemView.findViewById(R.id.mainheading);
                mimageview = itemView.findViewById(R.id.image_view);
                mcardview = itemView.findViewById(R.id.card_view);
            }
        }
    }
