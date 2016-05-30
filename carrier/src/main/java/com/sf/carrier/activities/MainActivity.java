package com.sf.carrier.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.sf.carrier.CarrierApplication;
import com.sf.carrier.R;
import com.sf.carrier.adapters.TabPageAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        TabPageIndicator indicatorView = (TabPageIndicator) findViewById(R.id.indicator_view);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.setAdapter(new TabPageAdapter(getSupportFragmentManager(), getApplicationContext()));
        indicatorView.setViewPager(viewPager);

        CarrierApplication application = (CarrierApplication) getApplication();
        Toast.makeText(this.getBaseContext(), String.valueOf(application.getCarrierId()), Toast.LENGTH_SHORT).show();
    }
}
