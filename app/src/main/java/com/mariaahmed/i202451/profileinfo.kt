import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.mariaahmed.i202451.R

class profileinfo : AppCompatActivity() {
    // Initialize Firestore
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profileinfo)

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val contact = findViewById<EditText>(R.id.contactnumber)
        val updateinfo = findViewById<Button>(R.id.updateinfo)

        updateinfo.setOnClickListener {
            val nameTxt = name.text.toString()
            val emailTxt = email.text.toString()
            val contactTxt = contact.text.toString()

            // Check if all required fields are filled
            if (nameTxt.isEmpty() || emailTxt.isEmpty() || contactTxt.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create a HashMap to store user info
            val userInfo = hashMapOf(
                "name" to nameTxt,
                "email" to emailTxt,
                "contact" to contactTxt
            )

            // Update user info in Firestore
            updateUserProfile(userInfo)
        }

        // Setup country spinner
        val spinnerCountry = findViewById<Spinner>(R.id.my_spinner_country)
        val countries = arrayOf("Pakistan", "Oman", "France", "Japan")

        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountry.adapter = countryAdapter

        spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = countries[position]
                Toast.makeText(this@profileinfo, "Selected country: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Setup city spinner
        val spinnerCity = findViewById<Spinner>(R.id.my_spinner_city)
        val cities = arrayOf("Islamabad", "Muscat", "Paris", "Tokyo")

        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCity.adapter = cityAdapter

        spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = cities[position]
                Toast.makeText(this@profileinfo, "Selected city: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun updateUserProfile(userInfo: HashMap<String, String>) {
        // Assuming user1 is the user's ID
        val userRef = db.collection("users").document("user1")

        // Update user info in Firestore
        userRef
            .update(userInfo as Map<String, Any>)
            .addOnSuccessListener {
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error updating profile: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
