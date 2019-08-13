package com.example.observabledemo.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * provides data to recycler view
 */
public class Post {
    private String imageUrl;

    @BindingAdapter("imageUrl")
    public static void loadImageIrl(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
