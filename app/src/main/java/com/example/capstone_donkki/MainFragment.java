package com.example.capstone_donkki;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private ArrayList<IngredientData> Ingredient;
    private ArrayList<SearchtagData> searchtag;
    private Ingredient_Adapter ingredient_adapter;
    private Searchtag_Adapter searchtag_adapter;
    private RecyclerView rcv_ingredient, rcv_searchtag;
    private LinearLayoutManager linearLayoutManager;
    private Button btn_search;
    private EditText et_search;
    private TextView tv_refmore;

    private ImageView iv_voice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View MainView = inflater.inflate(R.layout.frag_main, container, false);

        rcv_ingredient = MainView.findViewById(R.id.rcv_ingredient);
        ingredient_adapter = new Ingredient_Adapter(Ingredient);
        rcv_ingredient.setAdapter(ingredient_adapter);
        rcv_ingredient.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        rcv_searchtag = MainView.findViewById(R.id.rcv_searchtag);
        searchtag_adapter = new Searchtag_Adapter(searchtag);
        rcv_searchtag.setAdapter(searchtag_adapter);

        linearLayoutManager = new LinearLayoutManager(getContext());

        et_search = MainView.findViewById(R.id.et_search);
        btn_search = MainView.findViewById(R.id.btn_search);
        iv_voice = MainView.findViewById(R.id.iv_mic);

        tv_refmore = MainView.findViewById(R.id.tv_refmore);

        return MainView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InvokeIngredient();
    }

    private void InvokeIngredient() {
        //DB에서 데이터 가져오기
    }
}
