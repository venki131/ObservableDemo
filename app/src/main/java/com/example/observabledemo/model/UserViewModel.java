package com.example.observabledemo.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    public MutableLiveData<Long> numberOfFollowers;
    public MutableLiveData<Long> numberOfPosts;
    public MutableLiveData<Long> numberOfFollowing;
    private String name;
    private String email;
    private String profileImage;
    private String about;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public MutableLiveData<Long> getNumberOfPosts() {
        if (numberOfPosts == null) {
            numberOfPosts = new MutableLiveData<>();
        }
        return numberOfPosts;
    }

    public MutableLiveData<Long> getNumberOfFollowing() {
        if (numberOfFollowing == null) {
            numberOfFollowing = new MutableLiveData<>();
        }
        return numberOfFollowing;
    }

    private MutableLiveData<Long> getNumberOfFollowers() {
        if (numberOfFollowers == null) {
            numberOfFollowers = new MutableLiveData<>();
        }
        return numberOfFollowers;
    }
}
