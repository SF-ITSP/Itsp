package com.sf.carrier.adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.sf.app.library.adapters.ItspBaseAdapter;
import com.sf.carrier.views.requirement.RequirementItemView;
import com.sf.contacts.domain.Requirement;

public class RequirementAdapter extends ItspBaseAdapter<RequirementItemView, Requirement> {
    public RequirementAdapter(Context context) {
        super(context);
    }

    @Override
    protected void updateView(RequirementItemView view, int position) {
        view.setModel(items.get(position));
    }

    @Override
    protected RequirementItemView buildView(ViewGroup parent) {
        return new RequirementItemView(context);
    }

}
