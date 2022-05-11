package com.example.keyboarddialer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
        }*/
    }

    public fun startCall(view: View) {\
        val editText = findViewById<EditText>(R.id.editTextPhone)
        var phoneNumber = editText.text.toString()
        val callIntent = Intent(Intent.ACTION_CALL)
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