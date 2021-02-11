package com.e.mainproject.services.retrofitclient;

import android.content.Context;

import com.e.mainproject.services.ApiResponseCallBack;
import com.e.mainproject.services.model.response.DogBreed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectRetrofitClient {
    Context context;
    ProjectRetrofitApi projectRetrofitApi;
    InternetHelper internetHelper;

    public ProjectRetrofitClient(Context context, ProjectRetrofitApi projectRetrofitApi, InternetHelper internetHelper) {
        this.context = context;
        this.projectRetrofitApi = projectRetrofitApi;
        this.internetHelper = internetHelper;
    }

    public void getDogs(ApiResponseCallBack callBack){

        if(internetHelper.isInternetConnected()){
            projectRetrofitApi.getDogs().enqueue(new Callback<ArrayList<DogBreed>>() {
                @Override
                public void onResponse(Call<ArrayList<DogBreed>> call, Response<ArrayList<DogBreed>> response) {
                    if(response.code() ==200){
                        callBack.onSuccess(response.body());
                    }else {
                        callBack.onError(response.message(),response.code());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<DogBreed>> call, Throwable t) {
                        callBack.onError(t.getMessage(),500);
                }
            });
        }else {
            callBack.onError("No internet",404);
        }
    }
}
