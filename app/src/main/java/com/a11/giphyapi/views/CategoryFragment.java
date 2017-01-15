package com.a11.giphyapi.views;


import android.support.v4.app.Fragment;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a11.giphyapi.R;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryFragment extends Fragment {

    private static final String CATEGORY_FOLDER = "category";

    private AssetManager assetManager;
    private RecyclerView recyclerView;
    private List<String> listCat;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assetManager = getActivity().getAssets();
        listCat = new ArrayList<>();
        listCat = loadCategory();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.category_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CategoryAdapter(listCat));

        return view;
    }

    private List<String> loadCategory(){

        try {
            System.out.println(Arrays.asList(assetManager.list(CATEGORY_FOLDER)));
            return Arrays.asList(assetManager.list(CATEGORY_FOLDER));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private class CategoryHolder extends RecyclerView.ViewHolder{

        private ImageView gifImageView;
        private TextView textViewName;
        private View view;

        public CategoryHolder(View itemView) {
            super(itemView);
            view = itemView;
            gifImageView = (ImageView) itemView.findViewById(R.id.item_category_image);
            textViewName = (TextView) itemView.findViewById(R.id.item_category_text);
        }

        private void bind(String filepath){
            Glide.with(getActivity())
                    .load(Uri.parse("file:///android_asset/" + CATEGORY_FOLDER + "/" + filepath))
                    .asGif()
                    .into(gifImageView);

            final String filename = filepath.replace(".gif", "");
            System.out.println(filepath);
            textViewName.setText(filename);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((MainActivity)getActivity()).changeCategory(filename);
                }
            });
        }
    }

    private class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder>{

        private List<String> categories;

        public CategoryAdapter(List<String> categories) {
            this.categories = categories;
        }

        @Override
        public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
            return new CategoryHolder(v);
        }

        @Override
        public void onBindViewHolder(CategoryHolder holder, int position) {
            holder.bind(categories.get(position));
            System.out.println(categories.get(position));
        }

        @Override
        public int getItemCount() {
            if (categories == null){
                return 0;
            }
            return categories.size();
        }
    }
}
