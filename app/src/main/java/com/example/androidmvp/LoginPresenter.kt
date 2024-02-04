package com.example.androidmvp

import com.example.androidmvp.model.User

class LoginPresenter(
    private var loginInterface: LoginInterface
) {
    fun login(user: User) {
        if (user.isValidEmail() && user.isValidPassword()) {
            loginInterface.loginSuccess()
        }
        else {
            loginInterface.loginError()
        }
    }
}