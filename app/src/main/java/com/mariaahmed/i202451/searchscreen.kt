package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class searchscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchscreen)

        val homescreen = findViewById<ImageView>(R.id.house)
        val searchscreen = findViewById<ImageView>(R.id.search)
        val chatscreen = findViewById<ImageView>(R.id.chaticon)
        val profilescreen = findViewById<ImageView>(R.id.human)

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
    fun searchresultspage(){
        val searchintent = Intent(this, searchscreen::class.java)
        startActivity(searchintent)
    }
}