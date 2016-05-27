package com.sf.carrier.views;

import android.support.v4.app.Fragment;

import com.sf.carrier.R;
import com.sf.carrier.views.fragments.MarketFragment;
import com.sf.carrier.views.fragments.SettingFragment;
import com.sf.carrier.views.fragments.TaskFragment;

public enum TabType {
    Market(R.string.requirement_market) {
        @Override
        public Fragment generation() {
            return new MarketFragment();
        }
    }, Tasks(R.string.my_task) {
        @Override
        public Fragment generation() {
            return new TaskFragment();
        }
    }, Settings(R.string.settings) {
        @Override
        public Fragment generation() {
            return new SettingFragment();
        }
    };

    public final int titleResId;

    TabType(int titleResId) {
        this.titleResId = titleResId;
    }

    public abstract Fragment generation();
}
