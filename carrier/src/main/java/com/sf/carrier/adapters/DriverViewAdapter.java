package com.sf.carrier.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sf.carrier.R;
import com.sf.contacts.domain.Driver;

import java.util.List;

public class DriverViewAdapter extends RecyclerView.Adapter<DriverViewAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Driver> driverList;

    public DriverViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public ImageView driverImage;
        public TextView driverName;
        public TextView licensePlateGrade;
        public TextView driverAge;
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.driver_item_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.driverImage = (ImageView) view.findViewById(R.id.driver_image);
        viewHolder.driverName = (TextView) view.findViewById(R.id.driver_name);
        viewHolder.licensePlateGrade = (TextView) view.findViewById(R.id.license_plate_grade);
        viewHolder.driverAge = (TextView) view.findViewById(R.id.driver_age);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        viewHolder.driverImage.setImageResource(driverList.get(i).getDriverImageId());
        viewHolder.driverName.setText(driverList.get(i).getDriverName());
        viewHolder.licensePlateGrade.setText(driverList.get(i).getLicensePlateGrade());
        viewHolder.licensePlateGrade.setText(driverList.get(i).getDriverAge());
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }
}
