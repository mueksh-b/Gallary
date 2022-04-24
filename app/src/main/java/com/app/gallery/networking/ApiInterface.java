package com.app.gallery.networking;

import com.app.gallery.models.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL = "https://picsum.photos/v2/";

    @GET("list")
    Call<List<Image>> getImages(@Query("page") int page);
}
