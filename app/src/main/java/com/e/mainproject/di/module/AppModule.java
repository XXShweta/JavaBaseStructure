package com.e.mainproject.di.module;

import android.app.Application;
import android.content.Context;

import com.e.mainproject.services.di.ApiClientModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiClientModule.class, DBModule.class})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }
}
