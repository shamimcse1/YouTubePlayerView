package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClick {
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<MyListData> arrayList = new ArrayList<>();
        arrayList.add(new MyListData("1FJHYqE0RDg","https://picsum.photos/200/300"));
        arrayList.add(new MyListData("aMrrWuTuNAY","https://picsum.photos/200/300"));
        arrayList.add(new MyListData("xakNOVaYLAg","https://picsum.photos/200/300"));
        arrayList.add(new MyListData("gNzPGI9goU0","https://picsum.photos/200/300"));


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter( arrayList,this,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void getOnClickPosition(int position, MyListData data) {
        Intent i = new Intent(this, VideoViewActivity.class);
        i.putExtra("videoId", data.getVideoId());
        startActivity(i);
    }
}