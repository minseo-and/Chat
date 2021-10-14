package com.example.chat_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.chat_app.R
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnSignUp : Button
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.et_email)
        edtPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_Login)
        btnSignUp = findViewById(R.id.btn_Signup)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            login(email, password)
        }
    }

    private fun login(email:String, password:String){
        //유저 로그인 정보 확인
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //유저 정보 확인 시 로그인
                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "유저 정보가 존재하지 않습니다", Toast.LENGTH_SHORT).show()
                }
            }
    }
}