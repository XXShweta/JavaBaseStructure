package com.e.mainproject.services.di;

import com.e.mainproject.BuildConfig;
import com.e.mainproject.services.retrofitclient.ProjectRetrofitApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {NetworkModule.class})
public class ApiServiceModule {

    @Singleton
    @Provides
    ProjectRetrofitApi provideProjectApi(OkHttpClient client){
        return createRetrofit(BuildConfig.BASE_URL,client,GsonConverterFactory.create()).create(ProjectRetrofitApi.class);
    }

    private Retrofit createRetrofit(String baseUrl, OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder().baseUrl(baseUrl).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build();
    }
}
