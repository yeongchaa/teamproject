package com.example.capstone_donkki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        val IngredientList= arrayListOf(
            //추후 서버 연동 과정 필요
            IngredientData(R.drawable.donkki_half, "식재료명", "0815"),
            IngredientData(R.drawable.donkki_half, "식재료명", "0815")
        )

        val rcv_ingredient: RecyclerView= findViewById(R.id.rcv_ingredient)
        rcv_ingredient.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcv_ingredient.setHasFixedSize(true)

        //어뎁터 호출-연결
        rcv_ingredient.adapter=Ingredient_Adapter(IngredientList)

    }
}