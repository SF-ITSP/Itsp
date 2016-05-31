package com.sf.carrier.views.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sf.carrier.R;
import com.sf.contacts.domain.Driver;

import java.util.List;

public class DriverViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageId;
    private TextView nameTextValue;
    private TextView drivingLicenseTypeTextValue;
    private TextView ageTextValue;

    public DriverViewHolder(View itemView) {
        super(itemView);
    }

    public void initView(View view) {
        imageId = (ImageView) view.findViewById(R.id.driver_image);
        nameTextValue = (TextView) view.findViewById(R.id.driver_name);
        drivingLicenseTypeTextValue = (TextView) view.findViewById(R.id.driver_driving_license_type);
        ageTextValue = (TextView) view.findViewById(R.id.driver_age);
    }

    public void initData(List<Driver> driverList, int position) {
        imageId.setImageResource(R.drawable.user);
        nameTextValue.setText(driverList.get(position).getName());
        drivingLicenseTypeTextValue.setText(driverList.get(position).getDrivingLicenseType() + ",");
        ageTextValue.setText(driverList.get(position).getAge() + "岁");
    }
}
