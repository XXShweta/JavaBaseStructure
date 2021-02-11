package com.e.mainproject.ui.viewmodel;

import android.util.Log;
import com.e.mainproject.services.ApiResponseCallBack;
import com.e.mainproject.services.model.response.DogBreed;
import com.e.mainproject.storage.roomDatabase.dog.DogBreedEntity;
import com.e.mainproject.storage.roomDatabase.dog.DogInsertCallback;
import com.e.mainproject.ui.base.BaseViewModel;
import com.e.mainproject.ui.business.usecase.ProjectMainUseCase;
import com.e.mainproject.ui.navigator.ProjectMainInterface;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProjectMainViewModel extends BaseViewModel<ProjectMainInterface> implements ApiResponseCallBack,
        DogInsertCallback {

    ProjectMainUseCase projectMainUseCase;

    @Inject
    public ProjectMainViewModel(ProjectMainUseCase projectMainUseCase){
        this.projectMainUseCase = projectMainUseCase;
    }

    public void getDogFromApi(){
        projectMainUseCase.getDogs(this);
    }


    @Override
    public void onSuccess(Object value) {
        if(value instanceof List<?>){
            ArrayList<DogBreed> list = (ArrayList<DogBreed>) value;
            insertDataToDB(list);
        }
    }

    private void insertDataToDB(ArrayList<DogBreed> list) {
        if(list != null && list.size()>0){
            ArrayList<DogBreedEntity> dogBreedEntities = new ArrayList<>();
            for(int i=0; i< list.size();i++){
                DogBreed dog = list.get(i);
                DogBreedEntity dogBreedEntity = new DogBreedEntity();
                dogBreedEntity.breedId = dog.getBreedId();
                dogBreedEntity.dogBreed = dog.getDogBreed();
                dogBreedEntity.imageURL = dog.getImageURL();
                dogBreedEntities.add(dogBreedEntity);
            }

            projectMainUseCase.insertDataToDB(dogBreedEntities,this);
        }

    }

    @Override
    public void onError(String error, int code) {
        Log.i("api","error");
    }

    @Override
    public void insert(Boolean value) {
        Log.i("insert",value+"");
    }
}
