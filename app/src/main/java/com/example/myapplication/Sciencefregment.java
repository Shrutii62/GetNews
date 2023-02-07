package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sciencefregment extends Fragment {

    String api ="9682492ea089483d9e2209ddb6759529";
    ArrayList<Modelclass> modelclassArrayList;
    Adapter adapter;
    String country= "in";
    private RecyclerView recyclerViewofscience;
    private String Category = "science";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sciencefragment, null, false);


        recyclerViewofscience=v.findViewById(R.id.recyclerViewofscience);
        modelclassArrayList = new ArrayList<>();
        recyclerViewofscience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new Adapter(getContext(),modelclassArrayList);
        recyclerViewofscience.setAdapter(adapter);


        findNews();
        return v;



    }

    private void findNews() {

        ApiUtilities.getApiInterface() .getCategoryNews(country, Category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful())
                {
                    modelclassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });    }
}

