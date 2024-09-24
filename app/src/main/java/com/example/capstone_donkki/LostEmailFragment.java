package com.example.capstone_donkki;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LostEmailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View LostEmail = inflater.inflate(R.layout.frag_lostemail, container, false);

        EditText et_phonenum = LostEmail.findViewById(R.id.et_phonenum);
        Button btn_authorize = LostEmail.findViewById(R.id.btn_authorize);
        Button btn_confirm = LostEmail.findViewById(R.id.btn_confirm);

        //전화번호 입력 확인
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = et_phonenum.getText().toString();
                if (phoneNumber != "") {
                    Toast.makeText(getActivity(), "시간 안에 인증번호를 입력하세요.", Toast.LENGTH_SHORT).show();

                    //TODO: 인증번호 전송 절차

                } else {
                    //전화번호가 비어 있을 경우 토스트 메시지 출력
                    Toast.makeText(getActivity(), "전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return LostEmail;
    }
}
