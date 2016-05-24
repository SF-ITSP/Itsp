package com.sf.app.library.connectivity;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.reflect.TypeToken;
import com.sf.app.library.domain.ServerAddress;
import com.sf.app.library.utils.JsonConverter;
import com.sf.app.library.utils.PropertiesProvider;
import com.sf.app.library.utils.connectivity.HttpClient;
import com.sf.contacts.domain.Requirement;
import com.sf.contacts.domain.Task;
import com.sf.contacts.domain.Vehicle;

import java.util.List;

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

    public List<Task> requestTask(Context context) {
        return (List<Task>) Tasks.request(context);
    }

    public List<Vehicle> requestVehicle(Context context) {
        return (List<Vehicle>) Vehicles.request(context);
    }

    public List<Requirement> requestRequirements(Context context) {
        return (List<Requirement>) Requirements.request(context);
    }

    public enum RequestPath {
        Tasks("tasks", Task[].class),
        Vehicles("vehicles", Vehicle[].class),
        Requirements("requirements", Requirement[].class);

        private final String path;
        private final TypeToken typeToken;

        RequestPath(String path, Class clazz) {
            this.path = path;
            this.typeToken = TypeToken.get(clazz);
        }

        public List<?> request(Context context) {
            ServerAddress serverAddress = PropertiesProvider.getInstance(context).getServerAddress();
            String request = new HttpClient(serverAddress.host, serverAddress.port).request(path);

            return convert(request);
        }

        public List<?> convert(String dataAsJson) {
            return JsonConverter.jsonFromObjectList(dataAsJson, typeToken);
        }
    }
}