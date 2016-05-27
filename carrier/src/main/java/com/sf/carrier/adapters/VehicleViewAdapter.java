package com.sf.carrier.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sf.carrier.R;
import com.sf.contacts.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleViewAdapter extends RecyclerView.Adapter<VehicleViewAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

    public VehicleViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public TextView vehicleNumberTextValue;
        public TextView weightTextValue;
        public TextView vehicleTypeTextValue;
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.vehicle_item_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.vehicleNumberTextValue = (TextView) view.findViewById(R.id.vehicle_number);
        viewHolder.weightTextValue = (TextView) view.findViewById(R.id.weight);
        viewHolder.vehicleTypeTextValue = (TextView) view.findViewById(R.id.vehicle_type);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.vehicleNumberTextValue.setText(vehicleList.get(position).getVehicleNumber());
        viewHolder.weightTextValue.setText(vehicleList.get(position).getWeight() + "吨");
        viewHolder.vehicleTypeTextValue.setText(vehicleList.get(position).getType());
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
