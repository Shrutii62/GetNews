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

public class Healthfragment extends Fragment {
    String api ="9682492ea089483d9e2209ddb6759529";
    ArrayList<Modelclass> modelclassesArrayList;
    Adapter adapter;
    String country= "in";
    private RecyclerView recyclerViewofhealth;
    private String Category = "health";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.helthfragment, null);

        recyclerViewofhealth=v.findViewById(R.id.recyclerViewofhealth);
        modelclassesArrayList = new ArrayList<>();
        recyclerViewofhealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new Adapter(getContext(),modelclassesArrayList);
        recyclerViewofhealth.setAdapter(adapter);


        findNews();
        return v;



    }

    private void findNews() {

        ApiUtilities.getApiInterface() .getCategoryNews(country, Category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful())
                {
                    modelclassesArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });    }
}


