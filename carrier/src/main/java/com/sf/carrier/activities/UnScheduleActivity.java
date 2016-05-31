package com.sf.carrier.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.sf.app.library.connectivity.ConnectionProxy;
import com.sf.carrier.CarrierApplication;
import com.sf.carrier.R;
import com.sf.carrier.adapters.RequirementAdapter;
import com.sf.contacts.domain.Requirement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnScheduleActivity extends NavigationActivity {

    private RequirementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initListView();
        requestRequirement();
    }

    private void requestRequirement() {
        CarrierApplication application = (CarrierApplication) getApplication();
        new AsyncTask<String, Void, List<Requirement>>() {
            @Override
            protected List<Requirement> doInBackground(String... params) {
                Map<String, String> map = new HashMap<String, String>();
                map.put(ConnectionProxy.RequestPath.CARRIER_ID, params[0]);
                map.put(ConnectionProxy.RequestPath.CARRIER_ID, params[1]);
                return ConnectionProxy.getInstance().requestRequirements(getApplicationContext(), map);
            }

            @Override
            protected void onPostExecute(List<Requirement> requirementList) {
                adapter.setItems(requirementList);
            }
        }.execute(String.valueOf(application.getCarrierId()), "1");
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.requirement_list_view);
        adapter = new RequirementAdapter(getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gotoResourceDistributeActivity();
            }
        });
    }

    private void gotoResourceDistributeActivity() {
        Intent intent = new Intent(getApplicationContext(), ResourceDistributeActivity.class);
        startActivity(intent);
    }

    @Override
    protected int getTitleResId() {
        return R.string.unscheduled;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.un_schedule_activity;
    }
}