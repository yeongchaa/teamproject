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

        //TODO: DB와 사용자 입력 데이터 비교, 회원 일치 여부 확인
        val btn_login: Button = findViewById(R.id.btn_login)
        btn_login.setOnClickListener {
            val to_main: Intent = Intent(this, MainActivity::class.java)
            //to_main.putExtra()
            startActivity(to_main)
            finish()
        }

        //TODO: 회원정보 분실 화면 연결
        val btn_missing: Button = findViewById(R.id.btn_missing)
        btn_missing.setOnClickListener {
            val to_missing: Intent = Intent(this, MissingActivity::class.java)
            startActivity(to_missing)
            finish()
        }

        //TODO: 회원가입 화면 연결
        val btn_reg: Button = findViewById(R.id.btn_reg)
        btn_reg.setOnClickListener {
            val to_reg: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(to_reg)
            finish()
        }

        //TODO: Google 로그인 API 연결, 구글 로그인 기능
        val btn_google_login: Button = findViewById(R.id.btn_google)
        btn_google_login.setOnClickListener {
            val to_main: Intent = Intent(this, MainActivity::class.java)
            startActivity(to_main)
            finish()
        }
    }
}