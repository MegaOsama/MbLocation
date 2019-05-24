package com.apps.sam.mb1.updates.tools;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.sam.mb1.R;
import com.apps.sam.mb1.updates.Activities.ActivityOffices;
import com.apps.sam.mb1.updates.Models.Sector;

import java.util.List;

public class AdapterRvSectors extends RecyclerView.Adapter<AdapterRvSectors.RvSectorHolder> {

    private final List<Sector> sectors;
    private String tag = AdapterRvSectors.class.getName();
    private Activity activity;


    public AdapterRvSectors(Activity activity, List<Sector> sectors) {
        this.activity = activity;
        this.sectors = sectors;
    }


    @Override
    public AdapterRvSectors.RvSectorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view_as_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        return new AdapterRvSectors.RvSectorHolder(view_as_row);
    }

    @Override
    public void onBindViewHolder(AdapterRvSectors.RvSectorHolder holder, final int position) {
        Sector sector = sectors.get(position);
        holder.name.setText(sector.getName());
        Log.d(tag, " sector.getId() = " + sector.getId());
        holder.itemView.setOnClickListener(v -> {
            Log.d(tag, " " + sector.getId());
            Intent intent = new Intent(activity, ActivityOffices.class);
            intent.putExtra("sector", sector.getId());
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        Log.d(tag, " sectors.size " +sectors.size());
        return sectors.size();

    }


    public class RvSectorHolder extends RecyclerView.ViewHolder {

        private ImageView userimg;
        private ImageView leftarrow;
        private TextView name;


        private RvSectorHolder(View itemView) {
            super(itemView);
            userimg = itemView.findViewById(R.id.userimg);
            leftarrow = itemView.findViewById(R.id.leftarrow);
            name = itemView.findViewById(R.id.usertxt);
        }
    }

}