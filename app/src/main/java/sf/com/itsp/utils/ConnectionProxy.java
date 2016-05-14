package sf.com.itsp.utils;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.util.List;

import sf.com.itsp.connectivity.HttpClient;
import sf.com.itsp.domain.ServerAddress;
import sf.com.itsp.domain.Task;
import sf.com.itsp.domain.Vehicle;

import static sf.com.itsp.utils.ConnectionProxy.RequestPath.Tasks;
import static sf.com.itsp.utils.ConnectionProxy.RequestPath.Vehicles;

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