package com.a11.giphyapi;


import com.a11.giphyapi.response.Gifs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyApi {

    @GET("/v1/gifs/trending")
    Call<Gifs> getTrending(@Query("api_key") String apiKey);

    @GET("/v1/gifs/search")
    Call<Gifs> getSearch(@Query("q") String query, @Query("api_key") String apiKey);

    @GET("/v1/stickers/trending")
    Call<Gifs> getStickers(@Query("api_key") String apiKey);
}
