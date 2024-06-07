package com.example.capstone_donkki

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)

        val et_email: EditText = findViewById(R.id.et_email)
        val et_pw: EditText = findViewById(R.id.et_pw)

        val email = et_email.text
        val pw = et_pw.text

        val btn_login: Button = findViewById(R.id.btn_login)
        btn_login.setOnClickListener {
            val to_main: Intent = Intent(this, MainActivity::class.java)
            //to_main.putExtra()
            startActivity(to_main)
        }

        val btn_reg: Button = findViewById(R.id.btn_reg)
        btn_reg.setOnClickListener {
            val to_reg: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(to_reg)
        }

        val btn_google_login: Button = findViewById(R.id.btn_google)
        btn_google_login.setOnClickListener {
            val to_main: Intent = Intent(this, MainActivity::class.java)
            startActivity(to_main)
        }
    }
}