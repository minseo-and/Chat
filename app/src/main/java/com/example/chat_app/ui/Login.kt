package com.example.chat_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.chat_app.R

class Login : AppCompatActivity() {

    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnSignUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = findViewById(R.id.et_email)
        edtPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_Login)
        btnSignUp = findViewById(R.id.btn_Signup)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}