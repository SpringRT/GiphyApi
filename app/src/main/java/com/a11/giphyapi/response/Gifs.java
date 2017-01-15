package com.a11.giphyapi.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Gifs {

    @SerializedName("data")
    @Expose
    private List<GifModel> gifs;

    public List<GifModel> getGifs() {
        return gifs;
    }

    public void setGifs(List<GifModel> gifs) {
        this.gifs = gifs;
    }
}
