package com.example.vincent.androidproject.activity.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.androidproject.R;
import com.example.vincent.androidproject.model.Video;
import com.squareup.picasso.Picasso;

/**
 * Created by Vincent on 17/05/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private ImageView imageView;
    private TextView description;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        textView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        description = (TextView) itemView.findViewById(R.id.description);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Video video){
        textView.setText(video.getName());
        description.setText(video.getDescription());
        Picasso.with(imageView.getContext()).load(video.getImageUrl()).centerCrop().fit().into(imageView);
    }
}