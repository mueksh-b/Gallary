package com.app.gallery.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.app.gallery.models.Image;
import com.app.gallery.networking.ApiInterface;
import com.app.gallery.networking.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryRepo {
    private static final String TAG = "GalleryRepo";
    MutableLiveData<List<Image>> imagesList;
    ApiInterface apiInterface;

    public GalleryRepo() {
        apiInterface = RetrofitService.getInterface();
    }

    public MutableLiveData<List<Image>> getImages(){
        if(imagesList == null){
            imagesList = new MutableLiveData<>();
            fetchImages();
        }
        return imagesList;
    }

    private void fetchImages(){
        List<Image> list = new ArrayList<>();
        apiInterface.getImages(1).enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(@NonNull Call<List<Image>> call, @NonNull Response<List<Image>> response) {
                assert response.body() != null;
                if(response.isSuccessful()){
                    list.addAll(response.body());
                    imagesList.setValue(list);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Image>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
            }
        });
    }
}
