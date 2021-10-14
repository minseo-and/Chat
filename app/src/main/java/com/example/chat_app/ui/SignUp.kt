package com.example.chat_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.chat_app.R
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var edtname : EditText
    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnSignUp : Button
    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        edtEmail = findViewById(R.id.et_email)
        edtPassword = findViewById(R.id.et_password)
        edtname = findViewById(R.id.et_name)
        btnSignUp = findViewById(R.id.btn_Signup)

        btnSignUp.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signUp(email, password)
        }
    }

    private fun signUp(email:String, password:String){
        //유저 회원가입
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //메인으로 이동
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUp, "이메일 또는 비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show()
                }
            }
    }
}