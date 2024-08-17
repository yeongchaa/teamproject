package com.example.capstone_donkki

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//리사이클러 뷰 어뎁터 설정
class Ingredient_Adapter(private val ingredientList: ArrayList<IngredientData>) :
    RecyclerView.Adapter<Ingredient_Adapter.CustomViewHolder>() {
    //새로운 뷰 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //화면 연결
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.ref_ingredient_list, parent, false)

        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                //리사이클러 뷰 내부 아이템 클릭 이벤트


            }
        }
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    override fun onBindViewHolder(holder: Ingredient_Adapter.CustomViewHolder, position: Int) {
        //뷰에 아이템 리스트를 바인딩
        holder.ingredientImage.setImageResource(ingredientList.get(position).ingredientImage)
        holder.ingredientText.text = ingredientList.get(position).ingredientName
        holder.expiration.text = ingredientList.get(position).expiration

    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ingredientImage = itemView.findViewById<ImageView>(R.id.iv_ingredient)    //식재료 이미지
        val ingredientText = itemView.findViewById<TextView>(R.id.tv_ingredient)      //식재료명
        val expiration = itemView.findViewById<TextView>(R.id.tv_expiration)          //소비기한

    }
}