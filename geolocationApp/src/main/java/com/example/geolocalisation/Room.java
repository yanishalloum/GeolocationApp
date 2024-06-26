package com.example.geolocalisation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Room {

    @SerializedName("id") //variable "id" will be associated to the '"id"' key in the JSON
    @Expose //makes the variable exposed for (de)serialization
    private int id;
    @SerializedName("nom")
    @Expose
    private String name;

    public Room(int id, String nom)
    {
        this.id = id;
        this.name = nom;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
