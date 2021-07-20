package com.example.dataftetchusingmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dataftetchusingmvvm.R;
import com.example.dataftetchusingmvvm.model.SuperHeroModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HeroRecyclerViewAdapter extends RecyclerView.Adapter<HeroRecyclerViewAdapter.HeroViewHolder> {

        Context mCtx;
        private List<SuperHeroModel> herolist;

    public HeroRecyclerViewAdapter(Context mCtx, List<SuperHeroModel> herolist) {
        this.mCtx = mCtx;
        this.herolist = herolist;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.superhero_recycler_layout,parent,false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroRecyclerViewAdapter.HeroViewHolder holder, int position) {

        SuperHeroModel list=herolist.get(position);
        holder.heroNmae.setText(list.getName());
        holder.heroRealName.setText(list.getRealName());
        Glide.with(mCtx).load(list.getImageUrl()).into(holder.heroImage);

    }

    @Override
    public int getItemCount() {

        return herolist.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder{

            CircleImageView heroImage;
            TextView heroNmae,heroRealName;

        public HeroViewHolder(View itemView) {
            super(itemView);
            heroImage=itemView.findViewById(R.id.hero_image);
            heroNmae=itemView.findViewById(R.id.hero_name);
            heroRealName=itemView.findViewById(R.id.real_name);
            //added
        }
    }
}
