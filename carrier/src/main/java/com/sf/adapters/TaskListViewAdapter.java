package com.sf.adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.sf.R;
import com.sf.activities.UnScheduleActivity;
import com.sf.views.fragments.TaskSelectionItemView;

import java.util.Arrays;
import java.util.List;

import static com.sf.adapters.TaskListViewAdapter.TaskTypeSelection.toList;

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

        public static List toList() {
            return Arrays.asList(Unscheduled, Executing, Pending);
        }
    }
}
