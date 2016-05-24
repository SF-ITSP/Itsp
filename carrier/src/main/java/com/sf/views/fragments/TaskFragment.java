package com.sf.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.sf.R;
import com.sf.adapters.TaskListViewAdapter;

import static com.sf.adapters.TaskListViewAdapter.TaskTypeSelection.values;

public class TaskFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.task_fragment, container, false);

        ListView taskListView = (ListView) inflate.findViewById(R.id.task_list_view);
        TaskListViewAdapter adapter = new TaskListViewAdapter(getActivity().getApplicationContext());
        taskListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity().getApplicationContext(), values()[position].clazz);
                startActivity(intent);
            }
        });
        taskListView.setAdapter(adapter);
        return inflate;
    }
}