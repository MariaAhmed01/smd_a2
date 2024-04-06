import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.mariaahmed.i202451.R

class addmentor : AppCompatActivity() {

    private var selectedImageUri: Uri? = null

    private lateinit var upload_photo: ImageView
    private lateinit var b_addmentor: Button
    private lateinit var name: EditText
    private lateinit var description: EditText
    private lateinit var price: EditText
    private lateinit var spinnerStatus: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addmentor)

        upload_photo = findViewById<ImageView>(R.id.upload_photo)
        b_addmentor = findViewById<Button>(R.id.b_addmentor)
        name = findViewById<EditText>(R.id.name)
        description = findViewById<EditText>(R.id.description)
        price = findViewById<EditText>(R.id.price)

        // City spinner
        val spinnerStatus = findViewById<Spinner>(R.id.my_spinner_availability)
        val menuItemsStatus = arrayOf("Available", "Not Available")

        val statusAdapter = ArrayAdapter(this@addmentor, android.R.layout.simple_spinner_item, menuItemsStatus)
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerStatus.adapter = statusAdapter

        spinnerStatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = spinnerStatus.selectedItem.toString()
                Toast.makeText(this@addmentor, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Set click listener for image upload
        upload_photo.setOnClickListener {
            openGalleryForImage()
        }

        // Set click listener for add mentor button
        b_addmentor.setOnClickListener {
            // Check if all required fields are filled
            val nameText = name.text.toString()
            val descriptionText = description.text.toString()
            val priceText = price.text.toString()
            val statusText = spinnerStatus.selectedItem.toString()

            if (nameText.isNotEmpty() && descriptionText.isNotEmpty() && priceText.isNotEmpty() && selectedImageUri != null) {
                // Upload image to Firebase Storage
                uploadImageToFirebase(nameText, descriptionText, priceText.toDouble(), statusText)
            } else {
                Toast.makeText(this@addmentor, "Please fill in all fields and select an image", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        resultLauncher.launch(intent)
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            selectedImageUri = data?.data
            // Set selected image to ImageView or perform any other action
            findViewById<ImageView>(R.id.upload_photo)?.setImageURI(selectedImageUri)
        }
    }

    private fun uploadImageToFirebase(name: String, description: String, price: Double, status: String) {
        val storage = Firebase.storage
        val storageRef = storage.reference
        val imagesRef = storageRef.child("images/${System.currentTimeMillis()}")

        imagesRef.putFile(selectedImageUri!!)
            .addOnSuccessListener {
                imagesRef.downloadUrl.addOnSuccessListener { uri ->
                    val imageUrl = uri.toString()

                    // Access a Cloud Firestore instance
                    val db = Firebase.firestore

                    // Create a new mentor with the data
                    val mentor = hashMapOf(
                        "name" to name,
                        "description" to description,
                        "price" to price,
                        "status" to status,
                        "imageUrl" to imageUrl
                    )

                    // Add a new document with a generated ID
                    db.collection("mentors")
                        .add(mentor)
                        .addOnSuccessListener { documentReference ->
                            Toast.makeText(this@addmentor, "Mentor added successfully with ID: ${documentReference.id}", Toast.LENGTH_SHORT).show()
                            // Reset fields after successful upload if needed
                            //name.text = null // Clear text in EditText
                            //description.text = null // Clear text in EditText
                            //price.text = null // Clear text in EditText
                            spinnerStatus.setSelection(0) // Reset spinner to default selection
                            upload_photo.setImageURI(null) // Clear image in ImageView
                            selectedImageUri = null // Reset selectedImageUri
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this@addmentor, "Error adding mentor: $e", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this@addmentor, "Image upload failed: $exception", Toast.LENGTH_SHORT).show()
            }
    }
}
