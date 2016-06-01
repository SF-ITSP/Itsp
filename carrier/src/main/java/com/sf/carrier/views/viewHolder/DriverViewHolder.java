package com.sf.carrier.views.viewHolder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sf.carrier.CarrierApplication;
import com.sf.carrier.R;
import com.sf.carrier.adapters.DriverViewAdapter;
import com.sf.contacts.domain.Driver;

import java.util.List;

public class DriverViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageId;
    private TextView nameTextValue;
    private TextView drivingLicenseTypeTextValue;
    private TextView ageTextValue;
    private ImageView isMainDriverImage;

    private DriverViewAdapter adapter;

    public DriverViewHolder(View itemView, DriverViewAdapter adapter) {
        super(itemView);
        this.adapter = adapter;
    }

    public void initView(View view) {
        imageId = (ImageView) view.findViewById(R.id.driver_image);
        nameTextValue = (TextView) view.findViewById(R.id.driver_name);
        drivingLicenseTypeTextValue = (TextView) view.findViewById(R.id.driver_driving_license_type);
        ageTextValue = (TextView) view.findViewById(R.id.driver_age);
        isMainDriverImage = (ImageView) view.findViewById(R.id.is_main_driver);
    }

    public void initData(List<Driver> driverList, int position) {
        imageId.setImageBitmap(toRoundCorner(BitmapFactory.decodeResource(CarrierApplication.getAppContext().getResources(), R.drawable.user), 360));
        nameTextValue.setText(driverList.get(position).getName());
        drivingLicenseTypeTextValue.setText(driverList.get(position).getDrivingLicenseType() + ",");
        ageTextValue.setText(driverList.get(position).getAge() + "岁");
        isMainDriverImage.setVisibility(View.GONE);
    }

    public void setSelectedMainDriverImage(int position) {
        if (position == adapter.getCurrentPosition()) {
            isMainDriverImage.setVisibility(View.VISIBLE);
        } else {
            isMainDriverImage.setVisibility(View.GONE);
        }
    }

    public static Bitmap toRoundCorner(Bitmap image, int pixels) {
        Bitmap output = Bitmap.createBitmap(image.getWidth(), image.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, image.getWidth(), image.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(image, rect, rect, paint);

        return output;
    }
}
