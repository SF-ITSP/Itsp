package com.sf.app.library.connectivity;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.sf.app.library.domain.ServerAddress;
import com.sf.app.library.utils.JsonConverter;
import com.sf.app.library.utils.PropertiesProvider;
import com.sf.contacts.domain.Driver;
import com.sf.contacts.domain.Requirement;
import com.sf.contacts.domain.Task;
import com.sf.contacts.domain.Vehicle;

import java.util.List;
import java.util.Map;

import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Requirements;
import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Tasks;
import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Vehicles;
import static com.sf.app.library.connectivity.ConnectionProxy.RequestPath.Drivers;

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

    public enum RequestPath {
        Drivers("drivers", Driver[].class) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "/" + parameter.get("carrierId");
            }
        },
        Tasks("tasks", Task[].class) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "";
            }
        },
        Vehicles("vehicles", Vehicle[].class) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "";
            }
        },
        Requirements("requirement", Requirement[].class) {
            @Override
            public String constructParameter(Map<String, String> parameter) {
                return "/" + parameter.get("carrierId") + "/" + parameter.get("status");
            }
        };

        private final String resource;
        private final TypeToken typeToken;

        RequestPath(String resource, Class clazz) {
            this.resource = resource;
            this.typeToken = TypeToken.get(clazz);
        }

        public List<?> request(Context context, Map<String, String> parameter) {
            ServerAddress serverAddress = PropertiesProvider.getInstance(context).getServerAddress();
            String request = new HttpClient(serverAddress.host).request(getPath(parameter));
            return convert(request);
        }

        public List<?> convert(String dataAsJson) {
            return JsonConverter.jsonFromObjectList(dataAsJson, typeToken);
        }

        public String getPath(Map<String, String> parameter) {
            return this.resource + constructParameter(parameter);
        }

        public abstract String constructParameter(Map<String, String> parameter);
    }
}