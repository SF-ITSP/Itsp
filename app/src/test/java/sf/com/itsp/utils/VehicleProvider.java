package sf.com.itsp.utils;

import com.google.gson.reflect.TypeToken;

import sf.com.itsp.domain.Vehicle;

import static sf.com.itsp.shadows.ShadowConnectionProxy.fakeVehicles;

public class VehicleProvider {
    private static final String VEHICLES = "[{'vehicleNumber': '粤A-123456'}]";

    public static void mockVehicleResponse() {
        fakeVehicles(JsonConverter.<Vehicle>jsonFromObjectList(VEHICLES, TypeToken.get(Vehicle[].class)));
    }
}
