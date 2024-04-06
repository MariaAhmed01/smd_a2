import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mariaahmed.i202451.R
import com.mariaahmed.i202451.mentorprofilescreen

class reviewscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviewscreen)

        val backbutton = findViewById<ImageView>(R.id.backarrow)
        val submitButton = findViewById<Button>(R.id.b_submit)
        val reviewEditText = findViewById<EditText>(R.id.reviewbox) // Assuming EditText id is reviewEditText

        backbutton.setOnClickListener{
            backscreen()
        }
        submitButton.setOnClickListener {
            val reviewText = reviewEditText.text.toString()
            if (reviewText.isNotEmpty()) {
                uploadReviewToFirestore(reviewText)
            } else {
                // Handle empty review text error
            }
        }
    }

    private fun backscreen(){
        val backintent = Intent(this, mentorprofilescreen::class.java)
        startActivity(backintent)
    }

    private fun uploadReviewToFirestore(reviewText: String) {
        val db = Firebase.firestore
        val reviewData = hashMapOf(
            "reviewText" to reviewText
        )

        db.collection("reviews")
            .add(reviewData)
            .addOnSuccessListener { documentReference ->
                // Handle successful upload
                // For example, show a toast or navigate to another screen
            }
            .addOnFailureListener { e ->
                // Handle failure
                // For example, show an error message
            }
    }
}
