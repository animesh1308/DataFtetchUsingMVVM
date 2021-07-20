package com.example.dataftetchusingmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dataftetchusingmvvm.adapter.HeroRecyclerViewAdapter;
import com.example.dataftetchusingmvvm.model.SuperHeroModel;
import com.example.dataftetchusingmvvm.viewmodel.HeroViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    HeroRecyclerViewAdapter heroAdapter;
    RecyclerView heroRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroRecyclerview=findViewById(R.id.recycler_view);
        heroRecyclerview.setHasFixedSize(true);
        heroRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().hide();

        HeroViewModel heroViewModel=ViewModelProviders.of(this).get(HeroViewModel.class);
        heroViewModel.getHeros().observe(this, new Observer<List<SuperHeroModel>>() {
            @Override
            public void onChanged(List<SuperHeroModel> superHeroModels) {
                heroAdapter= new HeroRecyclerViewAdapter(MainActivity.this,superHeroModels);
                heroRecyclerview.setAdapter(heroAdapter);
            }
        });

    }
}