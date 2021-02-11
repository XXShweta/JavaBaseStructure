package com.e.mainproject.services.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.Nullable;

public class DogBreed {

    @SerializedName("id")
    @Expose
    @Nullable
    private String breedId;

    @SerializedName("name")
    @Expose @Nullable
    private String dogBreed;

    @SerializedName("life_span")
    @Expose @Nullable
    private String lifeSpan;

    @SerializedName("breed_group")
    @Expose @Nullable
    private String breedGroup;

    @SerializedName("temperament")
    @Expose @Nullable
    private String temprament;

    @SerializedName("url")
    @Expose @Nullable
    private String imageURL;

    public DogBreed(@Nullable String breedId,@Nullable String dogBreed,@Nullable String lifeSpan,@Nullable String breedGroup,@Nullable String temprament,@Nullable String imageURL) {
        this.breedId = breedId;
        this.dogBreed = dogBreed;
        this.lifeSpan = lifeSpan;
        this.breedGroup = breedGroup;
        this.temprament = temprament;
        this.imageURL = imageURL;
    }

    @Nullable
    public String getBreedId() {
        return breedId;
    }

    @Nullable
    public void setBreedId(String breedId) {
        this.breedId = breedId;
    }

    @Nullable
    public String getDogBreed() {
        return dogBreed;
    }

    @Nullable
    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    @Nullable
    public String getLifeSpan() {
        return lifeSpan;
    }

    @Nullable
    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    @Nullable
    public String getBreedGroup() {
        return breedGroup;
    }

    @Nullable
    public void setBreedGroup(String breedGroup) {
        this.breedGroup = breedGroup;
    }

    @Nullable
    public String getTemprament() {
        return temprament;
    }

    @Nullable
    public void setTemprament(String temprament) {
        this.temprament = temprament;
    }

    @Nullable
    public String getImageURL() {
        return imageURL;
    }

    @Nullable
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
