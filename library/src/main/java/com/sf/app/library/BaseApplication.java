package com.sf.app.library;

import android.app.Application;

public abstract class BaseApplication extends Application {
    private static BaseApplication application;

    public static BaseApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
