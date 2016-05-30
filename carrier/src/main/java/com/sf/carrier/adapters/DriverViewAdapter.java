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

import java.util.ArrayList;
import java.util.List;

public class DriverViewAdapter extends RecyclerView.Adapter<DriverViewAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Driver> driverList = new ArrayList<Driver>();
    private OnItemClickLitener mOnItemClickLitener;

    public DriverViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public ImageView imageId;
        public TextView name;
        public TextView drivingLicenseType;
        public TextView age;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.driver_item_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.imageId = (ImageView) view.findViewById(R.id.driver_image);
        viewHolder.name = (TextView) view.findViewById(R.id.driver_name);
        viewHolder.drivingLicenseType = (TextView) view.findViewById(R.id.driver_driving_license_type);
        viewHolder.age = (TextView) view.findViewById(R.id.driver_age);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.imageId.setImageResource(driverList.get(position).getImageId());
        viewHolder.name.setText(driverList.get(position).getName());
        viewHolder.drivingLicenseType.setText(driverList.get(position).getDrivingLicenseType() + ",");
        viewHolder.age.setText(String.valueOf(driverList.get(position).getAge()));

        if (mOnItemClickLitener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(viewHolder.itemView, position);
                }
            });
        }
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }
}
