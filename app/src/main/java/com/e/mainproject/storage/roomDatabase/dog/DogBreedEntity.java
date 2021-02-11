package com.e.mainproject.storage.roomDatabase.dog;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DogBreedEntity {
    @PrimaryKey(autoGenerate = true)
    public int uuid =0;
    public String breedId;
    public String dogBreed;
    public String imageURL;
}
