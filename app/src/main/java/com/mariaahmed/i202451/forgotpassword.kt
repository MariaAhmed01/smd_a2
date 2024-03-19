package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class forgotpassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        val sendemail = findViewById<Button>(R.id.send_button)
        val backtologin = findViewById<TextView>(R.id.login)
        val backbutton = findViewById<ImageView>(R.id.backarrow)

        sendemail.setOnClickListener {
            onsendemail()
        }

        backtologin.setOnClickListener {
            onbacktologin()
        }

        backbutton.setOnClickListener{
            back()
        }

    }

    fun onsendemail(){
        val sendemailintent = Intent(this, resetpasswordscreen::class.java)
        startActivity(sendemailintent)
    }

    fun onbacktologin(){
        val backtologinintent = Intent(this, loginscreen::class.java)
        startActivity(backtologinintent)

    }

    fun back(){

        val backintent = Intent(this, loginscreen::class.java)
        startActivity(backintent)
    }
}