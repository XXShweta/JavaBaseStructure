package com.e.mainproject.storage.roomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.e.mainproject.storage.roomDatabase.dog.DogBreedEntity;

import java.util.List;

@Dao
public interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllDog(List<DogBreedEntity> list);
}
