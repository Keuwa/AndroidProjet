package com.example.vincent.androidproject.api;

import com.example.vincent.androidproject.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vincent on 17/05/2016.
 */

public interface Api {
    @GET("florent37/MyYoutube/master/myyoutube.json")
    Call <List<Video>> video();
}
