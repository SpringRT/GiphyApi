package com.a11.giphyapi.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GifImage {

    @SerializedName("fixed_width")
    @Expose
    private GifParameters gifParameters;

    public GifParameters getImageUrl() {
        return gifParameters;
    }

    public void setImageUrl(GifParameters gifParameters) {
        this.gifParameters = gifParameters;
    }
}
