package com.mariaahmed.i202451

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.random.Random


class Signup : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val contact = findViewById<EditText>(R.id.contactnumber)
        var  pass = findViewById<EditText>(R.id.password)
        val signupbutton = findViewById<Button>(R.id.signupbutton)
        val loginbutton = findViewById<TextView>(R.id.login_button)

        signupbutton.setOnClickListener {

            var emailTxt = email.text.toString()
            var passTxt = pass.text.toString()
            //if password field is empty
            if(emailTxt.isEmpty()) {
                email.error= "Please enter email"
                email.requestFocus()
                return@setOnClickListener
            }
            if(passTxt.isEmpty()) {
                pass.error= "Please enter password"
                pass.requestFocus()
                return@setOnClickListener
            }

            onsignupclicked(emailTxt, passTxt)
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

    fun onsignupclicked(email:String,pass:String){

        mAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Log.d("TAG", "createUserWithEmail:success")
                    val user = mAuth.currentUser

                    val signupintent = Intent(this, verifyphonenumscreen::class.java)
                    startActivity(signupintent)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }

    }

}