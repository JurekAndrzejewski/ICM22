package com.example.hw2_2

import okhttp3.OkHttpClient
import okhttp3.Request


private val client = OkHttpClient()

fun run(city: String): String {

    val request = Request.Builder()
        .url("http://84.90.161.18:5000/weather?city=$city")
        .build()

    client.newCall(request).execute().use { response -> return response.body!!.string() }

}