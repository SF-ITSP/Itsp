package com.sf.carrier.views.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.sf.carrier.R;

public class AssignDriverDialogFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assign_driver_dialog, container);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        return view;
    }
}
