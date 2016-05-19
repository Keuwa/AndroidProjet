package com.example.vincent.androidproject.activity.listener;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.internal.bind.ArrayTypeAdapter;

import java.util.ArrayList;

/**
 * Created by Vincent on 18/05/2016.
 */
public class MyListener implements View.OnClickListener {
    String id;
    SharedPreferences pref;

    public MyListener(String id, SharedPreferences pref) {
        this.id = id;
        this.pref = pref;
    }

    @Override
    public void onClick(View v) {
        Gson gson = new Gson();
        ArrayList<String> favoris;
        if(!(pref.getString("favoris","").equals(""))){
            favoris = gson.fromJson(pref.getString("favoris","fake"),ArrayList.class);
            Log.d("Checkpoint","pref pas null ");
        }
        else{
            Log.d("Checkpoint","pref null ");
            favoris = new ArrayList<>();
        }
        favoris.add(id);

        Log.d("Favoris",pref.getString("favoris","def"));
        //// TODO: 18/05/2016  add strings to shared pref
        pref.edit().putString("favoris",gson.toJson(favoris)).apply();

        Log.d("Favoris",pref.getString("favoris","Bonjour"));


    }
}
