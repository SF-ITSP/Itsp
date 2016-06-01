package com.sf.itsp.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.sf.app.library.connectivity.ConnectionProxy;
import com.sf.app.library.domain.DriverTask;
import com.sf.itsp.R;
import com.sf.itsp.tasks.DriverTaskAdapter;

import java.util.List;

public class TaskFragment extends Fragment {
    private TextView vehicleNumber;

    private DriverTaskAdapter driverTaskAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_fragment, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        initMissionInfoView(view);

        initTaskListView(view);
    }

    private void initTaskListView(View view) {
        driverTaskAdapter = new DriverTaskAdapter(getActivity().getApplicationContext());
        ListView listView = (ListView) view.findViewById(R.id.task_list_view);
        listView.setAdapter(driverTaskAdapter);
    }

    private void initMissionInfoView(View view) {
        vehicleNumber = (TextView) view.findViewById(R.id.vehicle_number_view);
    }

    public void initData() {
        initTaskList();
    }

    private void initTaskList() {
        new AsyncTask<Void, Void, List<DriverTask>>() {
            @Override
            protected List<DriverTask> doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestDriverTasks(getActivity().getApplicationContext());
            }

            @Override
            protected void onPostExecute(List<DriverTask> driverTask) {
                driverTaskAdapter.setItems(driverTask);
            }
        }.execute();
    }
}