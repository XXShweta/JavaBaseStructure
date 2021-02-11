package com.e.mainproject.ui.business.usecase;

import com.e.mainproject.services.ApiResponseCallBack;
import com.e.mainproject.services.retrofitclient.ProjectRetrofitClient;
import com.e.mainproject.storage.roomDatabase.ProjectDataBaseHelper;
import com.e.mainproject.storage.roomDatabase.dog.DogBreedEntity;
import com.e.mainproject.storage.roomDatabase.dog.DogInsertCallback;

import java.util.List;

import javax.inject.Inject;

public class ProjectMainUseCase {

    ProjectRetrofitClient projectRetrofitClient;
    ProjectDataBaseHelper projectDataBaseHelper;

    @Inject
    public ProjectMainUseCase(ProjectRetrofitClient projectRetrofitClient, ProjectDataBaseHelper projectDataBaseHelper){
        this.projectRetrofitClient = projectRetrofitClient;
        this.projectDataBaseHelper = projectDataBaseHelper;
    }

    public void getDogs(ApiResponseCallBack callBack){
        projectRetrofitClient.getDogs(callBack);
    }

    public void insertDataToDB(List<DogBreedEntity> dogBreedEntityList, DogInsertCallback callback){
        projectDataBaseHelper.insertDog(dogBreedEntityList,callback);
    }
}
