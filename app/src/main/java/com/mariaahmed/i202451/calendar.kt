package com.mariaahmed.i202451

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class calendar : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val backbutton = findViewById<ImageView>(R.id.backarrow)
        val submit = findViewById<Button>(R.id.b_book)

        backbutton.setOnClickListener {
            backscreen()
        }
        submit.setOnClickListener {
            booksession()
        }
    }

    private fun backscreen() {
        val backintent = Intent(this, mentorprofilescreen::class.java)
        startActivity(backintent)
    }

    private fun booksession() {
        // Update "session booked" in Firebase
        val sessionRef = db.collection("sessions").document("session1")

        sessionRef
            .update("status", "session booked")
            .addOnSuccessListener {
                // Handle success
                Toast.makeText(this, "Session booked successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                // Handle failure
                Toast.makeText(this, "Failed to book session: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

}
