package com.example.vincent.androidproject.activity.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vincent.androidproject.R;
import com.example.vincent.androidproject.model.Video;

import java.util.List;

/**
 * Created by Vincent on 17/05/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<Video> list;

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<Video> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell,viewGroup,false);
        return new MyViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Video video = list.get(position);
        myViewHolder.bind(video);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}