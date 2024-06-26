package com.example.geolocalisation;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Building {


    @SerializedName("rooms_results")
    @Expose
    private List<Room> rooms = null;

    public Building(List<Room> rooms)
    {
        this.rooms = rooms;
    }

    public List<Room> getRooms()
    {
        return rooms;
    }
}
