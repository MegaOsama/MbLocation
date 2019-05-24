package com.apps.sam.mb1.updates;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.apps.sam.mb1.R;
import com.apps.sam.mb1.updates.tools.AdapterRvSectors;
import com.apps.sam.mb1.updates.services.SectorsServiceImpl;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    String tag = MainActivity.class.getName();
    ProgressDialog progressDoalog;
    RecyclerView rvSectors;
    AdapterRvSectors adapterRvSectors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressDoalog = new ProgressDialog(MainActivity.this);
        rvSectors = (RecyclerView) findViewById(R.id.rvSectors);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {

                        sectors(2);

                    } catch (Exception ex) {
                        Toast.makeText(MainActivity.this, "something gone ", Toast.LENGTH_LONG).show();
                        Timber.d(tag, ex.getMessage());
                        ex.printStackTrace();
                    }
                }


        });
    }
    private void sectors(int depart) {
        SectorsServiceImpl.all(this, depart, rvSectors, progressDoalog);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
