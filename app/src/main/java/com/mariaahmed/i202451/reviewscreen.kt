package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class reviewscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviewscreen)

        val backbutton = findViewById<ImageView>(R.id.backarrow)
        val submit = findViewById<Button>(R.id.b_submit)

        backbutton.setOnClickListener{
            backscreen()
        }
        submit.setOnClickListener {
            submitfeedback()
        }

    }

    fun backscreen(){
        val backintent = Intent(this, mentorprofilescreen::class.java)
        startActivity(backintent)
    }
    fun submitfeedback(){
        val submitintent = Intent(this, mentorprofilescreen::class.java)
        startActivity(submitintent)
    }

}