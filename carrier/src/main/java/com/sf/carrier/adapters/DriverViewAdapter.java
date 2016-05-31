package com.sf.carrier.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sf.carrier.R;
import com.sf.carrier.views.viewHolder.DriverViewHolder;
import com.sf.contacts.domain.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverViewAdapter extends RecyclerView.Adapter<DriverViewHolder> {

    private LayoutInflater inflater;
    private List<Driver> driverList = new ArrayList<Driver>();
    private final OnItemClickListener onItemClickListener;

    public DriverViewAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        inflater = LayoutInflater.from(context);
    }

    public interface OnItemClickListener {
        void onItemClick(Driver driver);
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

    @Override
    public DriverViewHolder onCreateViewHolder(ViewGroup viewGroup, final int position) {
        View view = inflater.inflate(R.layout.driver_item_view, viewGroup, false);
        DriverViewHolder viewHolder = new DriverViewHolder(view);

        viewHolder.initView(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final DriverViewHolder viewHolder, final int position) {
        viewHolder.initData(driverList, position);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(driverList.get(position));
            }
        });
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
        notifyDataSetChanged();
    }
}