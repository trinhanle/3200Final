package com.example.k2024_04_21_imperative_image_work.view_models

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.k2024_04_21_imperative_image_work.models.JSON_MetMuseum
import com.google.gson.Gson

class ImagesViewModel(context: Context) : ViewModel() {

    private val gson = Gson()
    private val metPublicDomainUrl = "https://collectionapi.metmuseum.org/public/collection/v1/objects/"
    private var imageData : JSON_MetMuseum? = null
    private var volleyQueue: RequestQueue

    init{
        volleyQueue = Volley.newRequestQueue(context)
    }


    fun getImage(number: Int) {

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            metPublicDomainUrl + number.toString(),
            null,
            { response ->
                // Display the first 500 characters of the response string.

                imageData = gson.fromJson(response.toString(), JSON_MetMuseum::class.java )

            },
            { error ->  Log.i("PGB" ,"Error: ${error}") })
        volleyQueue.add(jsonObjectRequest)

    }

    fun getImageData(): String {
        return imageData.toString()
    }
}
