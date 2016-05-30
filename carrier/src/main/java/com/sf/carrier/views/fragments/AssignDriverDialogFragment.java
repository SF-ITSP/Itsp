package com.sf.carrier.views.fragments;

import android.app.DialogFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.sf.app.library.connectivity.ConnectionProxy;
import com.sf.carrier.CarrierApplication;
import com.sf.carrier.R;
import com.sf.contacts.domain.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignDriverDialogFragment extends DialogFragment {
    private ImageView driverImage;
    private TextView nameTextValue;
    private TextView drivingLicenseTypeTextValue;
    private TextView ageTextValue;
    private TextView drivingExperienceTextValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assign_driver_dialog, container);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        driverImage = (ImageView) view.findViewById(R.id.driver_image);
        nameTextValue = (TextView) view.findViewById(R.id.name_value);
        drivingLicenseTypeTextValue = (TextView) view.findViewById(R.id.driving_license_type_value);
        ageTextValue = (TextView) view.findViewById(R.id.age_value);
        drivingExperienceTextValue = (TextView) view.findViewById(R.id.driving_experience_value);

        return view;
    }

    public void getClickedDriverInfo(final int position) {
        CarrierApplication application = new CarrierApplication();
        application.setDriverId(position + 1);

        new AsyncTask<String, Void, List<Driver>>() {
            @Override
            protected List<Driver> doInBackground(String... params) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("driverId", params[0]);

                return ConnectionProxy.getInstance().requestDriverById(getActivity().getApplicationContext(), map);
            }

            @Override
            protected void onPostExecute(List<Driver> drivers) {
                initDriverInfo(drivers.get(0));
            }
        }.execute(String.valueOf(application.getDriverId()));
    }

    private void initDriverInfo(Driver driver) {
        driverImage.setImageResource(R.drawable.user);
        nameTextValue.setText(driver.getName());
        drivingLicenseTypeTextValue.setText(driver.getDrivingLicenseType());
        ageTextValue.setText(String.valueOf(driver.getAge()));
        drivingExperienceTextValue.setText(String.valueOf(driver.getDrivingExperience()));
    }
}
