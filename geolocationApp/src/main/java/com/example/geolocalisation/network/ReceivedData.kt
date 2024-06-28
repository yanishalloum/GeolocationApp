package com.example.geolocalisation.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReceivedData (
    //keys of the JSON file
    val id: String,
    @SerialName(value = "name")
    val name: String //to respect the camelCase notation
)