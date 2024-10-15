package com.example.firebaselogintestwithjava;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.check).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.check) {
                signUp();
            }
        }
    };

    //회원가입 버튼 클릭 시 호출 함수
    private void signUp() {
        String id = ((EditText) findViewById(R.id.user_id)).getText().toString();
        String password = ((EditText) findViewById(R.id.user_password)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.user_password_check)).getText().toString();

        //editText들의 칸이 빈칸이 아닌 경우
        if (id.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {
            //비밀번호가 비밀번호 확인이랑 일치한 경우
            if (password.equals(passwordCheck)) {
                //비밀번호가 6자리 이상인 경우
                if (password.length() > 5 || passwordCheck.length() > 5) {
                    mAuth.createUserWithEmailAndPassword(id, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (user != null) {
                                    // 이메일 인증 보내기
                                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(SignUpActivity.this, "회원가입이 완료되었습니다. 이메일 인증을 완료해주세요.", Toast.LENGTH_LONG).show();
                                            } else {
                                                Toast.makeText(SignUpActivity.this, "이메일 인증 발송에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                            } else {
                                // 회원가입 실패 처리
                                Toast.makeText(SignUpActivity.this, "이미 등록된 이메일 입니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else { //비밀번호가 6자리 미만인 경우
                    Toast.makeText(SignUpActivity.this, "비밀번호를 최소 6자리로 입력해 주세요", Toast.LENGTH_SHORT).show();
                }
            } else {
                // 비밀번호가 일치하지 않는 경우
                Toast.makeText(SignUpActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        } else {
            // 입력값이 부족한 경우
            Toast.makeText(SignUpActivity.this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
        }
    }

}
