package com.example.capstone_donkki;

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

public class LostPwFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View LostPW = inflater.inflate(R.layout.frag_lostpw, container, false);

        EditText et_phoneNum=LostPW.findViewById(R.id.et_phoneNum);
        Button btn_verify=LostPW.findViewById(R.id.btn_certpnum);
        Button btn_confirm= LostPW.findViewById(R.id.btn_find);

        String phoneNum=et_phoneNum.getText().toString();

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!phoneNum.isEmpty()){
                    Toast.makeText(getActivity(), "시간 안에 인증번호를 입력하세요.", Toast.LENGTH_SHORT).show();

                    //TODO: 시간 제한 설정
                }else{
                    Toast.makeText(getActivity(), "전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return LostPW;
    }
}
