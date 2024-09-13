package com.example.capstone_donkki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.capstone_donkki.databinding.FragCashbookBinding

class CashbookFragment : Fragment() {
    private lateinit var cashbookBinding: FragCashbookBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cashbookBinding = FragCashbookBinding.inflate(inflater, container, false)

        return cashbookBinding.root
    }
}