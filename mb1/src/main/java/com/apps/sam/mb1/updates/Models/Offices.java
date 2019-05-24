package com.apps.sam.mb1.updates.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Offices {
    @SerializedName("data")
    private List<Office> offices;

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }
}
