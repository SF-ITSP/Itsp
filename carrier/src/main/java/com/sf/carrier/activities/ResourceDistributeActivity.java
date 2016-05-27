package com.sf.carrier.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sf.app.library.connectivity.ConnectionProxy;
import com.sf.carrier.CarrierApplication;
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

    public void initData() {
        initDriverList();

        initVehicleList();
    }

    private void initDriverList() {
        new AsyncTask<String, Void, List<Driver>>() {
            @Override
            protected List<Driver> doInBackground(String... params) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("carrierId", "888");
                return ConnectionProxy.getInstance().requestDrivers(getApplicationContext(), map);
            }

            @Override
            protected void onPostExecute(List<Driver> drivers) {
                driverAdapter.setDriverList(drivers);
            }
        }.execute();
    }

    private void initVehicleList() {
        new AsyncTask<String, Void, List<Vehicle>>() {
            @Override
            protected List<Vehicle> doInBackground(String... params) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("carrierId", "888");
                return ConnectionProxy.getInstance().requestVehicle(getApplicationContext(), map);
            }

            @Override
            protected void onPostExecute(List<Vehicle> vehicles) {
                vehicleAdapter.setVehicleList(vehicles);
            }
        }.execute();
    }

    private void initView() {
        initDriverListView();

        initVehicleListView();
    }

    private void initDriverListView() {
        driverRecyclerView = (RecyclerView) findViewById(R.id.driver_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        driverRecyclerView.setLayoutManager(linearLayoutManager);

        driverAdapter = new DriverViewAdapter(getApplicationContext());
        driverRecyclerView.setAdapter(driverAdapter);

        driverAdapter.setOnItemClickLitener(new DriverViewAdapter.OnItemClickLitener() {

            @Override
            public void onItemClick(View view, int position) {
                final AssignDriverDialogFragment assignDriverDialogFragment = new AssignDriverDialogFragment();

                CarrierApplication application = (CarrierApplication) getApplication();
                new AsyncTask<String, Void, List<Driver>>() {
                    @Override
                    protected List<Driver> doInBackground(String... params) {
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("carrierId", params[0]);
                        map.put("driverId", params[1]);

                        return ConnectionProxy.getInstance().requestDrivers(getApplicationContext(), map);
                    }

                    @Override
                    protected void onPostExecute(List<Driver> drivers) {
                        Driver driver = drivers.get(0);
                        ((TextView) assignDriverDialogFragment.getView().findViewById(R.id.name_value)).setText(driver.getName());
                        ((TextView) assignDriverDialogFragment.getView().findViewById(R.id.driving_license_type_value)).setText(driver.getDrivingLicenseType());
                        ((TextView) assignDriverDialogFragment.getView().findViewById(R.id.age_value)).setText(String.valueOf(driver.getAge()));
                        ((TextView) assignDriverDialogFragment.getView().findViewById(R.id.driving_experience_value)).setText(String.valueOf(driver.getDrivingExperience()));
                    }
                }.execute(String.valueOf(application.getCarrierId()), String.valueOf(application.getDriverId()));

                assignDriverDialogFragment.show(getFragmentManager(), "Assign Driver");
            }
        });
    }

    private void initVehicleListView() {
        vehicleRecyclerView = (RecyclerView) findViewById(R.id.vehicle_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        vehicleRecyclerView.setLayoutManager(linearLayoutManager);

        vehicleAdapter = new VehicleViewAdapter(getApplicationContext());
        vehicleRecyclerView.setAdapter(vehicleAdapter);
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
