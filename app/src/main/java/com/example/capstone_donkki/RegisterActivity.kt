package com.example.capstone_donkki

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_register)

        val et_regEmail: EditText = findViewById(R.id.et_regEmail)
        val et_regpw: EditText = findViewById(R.id.et_regpw)
        val et_regpwagn: EditText = findViewById(R.id.et_regpwagn)
        val spn_regage: Spinner = findViewById(R.id.spn_regage)

        val email = et_regEmail.text
        val pw = et_regpw.text
        val pwagn = et_regpwagn.text

        //TODO: 이메일 형식 검사
        val btn_dbcheck: Button = findViewById(R.id.btn_dblchk)
        val tv_dbcheck: TextView = findViewById(R.id.tv_dblchk)

        val pattern = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

        et_regEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (!pattern) {
                    et_regEmail.setText("")
                    et_regEmail.setHint("올바르지 않은 이메일 형식입니다.")
                    et_regEmail.setHintTextColor(resources.getColor(R.color.red))

                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })


        //TODO: 이메일 중복 검사<>DB에서 이메일 매칭 확익
        btn_dbcheck.setOnClickListener {
/*
            if () { //이메일 중복 확인: DB연결
                tv_dbcheck.setText("사용 불가능한 아이디입니다")
                //tv_dbcheck.setTextColor() 색상 변경
                tv_dbcheck.isVisible = true
            } else {
                tv_dbcheck.isVisible = true
            }
            */
        }


        //TODO: 비밀번호 일치 확인
        et_regpwagn.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                //텍스트 변경 완료시 호출
                //비밀번호 입력 감지, 일치 여부 검사
                if (pw != pwagn) {
                    et_regpwagn.setText("")
                    et_regpwagn.setHint("비밀번호가 일치하지 않습니다.")
                    et_regpwagn.setHintTextColor(resources.getColor(R.color.red))
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })


        //TODO: Spinner 배열 설정, 연결
        var spn_data = resources.getStringArray(R.array.age_spinner)
        var spnAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spn_data)
        spn_regage.adapter = spnAdapter
        spn_regage.setSelection(1)

        spn_regage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        //TODO: 회원가입 버튼 동작
        val btn_Register: Button = findViewById(R.id.btn_Register)
        btn_Register.setOnClickListener {
            val to_login: Intent = Intent(this, LoginActivity::class.java)
            startActivity(to_login)
            finish()

            //TODO: DB 사용자 데이터 등록

        }
        fun onDestroy() {
            super.onDestroy()
        }

    }
}