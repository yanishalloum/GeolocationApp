package com.example.geolocalisation

import retrofit2.Call
import retrofit2.http.GET

interface GetGeolocationDataService {
    @get:GET("salle")
    val resourceRooms: Call<Building>
}
