package com.example.geolocalisation.network

import retrofit2.Retrofit
import retrofit2.http.*
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

private const val BASE_URL =
    "http://10.0.2.2:3000/"
    //"https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) //turns the received JSON into a kotlin object
    .baseUrl(BASE_URL) //adds the Web service's root URL
    .build() //creates the Retrofit object

//defines how Retrofit communicates with the Web server through HTTP requests
interface RetrofitService {
    @GET("dataToApp") //indicates to Retrofit that it is a GET request and specifies the termination point "/photos" (add "/photos" to root url)
    suspend fun getJson(): List<ReceivedData> //asynchronous method to get the response chain from the Web service

}

object ReceivedDataApi {
    val retrofitService : RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    } //object property defined with delay to be sure it is initialized when it is first used (to avoid useless processing costs)
} // Initialize the Retrofit service
