package com.example.capstone_donkki

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash)
        Handler().postDelayed(Runnable {
            val to_login = Intent(this, LoginActivity::class.java)
            startActivity(to_login)
            finish()
        }, 3000)
    }
}