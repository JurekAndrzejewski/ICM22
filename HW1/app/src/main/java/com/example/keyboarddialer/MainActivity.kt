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
import android.app.Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phoneNumber1 = intent.getStringExtra("message_key")
        val phoneNumber2 = intent.getStringExtra("message_key")
        val phoneNumber3 = intent.getStringExtra("message_key")
        val mBtn1 = findViewById<Button>(R.id.contact1)
        val mBtn2 = findViewById<Button>(R.id.contact2)
        val mBtn3 = findViewById<Button>(R.id.contact3)
        if (phoneNumber1 != null) {
            mBtn1.setTag(phoneNumber1)
        }
        if (phoneNumber2 != null) {
            mBtn2.setTag(phoneNumber2)
        }
        if (phoneNumber3 != null) {
            mBtn3.setTag(phoneNumber3)
        }
        // implement a setOnLongClickListener to the
        // button that creates a Toast and
        // returns true when actually long-pressed
        mBtn1.setOnLongClickListener {
            val intent = Intent(this, CONTACT1::class.java)
            startActivity(intent)
            true
        }
        mBtn2.setOnLongClickListener {
            val intent = Intent(this, CONTACT2::class.java)
            startActivity(intent)
            true
        }
        mBtn3.setOnLongClickListener {
            val intent = Intent(this, CONTACT3::class.java)
            startActivity(intent)
            true
        }
    }

    fun startCall(view: View) {
        val editText = findViewById<EditText>(R.id.editTextPhone)
        var phoneNumber = editText.text.toString()
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phoneNumber")
        startActivity(callIntent)
    }

    fun startCallNumber(view: View) {
        val phoneNumber = view.tag.toString()
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phoneNumber")
        startActivity(callIntent)
    }

    fun write(view: View) {
        val myString = view.tag.toString()
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