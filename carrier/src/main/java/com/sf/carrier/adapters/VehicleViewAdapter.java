package com.sf.carrier.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sf.carrier.R;
import com.sf.carrier.views.viewHolder.VehicleViewHolder;
import com.sf.contacts.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleViewAdapter extends RecyclerView.Adapter<VehicleViewHolder> {

    private LayoutInflater inflater;
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private OnItemClickListener mOnItemClickListener;

    public VehicleViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    @Override
    public VehicleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.vehicle_item_view, viewGroup, false);
        VehicleViewHolder viewHolder = new VehicleViewHolder(view);

        viewHolder.initView(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VehicleViewHolder viewHolder, final int position) {
        viewHolder.initData(vehicleList, position);

        if (mOnItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(viewHolder.itemView, position);
                }
            });
        }
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
        notifyDataSetChanged();
    }
}
