package com.sf.carrier;

import android.app.Application;
import android.content.Context;

public class CarrierApplication extends Application {
    private static Context context;

    private long carrierId;

    {
        carrierId = 888;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CarrierApplication.context = getApplicationContext();
    }

    public long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(long carrierId) {
        this.carrierId = carrierId;
    }

    public static Context getAppContext() {
        return CarrierApplication.context;
    }
}
