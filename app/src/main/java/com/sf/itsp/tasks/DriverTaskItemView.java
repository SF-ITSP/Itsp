package com.sf.itsp.tasks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sf.app.library.domain.DriverTask;
import com.sf.itsp.R;

public class DriverTaskItemView extends LinearLayout {

    private TextView originCity;
    private TextView originAddress;
    private TextView destinationCity;
    private TextView destinationAddress;
    private TextView weight;
    private TextView vehicleType;
    private TextView vehicleNumber;
    private TextView startTime;
    private TextView endTime;

    public DriverTaskItemView(Context context) {
        super(context);
        initUi();
    }

    public DriverTaskItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi();
    }

    public DriverTaskItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initUi();
    }

    private void initUi() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.driver_task_item, this, true);

        originCity = (TextView) findViewById(R.id.origin_city_view);
        originAddress = (TextView) findViewById(R.id.origin_address_detail_view);
        destinationCity = (TextView) findViewById(R.id.destination_city_view);
        destinationAddress = (TextView) findViewById(R.id.destination_address_detail_view);
        weight = (TextView) findViewById(R.id.weight_view);
        vehicleType = (TextView) findViewById(R.id.vehicle_type_view);
        vehicleNumber = (TextView) findViewById(R.id.vehicle_number_view);
        startTime = (TextView) findViewById(R.id.start_time_view);
        endTime = (TextView) findViewById(R.id.end_time_view);
    }

    public void setModel(DriverTask driverTask) {
        originCity.setText(driverTask.getOriginCity());
        originAddress.setText(driverTask.getOriginAddress());
        destinationCity.setText(driverTask.getDestinationCity());
        destinationAddress.setText(driverTask.getDestinationAddress());
        weight.setText(String.valueOf(driverTask.getWeight()));
        vehicleType.setText(String.valueOf(driverTask.getVehicleType()));
        vehicleNumber.setText(driverTask.getVehicleNumber());
        startTime.setText(driverTask.getStartDate().toGMTString());
        endTime.setText(driverTask.getEndDate().toGMTString());
    }
}
