package com.example.dataftetchusingmvvm;

import com.example.dataftetchusingmvvm.model.SuperHeroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroApi {

    String BASE_URL="https://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<SuperHeroModel>> getHeros();

    @GET("marvel")
    getHero();
}
