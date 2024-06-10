package com.example.capstone_donkki

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FindEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_findemail)

        val missingEmail: TextView = findViewById(R.id.tv_missingemail)
        //TODO: Email 주소  DB에서 찾아서 띄우기
        //missingEmail.setText("")

        val btn_confirmEmail: Button = findViewById(R.id.btn_confrimEmail)
        btn_confirmEmail.setOnClickListener {
            val to_login: Intent = Intent(this, LoginActivity::class.java)
            startActivity(to_login)
            finish()
        }
    }
}