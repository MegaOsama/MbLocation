package com.apps.sam.mb1.updates.services;

import com.apps.sam.mb1.updates.Models.Offices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OfficesService {
    @GET("api/office")
    Call<Offices> all(@Query("sector_id") Integer sector_id);
}
