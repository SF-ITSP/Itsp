package com.sf.carrier.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.sf.carrier.R;
import com.sf.carrier.views.NavigationBar;

public abstract class NavigationActivity extends Activity {

    private NavigationBar navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        initNavigationBar();
    }

    private void initNavigationBar() {
        navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        navigationBar.setTitle(getTitleResId());
        navigationBar.setOnBackButtonClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected abstract int getTitleResId();

    protected abstract int getContentViewId();
}