package com.e.mainproject.storage.roomDatabase;

import androidx.room.Insert;

import com.e.mainproject.storage.roomDatabase.dog.DogBreedEntity;
import com.e.mainproject.storage.roomDatabase.dog.DogInsertCallback;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

import static io.reactivex.schedulers.Schedulers.io;

public class ProjectDataBaseHelper {

    ProjectDao projectDao;

    @Inject
    public ProjectDataBaseHelper(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    public void insertDog(List<DogBreedEntity> dogBreedEntityList, DogInsertCallback callback){
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                projectDao.insertAllDog(dogBreedEntityList);
            }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(io())
        .subscribe(
                new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        callback.insert(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.insert(false);

                    }
                }
        );

    }
}
