package com.sf.itsp.tasks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sf.contacts.domain.Task;

import com.sf.itsp.R;

public class TaskItemView extends LinearLayout {
    private TextView addressValueTextView;
    private TextView operationValueTextView;
    private TextView arriveTimeValueTextView;
    private TextView latestDepartureTimeValueTextView;
    private TextView waitingTimeValueTextView;
    private TextView vehicleStatusValueTextView;

    public TaskItemView(Context context) {
        super(context);
        initUi();
    }

    public TaskItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi();
    }

    public TaskItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initUi();
    }

    private void initUi() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.task_item, this, true);

        addressValueTextView = (TextView) findViewById(R.id.address_name);
        operationValueTextView = (TextView) findViewById(R.id.operation_type);
        arriveTimeValueTextView = (TextView) findViewById(R.id.arrive_time);
        latestDepartureTimeValueTextView = (TextView) findViewById(R.id.latest_departure_time);
        waitingTimeValueTextView = (TextView) findViewById(R.id.waiting_time_value);
        vehicleStatusValueTextView = (TextView) findViewById(R.id.vehicle_status);
    }

    public void setModel(Task task) {
        addressValueTextView.setText(task.getAddress());
        operationValueTextView.setText(task.getOperation());
        arriveTimeValueTextView.setText(task.getArriveTime());
        latestDepartureTimeValueTextView.setText(task.getLatestDepartureTime());
        waitingTimeValueTextView.setText(String.valueOf(task.getWaitingTime()));
        vehicleStatusValueTextView.setText(task.getVehicleStatus());
    }
}
