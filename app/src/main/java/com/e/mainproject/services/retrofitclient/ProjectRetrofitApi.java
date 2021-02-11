package com.e.mainproject.services.retrofitclient;

import com.e.mainproject.services.model.response.DogBreed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProjectRetrofitApi {

    @GET("DevTides/DogsApi/master/dogs.json")
    Call<ArrayList<DogBreed>> getDogs();
}
