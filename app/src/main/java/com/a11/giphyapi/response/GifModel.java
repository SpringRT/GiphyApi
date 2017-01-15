package com.a11.giphyapi.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GifModel implements Serializable{

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("import_datetime")
    @Expose
    private String date;

    @SerializedName("images")
    @Expose
    private GifImage gifImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public GifImage getGifImage() {
        return gifImage;
    }

    public void setGifImage(GifImage gifImage) {
        this.gifImage = gifImage;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nUrl: " + url + "\nDate: " + date + "\nGif Url: " + gifImage.getImageUrl().getFixedWidthUrl();
    }
}
