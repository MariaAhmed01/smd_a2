package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class mentorprofilescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentorprofilescreen)

        val backbutton = findViewById<ImageView>(R.id.backarrow)
        val review = findViewById<ImageView>(R.id.iv_reviewbutton)
        val join = findViewById<ImageView>(R.id.iv_joincommunity)
        val book = findViewById<Button>(R.id.b_booksesh)

        backbutton.setOnClickListener{
            backscreen()
        }
        review.setOnClickListener{
            leavereview()
        }
        join.setOnClickListener{
            joincomm()
        }
        book.setOnClickListener {
            booksession()
        }


    }
    fun backscreen(){
        val backintent = Intent(this, dashboard::class.java)
        startActivity(backintent)
    }
    fun leavereview(){
        val leaveintent = Intent(this, reviewscreen::class.java)
        startActivity(leaveintent)
    }
    fun joincomm(){
        val joinintent = Intent(this, addmentor::class.java)
        startActivity(joinintent)
    }
    fun booksession(){
        val bookintent = Intent(this, calendar::class.java)
        startActivity(bookintent)
    }

}