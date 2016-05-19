package com.example.vincent.androidproject.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.vincent.androidproject.R;
import com.example.vincent.androidproject.activity.recycler.MyAdapter;
import com.example.vincent.androidproject.api.Api;
import com.example.vincent.androidproject.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO utiliser le savedInstanceState

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        final Context context = this;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        Api api = retrofit.create(Api.class);

        // Create a call instance for looking up Retrofit contributors.
        Call<List<Video>> call = api.video();

        call.enqueue(new Callback <List<Video>>() {
            @Override
            public void onResponse(Call <List<Video>> call, Response<List<Video>> response) {
                int statusCode = response.code();
                List<Video> videos = response.body();


                //puis créer un MyAdapter, lui fournir notre liste de villes.
                //cet adapter servira à remplir notre recyclerview
                recyclerView.setAdapter(new MyAdapter(videos));
            }

            @Override
            public void onFailure(Call <List<Video>> call, Throwable t) {
                // Log error here since request failed
            }
        });

    }
}
