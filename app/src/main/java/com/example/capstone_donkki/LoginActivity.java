package com.example.capstone_donkki;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        EditText et_email = findViewById(R.id.et_email);
        EditText et_pw = findViewById(R.id.et_pw);

        String email = et_email.getText().toString();
        String pw = et_pw.getText().toString();

        //로그인 버튼>>메인 화면으로 연결(DB와 사용자 데이터 비교)
        Button btn_login = findViewById(R.id.btn_login);


        Button btn_missing = findViewById(R.id.btn_missuser);
        Button btn_reg = findViewById(R.id.btn_reg);
        Button btn_google = findViewById(R.id.btn_google);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: DB에 있는 이메일/비밀번호 받아오기
                String DB_email = "";
                String DB_pw = "";

                if (email == DB_email && pw == DB_pw) {
                    //사용자 정보 일치>MainActivity 이동
                    Toast.makeText(getApplicationContext(), "어서오세요, 환영합니다!", Toast.LENGTH_SHORT).show();

                    Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(toMain);
                    finish();

                } else if (email != DB_email || pw != DB_pw) {
                    //사용자 정보 불일치>입력 정보 초기화, 재인증
                    Toast.makeText(getApplicationContext(), "입력된 사용자 정보가 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                    et_email.setText("");
                    et_pw.setText("");
                }

            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toReg = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(toReg);
            }
        });

        btn_google.setOnClickListener(new View.OnClickListener() {
            //TODO: 구글 로그인 기능
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "어서오세요, 환영합니다!", Toast.LENGTH_SHORT).show();

                Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toMain);
                finish();
            }
        });

        btn_missing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_email.setText("");
                et_pw.setText("");

                Intent toMissing = new Intent(getApplicationContext(), MissingUserActivity.class);
                startActivity(toMissing);
            }
        });

    }
}
