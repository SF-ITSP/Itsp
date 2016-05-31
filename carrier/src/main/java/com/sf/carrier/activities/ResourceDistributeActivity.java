package com.sf.carrier.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.sf.app.library.connectivity.ConnectionProxy;
import com.sf.carrier.R;
import com.sf.carrier.adapters.DriverViewAdapter;
import com.sf.carrier.adapters.VehicleViewAdapter;
import com.sf.carrier.views.fragments.AssignDriverDialogFragment;
import com.sf.contacts.domain.Driver;
import com.sf.contacts.domain.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDistributeActivity extends NavigationActivity {
    private RecyclerView driverRecyclerView;
    private DriverViewAdapter driverAdapter;

    private RecyclerView vehicleRecyclerView;
    private VehicleViewAdapter vehicleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initData();
    }

    private void initView() {
        initVehicleListView();

        initDriverListView();
    }

    private void initVehicleListView() {
        vehicleRecyclerView = (RecyclerView) findViewById(R.id.vehicle_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        vehicleRecyclerView.setLayoutManager(linearLayoutManager);

        vehicleAdapter = new VehicleViewAdapter(getApplicationContext());
        vehicleRecyclerView.setAdapter(vehicleAdapter);

        vehicleAdapter.setOnItemClickListener(new VehicleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ((ImageView) findViewById(R.id.has_selected)).setImageResource(R.drawable.selected);
            }
        });
    }

    private void initDriverListView() {
        driverRecyclerView = (RecyclerView) findViewById(R.id.driver_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        driverRecyclerView.setLayoutManager(linearLayoutManager);

        driverAdapter = new DriverViewAdapter(getApplicationContext());
        driverRecyclerView.setAdapter(driverAdapter);

        driverAdapter.setOnItemClickListener(new DriverViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                AssignDriverDialogFragment assignDriverDialogFragment = new AssignDriverDialogFragment();

                assignDriverDialogFragment.getClickedDriverInfo(position);

                assignDriverDialogFragment.show(getFragmentManager(), "Assign Driver");
            }
        });
    }

    private void initData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("carrierId", "888");

        initVehicleList(map);

        initDriverList(map);
    }

    private void initVehicleList(final Map<String, String> map) {
        new AsyncTask<String, Void, List<Vehicle>>() {
            @Override
            protected List<Vehicle> doInBackground(String... params) {
                return ConnectionProxy.getInstance().requestVehicle(getApplicationContext(), map);
            }

            @Override
            protected void onPostExecute(List<Vehicle> vehicles) {
                vehicleAdapter.setVehicleList(vehicles);
            }
        }.execute();
    }

    private void initDriverList(final Map<String, String> map) {
        new AsyncTask<String, Void, List<Driver>>() {
            @Override
            protected List<Driver> doInBackground(String... params) {
                return ConnectionProxy.getInstance().requestDrivers(getApplicationContext(), map);
            }

            @Override
            protected void onPostExecute(List<Driver> drivers) {
                driverAdapter.setDriverList(drivers);
            }
        }.execute();
    }

    @Override
    protected int getTitleResId() {
        return R.string.resource_distribute;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_resource_distrubute;
    }
}
