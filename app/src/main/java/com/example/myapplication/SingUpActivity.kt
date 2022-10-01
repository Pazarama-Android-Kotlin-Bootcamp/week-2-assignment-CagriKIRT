package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.models.UserValidator
import javax.xml.validation.Validator

class SingUpActivity : AppCompatActivity() {
    lateinit var et_userName: EditText
    lateinit var et_email: EditText
    lateinit var et_password: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()

        et_userName = findViewById(R.id.et_username)
        et_email = findViewById(R.id.et_emailAddress)
        et_password = findViewById(R.id.et_password)


    }

    fun onBack() {
        finish()
    }

    fun register(view: View) {

        var passwordError = UserValidator().validatePassword(password = et_password.text.toString())
        if (passwordError != null) {
            et_password.error = passwordError
        }
        var emailError = UserValidator().validateEmail(email = et_email.text.toString())
        if (emailError != null) {
            et_email.error = emailError
        }

        var userNameError = UserValidator().validateUserName(username = et_userName.text.toString())
        if (userNameError != null) {
            et_userName.error = userNameError
        }
        if (passwordError == null && emailError == null && userNameError == null) {
            Toast.makeText(this, "SIGN UP CORRECT", Toast.LENGTH_SHORT).show()
        }
    }


}