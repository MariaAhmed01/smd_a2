package com.mariaahmed.i202451

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class Signup : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signupbutton = findViewById<Button>(R.id.signupbutton)
        val loginbutton = findViewById<TextView>(R.id.login_button)

        signupbutton.setOnClickListener {
            onsignupclicked()
        }

        loginbutton.setOnClickListener {
            onloginclicked()
        }

        val spinner = findViewById<Spinner>(R.id.my_spinner_country)
        val menuitems_countries = arrayOf("Pakistan", "Oman", "France", "Japan")

        val country_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, menuitems_countries)
        country_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = country_adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = spinner.selectedItem.toString()
                Toast.makeText(this@Signup, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //city spinner
        val spinnercity = findViewById<Spinner>(R.id.my_spinner_city)
        val menuitemscities = arrayOf("Islamabad", "Muscat", "Paris", "Tokyo")

        val cityadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, menuitemscities)
        cityadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnercity.adapter = cityadapter

        spinnercity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = spinnercity.selectedItem.toString()
                Toast.makeText(this@Signup, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


    }

    fun onloginclicked(){

        val loginintent = Intent(this, loginscreen::class.java)
        startActivity(loginintent)
    }

    fun onsignupclicked(){

        val signupintent = Intent(this, verifyphonenumscreen::class.java)
        startActivity(signupintent)
    }

}