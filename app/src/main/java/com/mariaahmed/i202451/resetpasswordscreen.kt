package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class resetpasswordscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resetpasswordscreen)

        val backbutton = findViewById<ImageView>(R.id.backarrow)
        val resetbutton = findViewById<Button>(R.id.reset_button)
        val login = findViewById<TextView>(R.id.login)

        resetbutton.setOnClickListener {
            reset()
        }

        backbutton.setOnClickListener{
            backscreen()
        }

        login.setOnClickListener {
            backtologinscreen()
        }

    }

    fun backscreen(){
        val backintent = Intent(this, forgotpassword::class.java)
        startActivity(backintent)
    }

    fun reset(){

        val resetintent = Intent(this, loginscreen::class.java)
        startActivity(resetintent)
    }

    fun backtologinscreen(){
         val loginintent = Intent(this, loginscreen::class.java)
        startActivity(loginintent)
    }


}