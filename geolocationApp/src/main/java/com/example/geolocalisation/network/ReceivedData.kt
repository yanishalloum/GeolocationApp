package com.example.geolocalisation.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReceivedData (
    //keys of the JSON file
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String //to respect the camelCase notation
)