package com.sf.itsp.tasks;

import android.content.Context;
import android.view.ViewGroup;

import com.sf.app.library.adapters.ItspBaseAdapter;
import com.sf.app.library.domain.DriverTask;

public class DriverTaskAdapter extends ItspBaseAdapter<DriverTaskItemView, DriverTask> {

    public DriverTaskAdapter(Context context) {
        super(context);
    }

    @Override
    protected void updateView(DriverTaskItemView view, int position) {
        view.setModel(getItem(position));
    }

    @Override
    protected DriverTaskItemView buildView(ViewGroup parent) {
        return new DriverTaskItemView(context);
    }
}
