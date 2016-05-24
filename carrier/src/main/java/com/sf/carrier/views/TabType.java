package com.sf.carrier.views;

import android.support.v4.app.Fragment;

import com.sf.carrier.views.fragments.MarketFragment;
import com.sf.carrier.views.fragments.SettingFragment;
import com.sf.carrier.views.fragments.TaskFragment;

public enum TabType {
    Market("需求市场") {
        @Override
        public Fragment generation() {
            return new MarketFragment();
        }
    }, Tasks("我的任务") {
        @Override
        public Fragment generation() {
            return new TaskFragment();
        }
    }, Settings("设置") {
        @Override
        public Fragment generation() {
            return new SettingFragment();
        }
    };

    public final String title;

    TabType(String title) {
        this.title = title;
    }

    public abstract Fragment generation();
}
