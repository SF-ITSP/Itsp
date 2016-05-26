package com.sf.itsp.tasks;

import android.content.Context;
import android.view.ViewGroup;

import com.sf.app.library.adapters.ItspBaseAdapter;
import com.sf.contacts.domain.Task;

public class TaskAdapter extends ItspBaseAdapter<TaskItemView, Task> {

    public TaskAdapter(Context context) {
        super(context);
    }

    @Override
    protected void updateView(TaskItemView view, int position) {
        view.setModel(getItem(position));
    }

    @Override
    protected TaskItemView buildView(ViewGroup parent) {
        return new TaskItemView(context);
    }
}
