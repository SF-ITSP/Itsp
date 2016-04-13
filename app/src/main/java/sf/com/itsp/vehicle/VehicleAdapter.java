package sf.com.itsp.vehicle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Vehicle;

public class VehicleAdapter extends ArrayAdapter<VehicleModel> {
    private int itemLayout;

    public VehicleAdapter(Context context, int textViewResourceId, List<VehicleModel> vehicleModelList) {
        super(context, textViewResourceId, vehicleModelList);
        itemLayout = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vehicleItem = inflater.inflate(itemLayout, parent, false);
        ImageView photo = (ImageView) vehicleItem.findViewById(R.id.vehicle_item_photo);
        TextView name = (TextView) vehicleItem.findViewById(R.id.vehicle_item_name);
        ImageView selectedIcon = (ImageView) vehicleItem.findViewById(R.id.selected_icon);
        VehicleModel vehicleModel = getItem(position);
        photo.setImageResource(vehicleModel.getPhoto());
        name.setText(vehicleModel.getName());
        selectedIcon.setVisibility(vehicleModel.getIsSelected() ? ImageView.VISIBLE : ImageView.INVISIBLE);
        return vehicleItem;
    }

}
