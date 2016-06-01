package com.sf.carrier.views.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sf.carrier.R;
import com.sf.carrier.adapters.VehicleViewAdapter;
import com.sf.contacts.domain.Vehicle;

import java.util.List;

public class VehicleViewHolder extends RecyclerView.ViewHolder {
    private TextView vehicleNumberTextValue;
    private TextView weightTextValue;
    private TextView vehicleTypeTextValue;
    public ImageView isSelectedImage;

    private VehicleViewAdapter adapter;

    public VehicleViewHolder(View itemView, VehicleViewAdapter adapter) {
        super(itemView);
        this.adapter = adapter;
    }

    public void initView(View view) {
        vehicleNumberTextValue = (TextView) view.findViewById(R.id.vehicle_number);
        weightTextValue = (TextView) view.findViewById(R.id.weight);
        vehicleTypeTextValue = (TextView) view.findViewById(R.id.vehicle_type);
        isSelectedImage = (ImageView) view.findViewById(R.id.is_selected);
    }

    public void initData(List<Vehicle> vehicleList, int position){
        vehicleNumberTextValue.setText(vehicleList.get(position).getVehicleNumber());
        weightTextValue.setText(vehicleList.get(position).getWeight() + "吨-");
        vehicleTypeTextValue.setText(vehicleList.get(position).getType());
        isSelectedImage.setImageResource(R.drawable.selected2);
    }

    public void setSelectedImage(int position) {
        if (position == adapter.getCurrentPosition()) {
            isSelectedImage.setImageResource(R.drawable.selected);
        } else {
            isSelectedImage.setImageResource(R.drawable.selected2);
        }
    }
}
