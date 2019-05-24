package com.apps.sam.mb1.updates.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.apps.sam.mb1.updates.Models.Sector;
import com.apps.sam.mb1.updates.Models.SectorList;
import com.apps.sam.mb1.updates.api.RetrofitClientInstance.RetrofitClientInstance;
import com.apps.sam.mb1.updates.tools.AdapterRvSectors;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class SectorsServiceImpl {

    static String tag = "Sector";
    private static List<Sector> sectorsList = new ArrayList<>();

    public static List<Sector> all(Activity context, int depart, RecyclerView rvSectors, final ProgressDialog progressDoalog) {


        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        Timber.d("" + depart);
        /*Create handle for the RetrofitInstance interface*/
        SectorsService service = RetrofitClientInstance.getRetrofitInstance().create(SectorsService.class);

        retrofit2.Call<SectorList> call = service.departSectors(depart);
        call.enqueue(new retrofit2.Callback<SectorList>() {
            @Override
            public void onResponse(retrofit2.Call<SectorList> call, retrofit2.Response<SectorList> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()) {
                    sectorsList = response.body().getSectors();
                    initAdapterRvSectors(context, rvSectors, sectorsList);
                } else {
                    Log.d(tag, "response not Successful");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<SectorList> call, Throwable t) {
                progressDoalog.dismiss();
                Log.d(tag, t.getMessage());
                t.printStackTrace();
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        return sectorsList;
    }

    public static AdapterRvSectors initAdapterRvSectors(Activity context, RecyclerView rvSectors, List<Sector> sectors) {
        AdapterRvSectors adapterRvSectors = new AdapterRvSectors(context, sectors);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rvSectors.setLayoutManager(layoutManager);
        rvSectors.setItemAnimator(new DefaultItemAnimator());
        rvSectors.setAdapter(adapterRvSectors);
        rvSectors.setLayoutManager(new LinearLayoutManager(context));
        adapterRvSectors.notifyDataSetChanged();
        return adapterRvSectors;
    }

}
