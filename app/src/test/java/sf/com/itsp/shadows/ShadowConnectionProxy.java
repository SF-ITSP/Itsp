package sf.com.itsp.shadows;

import org.robolectric.annotation.Implements;

import java.util.List;

import com.sf.app.library.connectivity.ConnectionProxy;
import com.sf.contacts.domain.Task;
import com.sf.contacts.domain.Vehicle;

import static com.google.common.collect.Lists.newArrayList;

@Implements(ConnectionProxy.class)
public class ShadowConnectionProxy {
    private static List<Task> tasks = newArrayList();

    private static List<Vehicle> vehicles = newArrayList();

    public static void fakeTasks(List<Task> fakedTasks) {
        tasks = fakedTasks;
    }

    public static void fakeVehicles(List<Vehicle> fakedVehicles) {
        vehicles = fakedVehicles;
    }

    public static void clearAll() {
        tasks = newArrayList();

        vehicles = newArrayList();
    }
}