package com.sf.carrier.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sf.carrier.views.TabType;

public class TabPageAdapter extends FragmentPagerAdapter {
    public TabPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return tabTypes()[position].generation();
    }

    @Override
    public int getCount() {
        return tabTypes().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTypes()[position].title;
    }

    private TabType[] tabTypes() {
        return TabType.values();
    }
}