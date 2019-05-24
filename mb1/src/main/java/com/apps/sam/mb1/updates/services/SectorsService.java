package com.apps.sam.mb1.updates.services;

import com.apps.sam.mb1.updates.Models.SectorList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SectorsService {
    @GET("api/sector/all")
    Call<SectorList> all();

    @GET("api/sector")
    Call<SectorList> departSectors(@Query("depart_id") Integer depart_id);
}
