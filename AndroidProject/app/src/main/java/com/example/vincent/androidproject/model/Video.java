package com.example.vincent.androidproject.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vincent on 17/05/2016.
 */
public class Video implements Parcelable {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private String videoUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public static final Parcelable.Creator<Video> CREATOR = new Parcelable.Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel source)
        {
            return new Video(source);
        }
        @Override
        public Video[] newArray(int size)
        {
            return new Video[size];
        }
    };

    public Video(String id, String name, String description, String imageUrl, String videoUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }
    public Video (Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.imageUrl = in.readString();
        this.videoUrl = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(videoUrl);
    }
}
