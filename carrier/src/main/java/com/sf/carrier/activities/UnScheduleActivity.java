package com.sf.carrier.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.sf.carrier.R;
import com.sf.carrier.adapters.RequirementAdapter;
import com.sf.contacts.domain.Requirement;

import java.util.Date;

import static java.util.Arrays.asList;

public class UnScheduleActivity extends NavigationActivity {

    private RequirementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initListView();
        requestRequirement();
    }

    private void requestRequirement() {
        Requirement requirement = new Requirement();
        requirement.setEndDate(new Date());
        requirement.setStartDate(new Date());

        /**
         * @TODO: will fix this issue when request server, because it make a crash
         */
//        List<Requirement> requirements = ConnectionProxy.getInstance().requestRequirements(getBaseContext());

        adapter.setItems(asList(requirement));
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