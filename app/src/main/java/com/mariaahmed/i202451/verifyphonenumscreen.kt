package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class verifyphonenumscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifyphonenumscreen)

        val backbutton = findViewById<ImageView>(R.id.backarrow)
        val verifybutton = findViewById<Button>(R.id.verify_button)

        backbutton.setOnClickListener{
            backscreen()
        }

        verifybutton.setOnClickListener{
            onclickverify()
        }
    }

    fun backscreen(){
        val backintent = Intent(this, Signup::class.java)
        startActivity(backintent)
    }
    fun onclickverify(){
        val verifyintent = Intent(this, dashboard::class.java)
        startActivity(verifyintent)
    }

}