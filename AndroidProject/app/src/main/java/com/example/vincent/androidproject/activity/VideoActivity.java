package com.example.vincent.androidproject.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private Button button;
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
        button = (Button) findViewById(R.id.button);



        if (intent != null){
            Video video = intent.getExtras().getParcelable("video");
            fab.setOnClickListener(new MyListener(video.getId(),pref));

            if(pref.getString("favoris","").contains(video.getId()))
                fab.setImageResource(R.drawable.ic_cancel_black_24dp);


            Picasso.with(imageView.getContext()).load(video.getImageUrl()).centerCrop().fit().into(imageView);
            title.setText(video.getName());
            description.setText(video.getDescription());

            final String path = video.getVideoUrl();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(path);
                    uri = Uri.parse("vnd.youtube:" + uri.getQueryParameter("v"));

                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    context.startActivity(intent);
                }
            });

        }

    }
}
