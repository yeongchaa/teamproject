package com.example.capstone_donkki

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LostEmailFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.frag_lostemail)
        /*
                // 엣지 투 엣지 디자인을 위한 인셋 적용
                ViewCompat.setOnApplyWindowInsetsListener(fab) { view, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                    insets
                }
        */
        // 전화번호 입력 필드와 인증 버튼 찾기
        val et_phonenum = findViewById<EditText>(R.id.et_phonenum)
        val btn_authorize = findViewById<Button>(R.id.btn_authorize)
        val btn_confirm = findViewById<Button>(R.id.btn_confirm)
        btn_confirm.setOnClickListener {
            val intent = Intent(this, FindEmailFragment::class.java)
            startActivity(intent)
            finish()
        }

        // 인증 버튼에 클릭 이벤트 리스너 설정
        btn_authorize.setOnClickListener {
            val phoneNumber = et_phonenum.text.toString()
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
    /*
        private fun enableEdgeToEdge() {
            // Edge-to-Edge 모드 활성화 (API 레벨에 따라 다를 수 있음)
            WindowInsetsCompat.Type.systemBars().let {
                ViewCompat.getWindowInsetsController(window.decorView)?.hide(it)
            }
        }

     */
}