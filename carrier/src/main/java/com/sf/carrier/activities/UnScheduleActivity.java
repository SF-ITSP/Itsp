package com.sf.carrier.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.sf.carrier.R;
import com.sf.app.library.domain.ServerAddress;
import com.sf.app.library.utils.PropertiesProvider;
import com.sf.carrier.adapters.RequirementAdapter;

public class UnScheduleActivity extends NavigationActivity {

    private RequirementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.un_schedule_activity);

        findViewById(R.id.navigation_view);

        View backView = findViewById(R.id.back_view);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initListView();

        requestRequirement();
    }

    private void requestRequirement() {
//        List<Requirement> requirements = ConnectionProxy.getInstance().requestRequirements(getBaseContext());
//        adapter.setItems(requirements);

        ServerAddress serverAddress = PropertiesProvider.getInstance(getApplicationContext()).getServerAddress();
        String host = serverAddress.host;

        Toast.makeText(getApplicationContext(), host, Toast.LENGTH_LONG).show();
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.requirement_list_view);
        adapter = new RequirementAdapter(getApplicationContext());
        listView.setAdapter(adapter);
    }
}