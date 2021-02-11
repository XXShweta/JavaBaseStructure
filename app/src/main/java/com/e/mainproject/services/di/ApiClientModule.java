package com.e.mainproject.services.di;

import android.content.Context;

import com.e.mainproject.services.retrofitclient.InternetHelper;
import com.e.mainproject.services.retrofitclient.ProjectRetrofitApi;
import com.e.mainproject.services.retrofitclient.ProjectRetrofitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiServiceModule.class})
public class ApiClientModule {

    @Provides
    @Singleton
    InternetHelper provideInternetHelper(Context context){
        return new InternetHelper(context);
    }

    @Provides
    @Singleton
    ProjectRetrofitClient provideApiRetrofitClient(Context context,
                                                   ProjectRetrofitApi projectRetrofitApi,
                                                   InternetHelper internetHelper){
        return new ProjectRetrofitClient(context,projectRetrofitApi,internetHelper);
    }
}
