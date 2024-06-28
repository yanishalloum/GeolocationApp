package com.example.geolocalisation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class Building(rooms: List<Room>?) {
    @SerialName("salles_results")
    @Serializable
    private var rooms: List<Room>? = null

    init {
        this.rooms = rooms
    }

    fun getRooms(): List<Room>? {
        return rooms
    }
}
