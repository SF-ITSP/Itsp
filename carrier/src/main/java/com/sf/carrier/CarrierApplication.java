package com.sf.carrier;

import android.app.Application;

public class CarrierApplication extends Application {

    private long carrierId;
    private long driverId;

    {
        carrierId = 888;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(long carrierId) {
        this.carrierId = carrierId;
    }

    public long getDriverId() {
        return driverId;
    }
}
