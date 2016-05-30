package com.sf.carrier.adapters;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.sf.app.library.adapters.ItspBaseAdapter;
import com.sf.carrier.R;
import com.sf.carrier.activities.UnScheduleActivity;
import com.sf.carrier.views.fragments.TaskSelectionItemView;

import java.util.List;

import static com.sf.carrier.adapters.TaskListViewAdapter.TaskTypeSelection.toList;
import static java.util.Arrays.asList;

public class TaskListViewAdapter extends ItspBaseAdapter {
    public TaskListViewAdapter(Context context) {
        super(context);
        super.items = toList();
    }

    @Override
    protected void updateView(View view, int position) {
        ((TaskSelectionItemView) view).setModel(TaskTypeSelection.values()[position]);
    }

    @Override
    protected View buildView(ViewGroup parent) {
        return new TaskSelectionItemView(context);
    }

    public enum TaskTypeSelection {
        Unscheduled(R.drawable.sets, R.string.unscheduled, UnScheduleActivity.class),
        Executing(R.drawable.sets, R.string.executing, UnScheduleActivity.class),
        Pending(R.drawable.sets, R.string.pending, UnScheduleActivity.class);

        public final int icon;
        public final int title;
        public static final int indicator = R.drawable.arrow;
        public final Class clazz;

        TaskTypeSelection(int icon, int title, Class clazz) {
            this.icon = icon;
            this.title = title;
            this.clazz = clazz;
        }

        public void startActivity(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            String runningActivity = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
            if (!runningActivity.equals(clazz.getName())) {
                Intent intent = new Intent(context, clazz);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }

        public static List toList() {
            return asList(Unscheduled, Executing, Pending);
        }
    }
}
