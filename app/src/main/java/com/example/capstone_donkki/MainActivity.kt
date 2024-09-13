package com.example.capstone_donkki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone_donkki.databinding.ActMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val binding: ActMainBinding by lazy { ActMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setBottomNavigationView()

        //초기 화면 설정
        if (savedInstanceState == null) {
            binding.bnvMainnav.selectedItemId = R.id.frag_home
        }
    }

    fun setBottomNavigationView() {
        binding.bnvMainnav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.frag_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, MainFragment()).commit()
                    true
                }

                R.id.frag_recipt -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, ReciptFragment()).commit()
                    true
                }

                R.id.frag_cashbook -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, CashbookFragment()).commit()
                    true
                }

                R.id.frag_mypage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, MypageFragment()).commit()
                    true
                }

                R.id.frag_setting -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, SettingFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}