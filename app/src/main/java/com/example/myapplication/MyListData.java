package com.example.myapplication;

public class MyListData {
    private String videoId;
    private String imageUrl;


    public MyListData(String videoId, String imageUrl) {
        this.videoId = videoId;
        this.imageUrl = imageUrl;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}