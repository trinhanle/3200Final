package com.example.k2024_04_02_rest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface RetrofitAPI {
    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users
    @POST("users")
    fun // on below line we are creating a method to post our data.
            postData(@Body dataModel: DataModel?): Call<DataModel?>?

    @GET("/")
    fun // on below line we are creating a method to post our data.
            getData(@Body dataModel: DataModel?): Call<DataModel?>?
}
