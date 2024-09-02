package com.example.capstone_donkki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone_donkki.databinding.FragMainBinding

class MainFragment : Fragment() {
    private lateinit var mainBinding: FragMainBinding
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainBinding = FragMainBinding.inflate(inflater, container, false)

        return mainBinding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)


        //TODO: 프레그먼트 연결
        val IngredientList = arrayListOf(
            //추후 서버 연동 과정 필요
            IngredientData(R.drawable.donkki_half, "식재료명", "0815"),
            IngredientData(R.drawable.donkki_half, "식재료명", "0815")
        )

        val rcv_ingredient: RecyclerView = findViewById(R.id.rcv_ingredient)
        rcv_ingredient.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcv_ingredient.setHasFixedSize(true)

        //어뎁터 호출-연결
        rcv_ingredient.adapter = Ingredient_Adapter(IngredientList)

    }
}