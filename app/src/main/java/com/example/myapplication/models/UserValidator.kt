package com.example.myapplication.models

class UserValidator {

    fun validateEmail(email: String): String? {
        var isEmailEmpty = email.isEmpty()
        var hasCorrectEmailLenght = email.length < 6
        var containsAt = email.contains('@')

        if (isEmailEmpty) {
            return "Please enter your email"
        }

        if (!containsAt) {
            return "Incorrect email"
        }

        if (hasCorrectEmailLenght) {
            return "Email is too short"
        }
        return null
    }
    fun validateUserName(username: String): String? {

        var isEmailEmpty = username.isEmpty()
        var hasCorrectLenght = username.length < 6

        if (isEmailEmpty) {
            return "Please enter your userName"
        }

        if (hasCorrectLenght) {
            return "Username is too short"
        }
        return null
    }



    fun validatePassword(password: String): String? {


        var isPasswordEmpty = password.isEmpty()

        var hasCorrectPasswordLenght = password.length < 6

        if (isPasswordEmpty) {
            return "Please enter your password"
        }

        if (hasCorrectPasswordLenght) {
            return "Password is too short"
        }

        return null

    }
}