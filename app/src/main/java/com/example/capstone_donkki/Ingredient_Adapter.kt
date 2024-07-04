package com.example.capstone_donkki

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone_donkki.databinding.ActFindemailBinding

class Ingredient_Adapter(private val ingredientList: List<IngredientData>) :
    RecyclerView.Adapter<Ingredient_Adapter.CustomViewHolder>() {
    //새로운 뷰 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //리스트 아이템 포멧을 인플레이팅
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.ref_item_list, parent, false)

        return CustomViewHolder(view)
    }

    //뷰에 아이템 리스트를 바인딩
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val IngredientData = ingredientList[position]

        //이미지 배치
        holder.imageView.setImageResource(IngredientData.image)

        //텍스트 배치
        holder.textView.text=IngredientData.text
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class CustomViewHolder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val
    }
}