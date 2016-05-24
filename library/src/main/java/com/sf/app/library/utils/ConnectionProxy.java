package com.sf.app.library.utils;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.util.List;

import com.sf.app.library.utils.connectivity.HttpClient;
import com.sf.app.library.domain.ServerAddress;
import com.sf.contacts.domain.Task;
import com.sf.contacts.domain.Vehicle;

import static com.sf.app.library.utils.ConnectionProxy.RequestPath.Tasks;
import static com.sf.app.library.utils.ConnectionProxy.RequestPath.Vehicles;

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
//        List<Task> taskList = new ArrayList<Task>();
//        taskList.add(new Task("深圳市中转场","装车","10:00","10:30",30,"始发"));
//        taskList.add(new Task("长沙中转场","卸车","24:00","10:30",120,"经停"));
//        return taskList;
        return (List<Task>) Tasks.request(context);
    }

    public List<Vehicle> requestVehicle(Context context) {
        return (List<Vehicle>) Vehicles.request(context);
    }


    public enum RequestPath {
        Tasks("tasks", Task[].class),
        Vehicles("vehicles", Vehicle[].class);

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