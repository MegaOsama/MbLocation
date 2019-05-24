package com.apps.sam.mb1.updates.tools;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.sam.mb1.R;
import com.apps.sam.mb1.updates.Activities.NavigationMapRouteActivity;
import com.apps.sam.mb1.updates.Models.Office;

import java.util.List;

import timber.log.Timber;

public class AdapterRvOffices extends RecyclerView.Adapter<AdapterRvOffices.RvOfficeHolder> {

    private final List<Office> offices;
    private String tag = AdapterRvOffices.class.getName();
    private Activity activity;


    public AdapterRvOffices(Activity activity, List<Office> offices) {
        this.activity = activity;
        this.offices = offices;
    }


    @Override
    public AdapterRvOffices.RvOfficeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view_as_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        return new AdapterRvOffices.RvOfficeHolder(view_as_row);
    }

    @Override
    public void onBindViewHolder(AdapterRvOffices.RvOfficeHolder holder, final int position) {
        Office office = offices.get(position);
        holder.name.setText(office.getName());
        Timber.d(tag, " office.getId() = " + office.getId());
        holder.itemView.setOnClickListener(v -> {
            try {
                Timber.d(tag, " office.getId " + office.getId());
                Intent intent = new Intent(activity, NavigationMapRouteActivity.class);
                intent.putExtra("title", String.valueOf(office.getName()));
                intent.putExtra("description", String.valueOf(office.getDescription()));
                intent.putExtra("lat", Double.valueOf(office.getLat()));
                intent.putExtra("longi", Double.valueOf(office.getLongi()));
                activity.startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG);
                Timber.d(tag, e.getMessage());
                e.printStackTrace();
            }

        });
    }

    @Override
    public int getItemCount() {
        Timber.d(tag, " offices.size " + offices.size());
        return offices.size();

    }


    public class RvOfficeHolder extends RecyclerView.ViewHolder {

        private ImageView userimg;
        private ImageView leftarrow;
        private TextView name;


        private RvOfficeHolder(View itemView) {
            super(itemView);
            userimg = itemView.findViewById(R.id.userimg);
            leftarrow = itemView.findViewById(R.id.leftarrow);
            name = itemView.findViewById(R.id.usertxt);
        }
    }
}
