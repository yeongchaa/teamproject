package com.example.capstone_donkki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.capstone_donkki.databinding.FragSettingBinding

class SettingFragment : Fragment() {
    private lateinit var setBinding: FragSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setBinding = FragSettingBinding.inflate(inflater, container, false)

        return setBinding.root
    }
}