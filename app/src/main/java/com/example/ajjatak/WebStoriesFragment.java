package com.example.ajjatak;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WebStoriesFragment extends Fragment {


    String apikey= "09dea45fcbd64eb2ab55e6c8fd633e17";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerofweb;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v= inflater.inflate(R.layout.fragment_web_stories, null);
//        recyclerofweb = v.findViewById(R.id.recyclerview_WebStories);
//        modelClassArrayList=new ArrayList<>();
//        recyclerofweb.setLayoutManager(new LinearLayoutManager(getContext()));
//        adapter = new Adapter(getContext(),modelClassArrayList);
//        recyclerofweb.setAdapter(adapter);

       // findNews();

        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getMainNewsCall(country, 100, apikey).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }
}