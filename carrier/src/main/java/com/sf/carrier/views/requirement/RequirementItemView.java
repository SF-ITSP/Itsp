package com.sf.carrier.views.requirement;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sf.carrier.R;
import com.sf.contacts.domain.Requirement;

import org.joda.time.DateTime;

public class RequirementItemView extends LinearLayout {
    private TextView startView;
    private TextView endDateView;
    private TextView vehicleModelView;
    private TextView capacityWeightView;

    public RequirementItemView(Context context) {
        super(context);
        initUi();
    }

    public RequirementItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi();
    }

    public RequirementItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initUi();
    }

    private void initUi() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.requirement_item_view, this, true);
        startView = (TextView) inflate.findViewById(R.id.start_date_view);
        endDateView = (TextView) inflate.findViewById(R.id.end_date_view);
        vehicleModelView = (TextView) inflate.findViewById(R.id.vehicle_model_view);
        capacityWeightView = (TextView) inflate.findViewById(R.id.capacity_weight_view);
    }

    public void setModel(Requirement requirement) {
        String startDatetime = new DateTime(requirement.getStartDate()).toString("MM月dd日 HH:mm");
        String endDatetime = new DateTime(requirement.getEndDate()).toString("MM月dd日 HH:mm");
        startView.setText(startDatetime);
        endDateView.setText(endDatetime);
        vehicleModelView.setText(requirement.getVehicleModel());
        capacityWeightView.setText(String.valueOf(requirement.getCapacityWeight()));
    }
}