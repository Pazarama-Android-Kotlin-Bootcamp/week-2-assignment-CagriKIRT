package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.UserValidator


class MainActivity : AppCompatActivity() {
    lateinit var emailEV: EditText;
    lateinit var passwordEV: EditText
    lateinit var loginButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        emailEV = findViewById(R.id.et_emailAddress)

        passwordEV = findViewById(R.id.et_password)

        loginButton = findViewById(R.id.btn_login)

    }


    fun signUpClick(view:View) {
/*        startActivity(new Intent(action));  */
        val intent = Intent(this, SingUpActivity::class.java)
        startActivity(intent)
    }

    fun forgotPassword(view: View) {
        Toast.makeText(this, "Clicked on forgot password", Toast.LENGTH_SHORT).show()
    }

    fun loginOnClick(view: View) {
        var passwordError = UserValidator().validatePassword(password = passwordEV.text.toString())
        if (passwordError != null) {
            passwordEV.setError(passwordError)
        }
        var emailError = UserValidator().validateEmail(email = emailEV.text.toString())
        if (emailError != null) {
            emailEV.setError(emailError)
        }
        if(passwordError==null&&emailError==null){
            Toast.makeText(this, "LOG IN CORRECT", Toast.LENGTH_SHORT).show()
        }

    }


}