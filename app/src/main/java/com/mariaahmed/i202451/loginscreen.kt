package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mariaahmed.i202451.Signup

class loginscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginscreen)

        val forgotPasswordTextView = findViewById<TextView>(R.id.forgotpassword)
        val signUpTextView = findViewById<TextView>(R.id.signup_button)
        val loginbutton = findViewById<Button>(R.id.loginbutton)

        forgotPasswordTextView.setOnClickListener {
            OnforgotpasswordClicked()
        }

        signUpTextView.setOnClickListener {
            signupclicked()
        }

        loginbutton.setOnClickListener {
            loginbuttonclicked()
        }

    }

    fun OnforgotpasswordClicked() {

        val forgotpasswordintent = Intent(this, forgotpassword::class.java)
        startActivity(forgotpasswordintent)
    }

    fun signupclicked() {

        val signupintent = Intent(this, Signup::class.java)
        startActivity(signupintent)
    }

    fun loginbuttonclicked(){

        val loginintent = Intent(this, dashboard::class.java)
        startActivity(loginintent)
    }

}
