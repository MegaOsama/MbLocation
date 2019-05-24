package com.apps.sam.mb1.updates.Models;

import com.google.gson.annotations.SerializedName;

public class Office {
    @SerializedName("id")
    private int id;
    @SerializedName("office")
    private int office_id;
    @SerializedName("title")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("lati")
    private Double lat;
    @SerializedName("longi")
    private Double longi;


    public Office(int id, int office_id, String name, String description, Double lat, Double longi) {
        this.id = id;
        this.office_id = office_id;
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.longi = longi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOffice_id() {
        return office_id;
    }

    public void setOffice_id(int office_id) {
        this.office_id = office_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongi() {
        return longi;
    }

    public void setLongi(Double longi) {
        this.longi = longi;
    }

    @Override
    public String toString() {
        return description;
    }
}
