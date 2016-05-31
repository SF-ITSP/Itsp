package com.sf.app.library.connectivity;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.sf.app.library.domain.DriverTask;
import com.sf.app.library.domain.ServerAddress;
import com.sf.app.library.utils.JsonConverter;
import com.sf.app.library.utils.PropertiesProvider;
import com.sf.contacts.domain.Driver;
import com.sf.contacts.domain.Requirement;
import com.sf.contacts.domain.Task;
import com.sf.contacts.domain.Vehicle;

import java.util.List;
import java.util.Map;

import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Driver;
import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.DriverTasks;
import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Drivers;
import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Requirements;
import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Tasks;
import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Vehicles;


public class ConnectionProxy {
    private static ConnectionProxy instance;

    public static ConnectionProxy getInstance() {
        if (instance == null) {
            instance = new ConnectionProxy();
        }
        return instance;
    }

    private ConnectionProxy() {

    }

    public List<Task> requestTask(Context context, Map<String, String> parameter) {
        return (List<Task>) Tasks.request(context, parameter);
    }

    public List<Vehicle> requestVehicle(Context context, Map<String, String> parameter) {
        return (List<Vehicle>) Vehicles.request(context, parameter);
    }

    public List<Requirement> requestRequirements(Context context, Map<String, String> parameter) {
        return (List<Requirement>) Requirements.request(context, parameter);
    }

    public List<Driver> requestDrivers(Context context, Map<String, String> parameter) {
        return (List<Driver>) Drivers.request(context, parameter);
    }

    public List<Driver> requestDriverById(Context context, Map<String, String> parameter) {
        return (List<Driver>) Driver.request(context, parameter);
    }

    public List<DriverTask> requestDriverTasks(Context context) {
        return (List<DriverTask>) DriverTasks.request(context);
    }

    public enum RequestPath {
        Drivers("drivers", new TypeToken<List<Driver>>() {
        }) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "/carrier/" + parameter.get("carrierId");
            }
        },
        Tasks("tasks", new TypeToken<List<Task>>() {
        }) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "";
            }
        },
        Vehicles("vehicles", new TypeToken<List<Vehicle>>() {
        }) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "/" + parameter.get("carrierId");
            }
        },
        Requirements("requirement", new TypeToken<List<Requirement>>() {
        }) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "/" + parameter.get(CARRIER_ID) + "/" + parameter.get(STATUS);
            }
        },
        Driver("drivers", new TypeToken<List<Driver>>() {
        }) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "/" + parameter.get("driverId");
            }
        }, DriverTasks("driverTask", new TypeToken<List<DriverTask>>() {
        }) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "";
            }
        };
        public static final String STATUS = "status";
        public static final String CARRIER_ID = "carrierId";
        private final String resource;
        private final TypeToken typeToken;

        RequestPath(String resource, TypeToken typeToken) {
            this.resource = resource;
            this.typeToken = typeToken;
        }

        public List<?> request(Context context, Map<String, String> parameter) {
            ServerAddress serverAddress = PropertiesProvider.getInstance(context).getServerAddress();
            String request = new HttpClient(serverAddress.host).request(getPath(parameter));
            return convert(request);
        }

        public List<?> request(Context context) {
            return request(context, null);
        }

        public List<?> convert(String dataAsJson) {
            return JsonConverter.jsonToObject(dataAsJson, typeToken);
        }

        public String getPath(Map<String, String> parameter) {
            return this.resource + constructParameter(parameter);
        }

        public abstract String constructParameter(Map<String, String> parameter);
    }
}