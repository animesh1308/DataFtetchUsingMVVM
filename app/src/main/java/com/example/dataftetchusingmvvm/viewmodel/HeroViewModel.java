package com.example.dataftetchusingmvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dataftetchusingmvvm.HeroApi;
import com.example.dataftetchusingmvvm.model.SuperHeroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroViewModel extends ViewModel {

    //read data asynchronously
    private MutableLiveData<List<SuperHeroModel>> herolist;

    //method to get the live data
    public LiveData<List<SuperHeroModel>> getHeros(){

        if (herolist==null){
            herolist=new MutableLiveData<List<SuperHeroModel>>();
            loadHero();
        }
    return herolist;
    }
    //Method is using Retrofit to get JASON data from url
    private void loadHero(){

        Retrofit retrofit=new Retrofit.Builder()
                                      .baseUrl(HeroApi.BASE_URL)
                                      .addConverterFactory(GsonConverterFactory.create())
                                      .build();
        HeroApi api=retrofit.create(HeroApi.class);
        Call<List<SuperHeroModel>> call=api.getHeros();
        call.enqueue(new Callback<List<SuperHeroModel>>() {
            @Override
            public void onResponse(Call<List<SuperHeroModel>> call, Response<List<SuperHeroModel>> response) {
                herolist.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SuperHeroModel>> call, Throwable t) {

            }
        });

    }
}
