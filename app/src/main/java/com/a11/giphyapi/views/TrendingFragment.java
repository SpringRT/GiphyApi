package com.a11.giphyapi.views;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.a11.giphyapi.App;
import com.a11.giphyapi.GifsAdapter;
import com.a11.giphyapi.R;
import com.a11.giphyapi.response.GifModel;
import com.a11.giphyapi.response.Gifs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingFragment extends Fragment {

    private List<GifModel> gifs;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout refresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trending, container, false);
        gifs = new ArrayList<>();

        refresh = (SwipeRefreshLayout) view.findViewById(R.id.trending_refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateGifs();
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.trending_recycler_view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(getResources().getInteger(R.integer.column), 1));
        recyclerView.setAdapter(new GifsAdapter(getActivity(), gifs));

        progressBar = (ProgressBar) view.findViewById(R.id.trending_progress_bar);

        updateGifs();
        return view;
    }

    private void updateGifs(){
        progressBar.setVisibility(View.VISIBLE);
        App.getApi().getTrending(getResources().getString(R.string.api_key)).enqueue(new Callback<Gifs>() {
            @Override
            public void onResponse(Call<Gifs> call, Response<Gifs> response) {
                if (response.body() != null) {
                    gifs.clear();
                    gifs.addAll(response.body().getGifs());
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
                progressBar.setVisibility(View.INVISIBLE);
                refresh.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<Gifs> call, Throwable t) {
                Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
                refresh.setRefreshing(false);
            }
        });
    }
}
