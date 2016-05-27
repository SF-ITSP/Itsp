package com.sf.carrier.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.sf.carrier.R;
import com.sf.carrier.adapters.TaskListViewAdapter;

import static com.sf.carrier.adapters.TaskListViewAdapter.TaskTypeSelection.values;

public class TaskFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.task_fragment, container, false);

        ListView taskListView = (ListView) inflate.findViewById(R.id.task_list_view);
        TaskListViewAdapter adapter = new TaskListViewAdapter(getActivity().getApplicationContext());
        taskListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                values()[position].startActivity(getActivity().getApplicationContext());
            }
        });
        taskListView.setAdapter(adapter);
        return inflate;
    }
}