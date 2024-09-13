package com.example.capstone_donkki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.capstone_donkki.databinding.FragMypageBinding

class MypageFragment : Fragment() {
    private lateinit var mpageBinding: FragMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mpageBinding = FragMypageBinding.inflate(inflater, container, false)

        return mpageBinding.root
    }
}