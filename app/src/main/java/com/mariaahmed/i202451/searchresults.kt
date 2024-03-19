package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast

class searchresults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchresults)


        val homescreen = findViewById<ImageView>(R.id.house)
        val searchscreen = findViewById<ImageView>(R.id.search)
        val chatscreen = findViewById<ImageView>(R.id.chaticon)
        val profilescreen = findViewById<ImageView>(R.id.human)
        val backbutton = findViewById<ImageView>(R.id.backarrow)

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
        backbutton.setOnClickListener{
            back()
        }

        //city spinner
        val spinner = findViewById<Spinner>(R.id.my_spinner)
        val menuitems = arrayOf("name", "title", "alphabetically")

        val Adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, menuitems)
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = Adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = spinner.selectedItem.toString()
                Toast.makeText(this@searchresults, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
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
    fun back(){
        val backintent = Intent( this, searchscreen::class.java)
        startActivity(backintent)
    }

}