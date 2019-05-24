package com.apps.sam.mb1.updates.Models;

import com.google.gson.annotations.SerializedName;

public class Sector {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public Sector(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
