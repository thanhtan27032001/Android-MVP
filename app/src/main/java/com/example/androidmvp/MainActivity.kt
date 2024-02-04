package com.example.androidmvp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidmvp.databinding.ActivityMainBinding
import com.example.androidmvp.model.User

class MainActivity : AppCompatActivity(), LoginInterface {
    private lateinit var loginPresenter: LoginPresenter

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var tvMessage: TextView
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setView()
        setEvent()
        setData()

    }

    override fun setEvent() {
        btnLogin.setOnClickListener {
            login()
        }
    }

    override fun setView() {
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        tvMessage = findViewById(R.id.tvMessage)
        btnLogin = findViewById(R.id.btnLogin)
    }

    override fun setData() {
        loginPresenter = LoginPresenter(this)
    }

    private fun login() {
        val email = edtEmail.text.toString()
        val password = edtPassword.text.toString()
        val user = User(email, password)
        loginPresenter.login(user)
    }
    override fun loginSuccess() {
        tvMessage.text = "Login successfully"
    }

    override fun loginError() {
        tvMessage.text = "Login error"
    }
}