package com.sf.carrier.views.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sf.carrier.R;
import com.sf.contacts.domain.Vehicle;

import java.util.List;

public class VehicleViewHolder extends RecyclerView.ViewHolder {
    private TextView vehicleNumberTextValue;
    private TextView weightTextValue;
    private TextView vehicleTypeTextValue;
    private ImageView hasSelectedImage;

    public VehicleViewHolder(View itemView) {
        super(itemView);
    }

    public void initView(View view) {
        vehicleNumberTextValue = (TextView) view.findViewById(R.id.vehicle_number);
        weightTextValue = (TextView) view.findViewById(R.id.weight);
        vehicleTypeTextValue = (TextView) view.findViewById(R.id.vehicle_type);
        hasSelectedImage = (ImageView) view.findViewById(R.id.has_selected);
    }

    public void initData(List<Vehicle> vehicleList, int position){
        vehicleNumberTextValue.setText(vehicleList.get(position).getVehicleNumber());
        weightTextValue.setText(vehicleList.get(position).getWeight() + "吨-");
        vehicleTypeTextValue.setText(vehicleList.get(position).getType());
        hasSelectedImage.setImageResource(R.drawable.selected2);
    }
}
