package com.sf.carrier.views.fragments;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.sf.app.library.connectivity.ConnectionProxy;
import com.sf.carrier.R;
import com.sf.contacts.domain.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

public class AssignDriverDialogFragment extends DialogFragment {
    public static final String ASSIGN_DRIVER_TAG = "anyString";
    private ImageView driverImage;
    private TextView nameTextValue;
    private TextView drivingLicenseTypeTextValue;
    private TextView ageTextValue;
    private TextView drivingExperienceTextValue;

    private TextView assignMainDriverButton;
    private long driverId;

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assign_driver_dialog, container);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        driverImage = (ImageView) view.findViewById(R.id.assign_driver_image);
        nameTextValue = (TextView) view.findViewById(R.id.name_value);
        ageTextValue = (TextView) view.findViewById(R.id.age_value);

        drivingLicenseTypeTextValue = (TextView) view.findViewById(R.id.driving_license_type_value);
        drivingExperienceTextValue = (TextView) view.findViewById(R.id.driving_experience_value);

        assignMainDriverButton = (TextView) view.findViewById(R.id.assign_main_driver);
        assignMainDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView driverSelectButton = (ImageView) getActivity().findViewById(R.id.is_main_driver);
                driverSelectButton.setImageResource(R.drawable.selected);

                dismiss();
            }
        });

        return view;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
        showDriverDetail();
    }

    private void showDriverDetail() {
        new QueryDriverAsyncTask().execute(valueOf(driverId));
    }

    private class QueryDriverAsyncTask extends AsyncTask<String, Void, List<Driver>> {
        @Override
        protected List<Driver> doInBackground(String... params) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("driverId", params[0]);

            return ConnectionProxy.getInstance().requestDriverById(getActivity().getApplicationContext(), map);
        }

        @Override
        protected void onPostExecute(List<Driver> drivers) {
            if (drivers.isEmpty()) {
                return;
            }

            initDriverInfo(drivers.get(0));
        }
    }

    private void initDriverInfo(Driver driver) {
        driverImage.setImageResource(R.drawable.user);
        nameTextValue.setText(driver.getName());
        drivingLicenseTypeTextValue.setText(driver.getDrivingLicenseType());
        ageTextValue.setText(valueOf(driver.getAge()));
        drivingExperienceTextValue.setText(valueOf(driver.getDrivingExperience()));
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }
}
