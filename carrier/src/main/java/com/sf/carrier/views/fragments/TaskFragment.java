package com.sf.carrier.views.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.sf.carrier.util.Constant;

import static com.sf.carrier.adapters.TaskListViewAdapter.TaskTypeSelection.values;
import static com.sf.carrier.util.Constant.INTENT_KEY_ASSISTANT;

public class TaskFragment extends Fragment {

    private BroadcastReceiver receiver;
    private TaskListViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.task_fragment, container, false);

        ListView taskListView = (ListView) inflate.findViewById(R.id.task_list_view);
        adapter = new TaskListViewAdapter(getActivity().getApplicationContext());
        taskListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                values()[position].startActivity(getActivity().getApplicationContext());
            }
        });
        taskListView.setAdapter(adapter);
        receiver = new AssistantReceiver();

        return inflate;
    }

    private void showAssistant() {

    }

    @Override
    public void onResume() {
        super.onResume();
        registerBroadcastReceiver(receiver);
    }

    private void registerBroadcastReceiver(BroadcastReceiver receiver) {
        getActivity().getApplicationContext().registerReceiver(receiver, new IntentFilter(INTENT_KEY_ASSISTANT));
    }

    private void unregisterBroadcastReceiver() {
        getActivity().getApplicationContext().unregisterReceiver(receiver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterBroadcastReceiver();
    }

    private class AssistantReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int unScheduleCount = intent.getIntExtra(Constant.INTENT_KEY_UN_SCHEDULE_COUNT, 0);

        }
    }
}