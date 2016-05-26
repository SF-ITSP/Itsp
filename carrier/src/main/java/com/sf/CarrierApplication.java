package com.sf;

import android.app.Application;

public class CarrierApplication extends Application {

    private long carrierId;

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
}
