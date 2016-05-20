package sf.com.itsp;

import android.widget.ListView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import sf.com.itsp.fragment.TaskFragment;
import sf.com.itsp.shadows.ShadowConnectionProxy;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static sf.com.itsp.testCondition.ContainsTextCondition.text;
import static sf.com.itsp.testCondition.ListViewChildCondition.childWith;
import static sf.com.itsp.testCondition.ListViewContainsItemsCondition.numberOfItems;
import static sf.com.itsp.utils.TaskProvider.mockTaskResponse;
import static sf.com.itsp.utils.VehicleProvider.mockVehicleResponse;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class)
public class TaskFragmentTest {

    @After
    public void teardown() {
        ShadowConnectionProxy.clearAll();
    }

    @Test
    @Config(constants = BuildConfig.class, sdk = 17, shadows = {ShadowConnectionProxy.class})
    public void should_show_tasks_when_on_created() {
        //given
        mockTaskResponse();
        TaskFragment taskFragment = new TaskFragment();
        SupportFragmentTestUtil.startFragment(taskFragment);

        //when
        ListView listView = (ListView) taskFragment.getView().findViewById(R.id.task_list);
        runBackgroundTasks();

        //then
        assertThat(listView).has(numberOfItems(2));
        assertThat(listView).has(childWith(text("深圳市中转场")));
        assertThat(listView).has(childWith(text("长沙中转场")));

        assertThat(listView).has(childWith(text("装车")));
        assertThat(listView).has(childWith(text("卸车")));

        assertThat(listView).has(childWith(text("10:00")));
        assertThat(listView).has(childWith(text("24:00")));

        assertThat(listView).has(childWith(text("10:30")));

        assertThat(listView).has(childWith(text(120)));
        assertThat(listView).has(childWith(text(30)));

        assertThat(listView).has(childWith(text("始发")));
        assertThat(listView).has(childWith(text("经停")));
    }

    @Test
    @Config(constants = BuildConfig.class, sdk = 17, shadows = {ShadowConnectionProxy.class})
    public void should_show_vehicle_number_when_on_created() {
        //given
        mockVehicleResponse();
        TaskFragment taskFragment = new TaskFragment();

        //when
        SupportFragmentTestUtil.startFragment(taskFragment);
        TextView vehicleNumber = (TextView) taskFragment.getView().findViewById(R.id.vehicle_number);
        runBackgroundTasks();

        //then
//        assertThat(vehicleNumber).has(text("粤A-123456"));
    }
}
