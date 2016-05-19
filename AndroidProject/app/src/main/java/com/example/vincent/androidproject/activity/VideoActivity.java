package com.example.vincent.androidproject.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.androidproject.R;
import com.example.vincent.androidproject.activity.listener.MyListener;
import com.example.vincent.androidproject.model.Video;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView description;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        final Context context = this;

        SharedPreferences pref = context.getSharedPreferences("FAVORIS", Context.MODE_PRIVATE);
        Intent intent = getIntent();


        fab =  (FloatingActionButton) findViewById(R.id.fab);
        imageView = (ImageView) findViewById(R.id.picture);
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);


        if (intent != null){
            Video video = intent.getExtras().getParcelable("video");
            fab.setOnClickListener(new MyListener(video.getId(),pref));


            Picasso.with(imageView.getContext()).load(video.getImageUrl()).centerCrop().fit().into(imageView);
            title.setText(video.getName());
            description.setText(video.getDescription());
        }

    }
}
