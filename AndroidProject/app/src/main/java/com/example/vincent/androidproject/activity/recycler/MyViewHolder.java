package com.example.vincent.androidproject.activity.recycler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.androidproject.R;
import com.example.vincent.androidproject.activity.VideoActivity;
import com.example.vincent.androidproject.model.Video;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Vincent on 17/05/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private ImageView imageView;
    private TextView description;
    private TextView favorisTextView;
    private final Context context;


    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);


        favorisTextView = (TextView) itemView.findViewById(R.id.favoris);
        context = itemView.getContext();
        //c'est ici que l'on fait nos findView
        textView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        description = (TextView) itemView.findViewById(R.id.description);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Video video){
        final Video vid = video;




        //Todo Gérer l'affichage des favoris
        /* ca met en favoris de facon completement random
        
        SharedPreferences pref = itemView.getContext().getSharedPreferences("FAVORIS", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        ArrayList<String> favoris = gson.fromJson(pref.getString("favoris","fake"),ArrayList.class);
        Log.d("Bonjour",favoris.toString());
        if(contains(favoris,video.getId()))
        {
            favorisTextView.setVisibility(View.VISIBLE);
        }
*/


        textView.setText(video.getName());
        description.setText(video.getDescription());
        Picasso.with(imageView.getContext()).load(video.getImageUrl()).centerCrop().fit().into(imageView);

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoActivity.class);
                intent.putExtra("video",vid);
                context.startActivity(intent);
            }
        });
    }




    //Check if data exist
    boolean contains(ArrayList<String> list, String name) {
        for (String item : list) {
            if (item.equals(name)) {
                Log.d("contains","true");
                return true;
            }
        }
        return false;
    }
}