package com.example.vincent.androidproject.activity.listener;

import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.example.vincent.androidproject.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Vincent on 18/05/2016.
 */
public class MyListener implements View.OnClickListener {
    String id;
    SharedPreferences pref;
    boolean snackBar; //If true, ne pas afficher la snackbar

    public MyListener(String id, SharedPreferences pref) {
        this.id = id;
        this.pref = pref;
    }

    //Check if data exist
    boolean contains(ArrayList<String> list, String name) {
        for (String item : list) {
            if (item.equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        Gson gson = new Gson();
        ArrayList<String> favoris;
        FloatingActionButton fab = (FloatingActionButton)v;
        if(!(pref.getString("favoris","").equals(""))){
            favoris = gson.fromJson(pref.getString("favoris","fake"),ArrayList.class);


        }
        else{
            Log.d("Checkpoint","pref null ");
            favoris = new ArrayList<>();
        }
        if(contains(favoris,id)){
            favoris.remove(favoris.indexOf(id));
            ///Afficher popup
            if(!snackBar){
                fab.setImageResource(R.drawable.ic_favorite_white_24dp);
                Snackbar.make(v, "Supprimé des favoris", Snackbar.LENGTH_LONG)
                        .show();
            }
        }
        else{
            favoris.add(id);
            if(!snackBar) {
                fab.setImageResource(R.drawable.ic_cancel_black_24dp);
                Snackbar.make(v, "Ajouté aux favoris", Snackbar.LENGTH_LONG)
                        .show();
            }
        }

        Log.d("Favoris",pref.getString("favoris","def"));
        //// TODO: 18/05/2016  add strings to shared pref
        pref.edit().putString("favoris",gson.toJson(favoris)).apply();

        Log.d("Favoris",pref.getString("favoris","Bonjour"));

    }
}