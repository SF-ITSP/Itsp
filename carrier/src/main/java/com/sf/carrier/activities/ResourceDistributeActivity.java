package com.sf.carrier.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sf.app.library.connectivity.ConnectionProxy;
import com.sf.carrier.R;
import com.sf.carrier.adapters.DriverViewAdapter;
import com.sf.carrier.views.fragments.AssignDriverDialogFragment;
import com.sf.contacts.domain.Driver;

import java.util.List;

public class ResourceDistributeActivity extends NavigationActivity {
    private RecyclerView driverRecyclerView;
    private DriverViewAdapter driverAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initDriverList();
    }

    private void initDriverList() {
        new AsyncTask<Void, Void, List<Driver>>() {
            @Override
            protected List<Driver> doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestDrivers(getApplicationContext(), null);
            }

            @Override
            protected void onPostExecute(List<Driver> drivers) {
                driverAdapter.setDriverList(drivers);
            }
        }.execute();
    }

    private void initView() {
        driverRecyclerView = (RecyclerView) findViewById(R.id.driver_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        driverRecyclerView.setLayoutManager(linearLayoutManager);

        driverAdapter = new DriverViewAdapter(getApplicationContext());
        driverRecyclerView.setAdapter(driverAdapter);

        driverAdapter.setOnItemClickLitener(new DriverViewAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                AssignDriverDialogFragment assignDriverDialogFragment = new AssignDriverDialogFragment();
                assignDriverDialogFragment.show(getFragmentManager(), "assign driver");
            }
        });
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
