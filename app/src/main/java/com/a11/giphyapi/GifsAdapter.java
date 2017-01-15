package com.a11.giphyapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a11.giphyapi.response.GifModel;

import java.util.List;

public class GifsAdapter extends RecyclerView.Adapter<GifHolder> {

    private Context context;
    private List<GifModel> gifModels;

    public GifsAdapter(Context context, List<GifModel> gifModels){
        this.context = context;
        this.gifModels = gifModels;
    }

    @Override
    public GifHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gif, parent, false);
        return new GifHolder(v, context);
    }

    @Override
    public void onBindViewHolder(GifHolder holder, int position) {
        holder.bind(gifModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (gifModels == null){
            return 0;
        }
        return gifModels.size();
    }
}
