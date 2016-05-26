package com.sf.itsp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPageIndicatorAdapter extends FragmentPagerAdapter {
    private List<String> titleList = new ArrayList<String>();
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    public TabPageIndicatorAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(String title, Fragment fragment) {
        titleList.add(title);
        fragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position % fragmentList.size());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position % titleList.size());
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
