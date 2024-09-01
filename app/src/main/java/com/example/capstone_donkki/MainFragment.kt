package com.example.capstone_donkki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.capstone_donkki.databinding.FragMainBinding

class MainFragment: Fragment() {
    private lateinit var mBinding: FragMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding=FragMainBinding.inflate(inflater, container, false)

        return mBinding.root
    }
}