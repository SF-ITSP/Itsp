package com.sf.carrier.activities;

import android.os.Bundle;

import com.sf.carrier.R;

public class ResourceDistributeActivity extends NavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
