package com.apps.sam.mb1.updates.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.apps.sam.mb1.updates.Models.Office;
import com.apps.sam.mb1.updates.Models.Offices;
import com.apps.sam.mb1.updates.api.RetrofitClientInstance.RetrofitClientInstance;
import com.apps.sam.mb1.updates.tools.AdapterRvOffices;

import java.util.ArrayList;
import java.util.List;

public class OfficesServiceImpl {


    static String tag = OfficesServiceImpl.class.getName();
    private static List<Office> offices = new ArrayList<>();

    public static List<Office> all(Activity context, int sector , RecyclerView rvOffices, final ProgressDialog progressDoalog) {


        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        Log.d(tag, "sector_id =" + sector);
        /*Create handle for the RetrofitInstance interface*/
        OfficesService service = RetrofitClientInstance.getRetrofitInstance().create(OfficesService.class);

        retrofit2.Call<Offices> call = service.all(sector);
        call.enqueue(new retrofit2.Callback<Offices>() {
            @Override
            public void onResponse(retrofit2.Call<Offices> call, retrofit2.Response<Offices> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()) {
                    offices = response.body().getOffices();
                    initAdapterRvOffices(context, rvOffices, offices);
                } else {
                    Log.d(tag, "response not Successful");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Offices> call, Throwable t) {
                progressDoalog.dismiss();
                Log.d(tag, t.getMessage());
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        return offices;
    }

    public static AdapterRvOffices initAdapterRvOffices(Activity context, RecyclerView rvOffices, List<Office> Offices) {
        AdapterRvOffices adapterRvOffices = new AdapterRvOffices(context, Offices);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rvOffices.setLayoutManager(layoutManager);
        rvOffices.setItemAnimator(new DefaultItemAnimator());
        rvOffices.setAdapter(adapterRvOffices);
        rvOffices.setLayoutManager(new LinearLayoutManager(context));
        adapterRvOffices.notifyDataSetChanged();
        return adapterRvOffices;
    }
}

