package com.example.keyboarddialer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mBtn1 = findViewById<Button>(R.id.contact1)
        val mBtn2 = findViewById<Button>(R.id.contact2)
        val mBtn3 = findViewById<Button>(R.id.contact3)
        // implement a setOnLongClickListener to the
        // button that creates a Toast and
        // returns true when actually long-pressed
        mBtn1.setOnLongClickListener {
            Toast.makeText(applicationContext, "Button Long Pressed", Toast.LENGTH_SHORT).show()
            true
        }
        mBtn2.setOnLongClickListener {
            Toast.makeText(applicationContext, "Button Long Pressed", Toast.LENGTH_SHORT).show()
            true
        }
        mBtn3.setOnLongClickListener {
            Toast.makeText(applicationContext, "Button Long Pressed", Toast.LENGTH_SHORT).show()
            true
        }
    }

    public fun startCall(view: View) {
        val editText = findViewById<EditText>(R.id.editTextPhone)
        var phoneNumber = editText.text.toString()
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phoneNumber")
        startActivity(callIntent)
    }

    public fun startCallNumber(view: View) {
        val phoneNumber = view.getTag().toString()
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phoneNumber")
        startActivity(callIntent)
    }

    public fun write(view: View) {
        val myString = view.getTag().toString()
        val editText = findViewById<EditText>(R.id.editTextPhone)
        var message = editText.text.toString()
        println(myString)
        if (myString == "del") {
            message = message.dropLast(1)
        } else {
            message += myString
        }
        editText.setText(message)
    }
}