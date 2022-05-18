package com.example.keyboarddialer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class CONTACT2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact2)
    }

    fun write(view: View) {
        val myString = view.getTag().toString()
        val editText = findViewById<EditText>(R.id.editTextPhoneContact2)
        var message = editText.text.toString()
        println(myString)
        if (myString == "del") {
            message = message.dropLast(1)
        } else {
            message += myString
        }
        editText.setText(message)
    }

    fun saveNumber(view: View) {
        val editText = findViewById<EditText>(R.id.editTextPhoneContact2)
        val intent = Intent(this, MainActivity::class.java)
        val message = editText.text.toString()
        intent.putExtra("message_key", message)
        startActivity(intent)
    }
}