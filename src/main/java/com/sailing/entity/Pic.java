package com.sailing.entity;

public class Pic extends PicKey {
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "picUrl='" + picUrl + '\'' +
                '}';
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}