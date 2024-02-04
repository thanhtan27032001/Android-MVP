package com.example.androidmvp.model

import android.util.Patterns

class User(
    var email: String,
    var password: String
) {
    fun isValidEmail(): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(): Boolean {
        return password.length > 6
    }
}