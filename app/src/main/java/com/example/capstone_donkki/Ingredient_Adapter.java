package com.example.capstone_donkki;


import android.content.ClipData;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NonNls;

import java.util.List;

public class Ingredient_Adapter extends RecyclerView.Adapter<Ingredient_Adapter.ItemViewHolder> {

    private List<IngredientData> IngredientList;

    public Ingredient_Adapter(List<IngredientData> IngredientList) {
        this.IngredientList = IngredientList;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView IngredientImage;
        public TextView IngredientName, expiration;

        public ItemViewHolder(View itemView) {
            super(itemView);
            IngredientImage = itemView.findViewById(R.id.iv_ingredient);
            IngredientName = itemView.findViewById(R.id.tv_ingredient);
            expiration = itemView.findViewById(R.id.tv_expiration);


        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View ItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_main, viewGroup, false);

        return new ItemViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
        IngredientData ingredient = IngredientList.get(i);
        viewHolder.expiration.setText(ingredient.getExpiration());
        viewHolder.IngredientName.setText(ingredient.getIngredientName());
        viewHolder.IngredientImage.setImageResource(ingredient.getIngredientImage());


    }

    @Override
    public int getItemCount() {
        return IngredientList.size();
    }

}
