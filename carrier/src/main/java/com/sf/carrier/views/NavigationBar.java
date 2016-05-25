package com.sf.carrier.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sf.carrier.R;

public class NavigationBar extends RelativeLayout {
    private Context context;
    private Button backButton;
    private TextView titleView;

    public NavigationBar(Context context) {
        super(context);
        this.context = context;
        initUI();
    }

    public NavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initUI();
    }

    public NavigationBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.navigation_bar, this);

        backButton = (Button) findViewById(R.id.back_button);
        titleView = (TextView) findViewById(R.id.title_view);
    }

    public void setOnBackButtonClickedListener(OnClickListener listener) {
        backButton.setOnClickListener(listener);
    }

    public void setTitle(int titleResId) {
        titleView.setText(titleResId);
    }
}
