package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val homescreen = findViewById<ImageView>(R.id.house)
        val searchscreen = findViewById<ImageView>(R.id.search)
        val chatscreen = findViewById<ImageView>(R.id.chaticon)
        val profilescreen = findViewById<ImageView>(R.id.human)
        val mentor1 = findViewById<ImageView>(R.id.clickablementor)


        homescreen.setOnClickListener{
            gotodashboard()
        }
        searchscreen.setOnClickListener{
            gotosearch()
        }
        chatscreen.setOnClickListener{
            gotochat()
        }
        profilescreen.setOnClickListener{
            gotoprofile()
        }
        mentor1.setOnClickListener{
            mentorclicked()
        }

    }

    fun gotodashboard(){
        val homeintent = Intent(this, dashboard::class.java)
        startActivity(homeintent)
    }
    fun gotosearch(){
        val searchintent = Intent( this, searchscreen::class.java)
        startActivity(searchintent)
    }
    fun gotochat(){
        val chatintent = Intent( this, chatscreen::class.java)
        startActivity(chatintent)
    }
    fun gotoprofile(){
        val profileintent = Intent( this, profilescreen::class.java)
        startActivity(profileintent)
    }
    fun mentorclicked(){
        val mentorprofile = Intent(this, mentorprofilescreen::class.java)
        startActivity(mentorprofile)
    }
}