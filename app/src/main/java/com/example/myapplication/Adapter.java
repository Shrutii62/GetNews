package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Modelclass> modelclassArrayList;
    private ViewHolder holder;
    private int position;

    public Adapter(Context context, ArrayList<Modelclass> modelclasses) {
        this.context = context;
        this.modelclassArrayList = modelclasses;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.holder = holder;
        this.position = position;

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url",modelclassArrayList.get(position).getUrl());
                context.startActivities(new Intent[]{intent});
            }
        });
        holder.mtime.setText("Published At:-"+modelclassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText((modelclassArrayList.get(position).getAuthor()));
        holder.mheading.setText((modelclassArrayList.get(position).getTitle()));
        holder.mcontent.setText((modelclassArrayList.get(position).getDescription()));
        Glide.with(context).load(modelclassArrayList.get(position).getUrltoImage()).into(holder.imageView);






    }

    @Override
    public int getItemCount() {
        return modelclassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading, mcontent, mauthor,mcategory,mtime;
        CardView cardView;
        ImageView imageView;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading= itemView.findViewById(R.id.mainHeading);
            mcontent= itemView.findViewById(R.id.content);
            mauthor= itemView.findViewById(R.id.Author);
            mtime= itemView.findViewById(R.id.DateTime);
            imageView= itemView.findViewById(R.id.imagrView);
            cardView= itemView.findViewById(R.id.cardView);
        }
    }
}
