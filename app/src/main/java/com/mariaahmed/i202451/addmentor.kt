package com.mariaahmed.i202451

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class addmentor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addmentor)

        //city spinner
        val spinnerstatus = findViewById<Spinner>(R.id.my_spinner_availability)
        val menuitemsstatus = arrayOf("Available", "Not Available")

        val statusadapter =
            ArrayAdapter(this@addmentor, android.R.layout.simple_spinner_item, menuitemsstatus)
        statusadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerstatus.adapter = statusadapter

        spinnerstatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = spinnerstatus.selectedItem.toString()
                Toast.makeText(this@addmentor, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}