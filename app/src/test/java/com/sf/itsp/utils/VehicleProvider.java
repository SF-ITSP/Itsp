package com.sf.itsp.utils;

import com.google.gson.reflect.TypeToken;
import com.sf.app.library.utils.JsonConverter;

import com.sf.contacts.domain.Vehicle;

import static com.sf.itsp.shadows.ShadowConnectionProxy.fakeVehicles;

public class VehicleProvider {
    private static final String VEHICLES = "[{'vehicleNumber': '粤A-123456'}]";

    public static void mockVehicleResponse() {
        fakeVehicles(JsonConverter.<Vehicle>jsonFromObjectList(VEHICLES, TypeToken.get(Vehicle[].class)));
    }
}
