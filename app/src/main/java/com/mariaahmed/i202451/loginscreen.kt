package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mariaahmed.i202451.Signup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.random.Random

class loginscreen : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginscreen)


        mAuth = FirebaseAuth.getInstance()

        val email = findViewById<TextView>(R.id.email)
        var  pass = findViewById<TextView>(R.id.password)
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgotpassword)
        val signUpTextView = findViewById<TextView>(R.id.signup_button)
        val loginbutton = findViewById<Button>(R.id.loginbutton)


        forgotPasswordTextView.setOnClickListener {
            OnforgotpasswordClicked()
        }

        signUpTextView.setOnClickListener {
            signupclicked()
        }

        loginbutton.setOnClickListener {
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

            loginbuttonclicked(emailTxt, passTxt)
        }



    }

    fun OnforgotpasswordClicked() {

        val forgotpasswordintent = Intent(this, forgotpassword::class.java)
        startActivity(forgotpasswordintent)
    }

    fun signupclicked() {

        val signupintent = Intent(this, Signup::class.java)
        startActivity(signupintent)
    }

    fun loginbuttonclicked(email:String,pass:String){

        mAuth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithEmail:success")
                    val user = mAuth.currentUser

                    /* var secondActivityIntent = Intent(this, SecondActivity::class.java)
                     startActivity(secondActivityIntent)*/

                    val loginintent = Intent(this, dashboard::class.java)
                    startActivity(loginintent)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(this,"User name or Password is incorrect",Toast.LENGTH_SHORT).show()

                }
            }

    }

}
