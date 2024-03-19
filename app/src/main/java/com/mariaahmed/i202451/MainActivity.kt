package com.mariaahmed.i202451

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val delayMillis: Long = 3000
    private val handler = Handler()
    private val navigateRunnable = Runnable {
        navigateToNextScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler.postDelayed(navigateRunnable, delayMillis)

    }

    private fun navigateToNextScreen() {
        val intent = Intent(this, loginscreen::class.java)
        startActivity(intent)
        finish()
    }
}