package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyListDataHolder> {

    private final List<MyListData> dataList;
    private final ItemClick listener;
    private Context context;

    MyRecyclerViewAdapter(List<MyListData> dataList, ItemClick listener, Context context) {
        this.listener = listener;
        this.dataList = dataList;
        this.context =context;
    }

    @NonNull
    @Override
    public MyListDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyListDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListDataHolder holder, @SuppressLint("RecyclerView") int position) {
        MyListData myListData = dataList.get(position);

        Glide.with(context)
                .load(myListData.getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.myImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.getOnClickPosition(position,myListData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyListDataHolder extends RecyclerView.ViewHolder {
        private ImageView myImage;

        MyListDataHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.imageView);
        }
    }
}
