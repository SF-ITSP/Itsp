package com.sf.itsp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.sf.itsp.adapter.TabPageIndicatorAdapter;
import com.sf.itsp.fragment.OtherFragment;
import com.sf.itsp.fragment.TaskFragment;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_paper);
        TabPageIndicatorAdapter tabpageIndicatorAdapter = initFragment();
        viewPager.setAdapter(tabpageIndicatorAdapter);

        TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
    }

    private TabPageIndicatorAdapter initFragment() {
        TabPageIndicatorAdapter tabpageIndicatorAdapter = new TabPageIndicatorAdapter(getSupportFragmentManager());

        for (TabType tabType : TabType.values()) {
            tabpageIndicatorAdapter.addFragment(getString(tabType.titleResId), tabType.generateFragment());
        }

        return tabpageIndicatorAdapter;
    }

    public enum TabType {
        Task(R.string.task_execute) {
            @Override
            public Fragment generateFragment() {
                return new TaskFragment();
            }
        }, Settings(R.string.settings) {
            @Override
            public Fragment generateFragment() {
                return new OtherFragment();
            }
        };

        public final int titleResId;

        TabType(int titleResId) {
            this.titleResId = titleResId;
        }

        public abstract Fragment generateFragment();
    }
}