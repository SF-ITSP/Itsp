package com.sf.carrier.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sf.carrier.views.TabType;

public class TabPageAdapter extends FragmentPagerAdapter {
    private Context context;

    public TabPageAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
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
        return context.getString(tabTypes()[position].titleResId);
    }

    private TabType[] tabTypes() {
        return TabType.values();
    }
}