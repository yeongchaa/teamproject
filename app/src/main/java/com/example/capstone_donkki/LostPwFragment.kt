package com.example.capstone_donkki

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LostPwFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frag_lostpw)

        // 전화번호 입력 필드와 인증 버튼 찾기
        val editTextPhoneNumber = findViewById<EditText>(R.id.editTextPhoneNumber)
        val buttonVerify = findViewById<Button>(R.id.phonenumberbtn)
        val confirmButton = findViewById<Button>(R.id.checkbtn)
        confirmButton.setOnClickListener {
            val intent = Intent(this, ResetPwFragment::class.java)
            startActivity(intent)
        }

        // 인증 버튼에 클릭 이벤트 리스너 설정
        buttonVerify.setOnClickListener {
            val phoneNumber = editTextPhoneNumber.text.toString()
            if (phoneNumber.isNotEmpty()) {
                // 전화번호 입력 시 대화상자 생성
                val dialog = AlertDialog.Builder(this).apply {
                    setMessage("시간 안에 인증번호를 입력하세요.")
                    setPositiveButton("확인") { _, _ -> }
                }
                dialog.show()
            } else {
                // 전화번호 입력 필드가 비어 있을 경우 토스트 메시지 출력
                Toast.makeText(this, "전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}