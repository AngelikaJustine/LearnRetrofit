package com.example.retrofittrial.retrofit;

import com.example.retrofittrial.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("data.php") Call<MainModel> getData();

}
