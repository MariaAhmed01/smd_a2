package com.mariaahmed.i202451

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView

class profilescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilescreen)

        // Find the ImageView elements
        val bannerImageView = findViewById<ImageView>(R.id.bg_pic)
        val profileImageView = findViewById<ImageView>(R.id.profile_pic)

        // Set click listeners for editing the banner and profile picture
        bannerImageView.setOnClickListener {
            openGalleryForBanner()
        }

        profileImageView.setOnClickListener {
            openGalleryForProfilePicture()
        }
    }

    private fun openGalleryForBanner() {
        // Implement logic to open the gallery for selecting a new banner image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE_BANNER_IMAGE)
    }

    private fun openGalleryForProfilePicture() {
        // Implement logic to open the gallery for selecting a new profile picture
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE_PROFILE_PICTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_BANNER_IMAGE -> {
                    // Handle the selected banner image
                    val selectedImageUri = data?.data
                    // Update the banner ImageView with the selected image
                    findViewById<ImageView>(R.id.bg_pic)?.setImageURI(selectedImageUri)
                }
                REQUEST_CODE_PROFILE_PICTURE -> {
                    // Handle the selected profile picture
                    val selectedImageUri = data?.data
                    // Update the profile picture ImageView with the selected image
                    findViewById<ImageView>(R.id.profile_pic)?.setImageURI(selectedImageUri)
                }
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_BANNER_IMAGE = 101
        private const val REQUEST_CODE_PROFILE_PICTURE = 102
    }
}
