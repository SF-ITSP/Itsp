package sf.com.itsp.activities;

import android.widget.ListView;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import java.io.Serializable;

import sf.com.itsp.BasicTestRunner;
import sf.com.itsp.BuildConfig;
import sf.com.itsp.R;
import sf.com.itsp.shadows.ShadowConnectionProxy;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static sf.com.itsp.testHelper.condition.ActivityStartedCondition.startedActivity;
import static sf.com.itsp.testHelper.condition.ContainsTextCondition.text;
import static sf.com.itsp.testHelper.condition.ListViewChildCondition.childWith;
import static sf.com.itsp.testHelper.condition.ListViewContainsItemCondition.numberOfItems;
import static sf.com.itsp.utils.OrderProvider.mockOrderResponse;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 17, shadows = {ShadowConnectionProxy.class})
public class MainActivityTest {

    @After
    public void teardown() {
        ShadowConnectionProxy.clearAll();
    }

    @Test
    public void should_show_orders_when_on_created() {
        // given
        mockOrderResponse();
        ActivityController<MainActivity> mainActivityActivityController = buildActivity(MainActivity.class);
        MainActivity mainActivity = mainActivityActivityController.get();

        // when
        mainActivityActivityController.create();
        ListView listView = (ListView) mainActivity.findViewById(R.id.order_list);
        runBackgroundTasks();

        // then
        assertThat(listView).has(numberOfItems(2));
        assertThat(listView).has(childWith(text("original2 -- target2")));
        assertThat(listView).has(childWith(text("2.0")));
        assertThat(listView).has(childWith(text("车型2")));
        assertThat(listView).has(childWith(text("2")));
        assertThat(listView).has(childWith(text("2016-04-03 -- 2016-04-06")));
    }

    @Test
    public void should_goto_specify_order_detail_activity_when_click_item_on_list_view() {
        // given
        mockOrderResponse();

        ActivityController<MainActivity> mainActivityActivityController = buildActivity(MainActivity.class).create();
        MainActivity mainActivity = mainActivityActivityController.get();

        ListView orderListView = (ListView) mainActivity.findViewById(R.id.order_list);

        // when
        orderListView.performItemClick(null, 1, 0);

        // then
        assertThat(mainActivity).has(startedActivity(OrderDetailActivity.class)
                .withSerializableData("order", (Serializable) orderListView.getAdapter().getItem(1)));
    }
}