package com.a11.giphyapi.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GifParameters {

    @SerializedName("url")
    @Expose
    private String fixedWidthUrl;

    @SerializedName("width")
    @Expose
    private int width;

    @SerializedName("height")
    @Expose
    private int height;

    public String getFixedWidthUrl() {
        return fixedWidthUrl;
    }

    public void setFixedWidthUrl(String fixedHeightUrl) {
        this.fixedWidthUrl = fixedHeightUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
