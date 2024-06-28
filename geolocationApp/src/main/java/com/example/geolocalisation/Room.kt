package com.example.geolocalisation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Room(
    @SerialName("id")
    val id: Int,

    @SerialName("nom")
    val name: String = ""
)
