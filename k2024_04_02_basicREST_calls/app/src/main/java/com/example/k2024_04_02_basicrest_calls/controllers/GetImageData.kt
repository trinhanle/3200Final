package com.example.k2024_04_02_basicrest_calls.controllers

import android.telecom.Call
import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.k2024_04_02_basicrest_calls.models.ImageData
import com.example.k2024_04_02_basicrest_calls.models.Images
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

public interface GetImageData {
    @Headers(
        "Accept: application/json"
    )
    @GET("/{id}")
    abstract fun getImageMetaDataById(@Path("id") id: String): Callback<ImageData?>?

}

fun sendRequest(
    id: String,
    profileState: MutableState<Images>
) {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.109:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(GetImageData::class.java)

    val call: Call<ImageData?>? = api.getImageMetaDataById(id);

    call!!.enqueue(object: Callback<ImageData?> {
        override fun onResponse(call: retrofit2.Call<ImageData?>, response: Response<ImageData?>) {
            if(response.isSuccessful) {
                Log.d("Main", "success!" + response.body().toString())

            }
        }

        override fun onFailure(call: Callback<ImageData?>, t: Throwable) {
            Log.e("Main", "Failed mate " + t.message.toString())
        }
    })