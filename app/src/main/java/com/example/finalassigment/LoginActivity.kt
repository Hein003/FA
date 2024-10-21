package com.example.finalassigment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText  // EditText for username input
    private lateinit var etPassword: EditText  // EditText for password input
    private lateinit var btnLogin: Button  // Button for login action

    private val loginViewModel: LoginViewModel by viewModels()  // ViewModel for login logic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)  // Set the content view to the login layout

        // Initialize views
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()  // Get username from EditText
            val password = etPassword.text.toString()  // Get password from EditText
            if (username.isNotEmpty() && password.isNotEmpty()) {
                loginViewModel.login(username, password)  // Call login method in ViewModel
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()  // Show error message
            }
        }

        // Observe login result from ViewModel
        loginViewModel.loginResult.observe(this, Observer { isLoggedIn ->
            if (isLoggedIn) {
                val intent = Intent(this, MainActivity::class.java)  // Create intent to start MainActivity
                startActivity(intent)  // Start MainActivity
                finish()  // Finish LoginActivity
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()  // Show invalid credentials message
            }
        })

        // Observe error messages from ViewModel
        loginViewModel.errorMessage.observe(this, Observer { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()  // Show error message
        })
    }
}
