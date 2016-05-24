package com.sf.activities;

import android.os.Bundle;
import android.view.View;

import com.sf.R;


public class UnScheduleActivity extends NavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.un_schedule_activity);

        View navigationBar = findViewById(R.id.navigation_view);

        View backView = findViewById(R.id.back_view);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}