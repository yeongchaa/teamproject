package com.example.capstone_donkki;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    boolean chkEmail = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_register);

        TextView tv_chkEmail = findViewById(R.id.tv_chkEmail);

        EditText et_email = findViewById(R.id.et_regEmail);
        EditText et_pw = findViewById(R.id.et_regpw);
        EditText et_pwagn = findViewById(R.id.et_regpwagn);
        Spinner spn_age = findViewById(R.id.spn_regage);

        String email = et_email.getText().toString();
        String passwd = et_pw.getText().toString();
        String passwd2 = et_pwagn.getText().toString();

        Button btn_chkEmail = findViewById(R.id.btn_chkEmail);
        Button btn_register = findViewById(R.id.btn_Register);

        Pattern emailPattern = Patterns.EMAIL_ADDRESS;

        btn_chkEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailPattern.matcher(email).matches()) {
                    //TODO: DB 이메일 획득, 비교

                    chkEmail = true;

                } else {
                    tv_chkEmail.setText("올바르지 않은 이메일입니다.");
                    tv_chkEmail.setTextColor(getResources().getColor(R.color.red));
                    tv_chkEmail.setVisibility(View.VISIBLE);

                }
            }
        });

        //TODO: 스피너 배열 설정, 연결
/*
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
 */
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email == "" || passwd == "" || passwd2 == "") {
                    //Dialog 띄워서 정보 입력 확인
                    AlertDialog.Builder emptyInfo = new AlertDialog.Builder(RegisterActivity.this);
                    emptyInfo.setMessage("정보를 전부 입력해주세요.");
                    emptyInfo.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });


                } else if (chkEmail == false) {
                    //이메일 중복 체크 여부 확인
                    AlertDialog.Builder confirmEmail = new AlertDialog.Builder(RegisterActivity.this);
                    confirmEmail.setMessage("이메일 중복 검사를 확인해주세요.");
                    confirmEmail.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                } else if (passwd != passwd2) {
                    AlertDialog.Builder pwnotsame = new AlertDialog.Builder(RegisterActivity.this);
                    pwnotsame.setMessage("비밀번호가 일치하지 않습니다.\n다시 입력해주세요.");
                    pwnotsame.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            et_pwagn.setText("");
                        }
                    });
                }else{
                    //TODO: DB에 사용자 데이터 추가

                    //로그인 화면으로 이동
                    Intent toLogin=new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(toLogin);
                    finish();
                }
            }
        });


    }
}
