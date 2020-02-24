package com.tdr.registrationV3.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.CarCheckBean;
import com.tdr.registrationV3.utils.UIUtils;


public class CarQueryDialog {


    public CarQueryDialog() {

    }


    public void showCarQueryDialog(Activity context, CarCheckBean checkBean) {


        final Dialog dialog = new Dialog(context, R.style.TANCStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        View convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_car_query, null);
        dialog.setContentView(convertView);

        TextView car_plate_number = (TextView) convertView.findViewById(R.id.car_plate_number);
        TextView car_card_id = (TextView) convertView.findViewById(R.id.car_card_id);
        TextView car_ower_name = (TextView) convertView.findViewById(R.id.car_ower_name);
        TextView car_brand_name = (TextView) convertView.findViewById(R.id.car_brand_name);
        TextView buttonConfirm = (TextView) convertView.findViewById(R.id.button_confirm);
        ImageView buttonCancel = (ImageView) convertView.findViewById(R.id.button_cancel);


        car_plate_number.setText(checkBean.getPlateNumber());
        car_card_id.setText(checkBean.getCardId());
        car_ower_name.setText(checkBean.getOwnerName());
        car_brand_name.setText(checkBean.getVehicleBrandStr());


        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (onItemClickListener != null) {
                    onItemClickListener.onCustomDialogClickListener();
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (onCancelClickListener != null) {
                    onCancelClickListener.onCancelDialogClickListener();
                }
            }
        });

        WindowManager windowManager = context.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = (display.getWidth() - UIUtils.dp2px(40)); //设置宽度
        dialog.getWindow().setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

    }


    OnItemClickListener onItemClickListener;
    OnItemCancelClickListener onCancelClickListener;

    public void setOnCustomDialogClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnCancelDialogClickListener(OnItemCancelClickListener onCancelClickListener) {
        this.onCancelClickListener = onCancelClickListener;
    }

    public interface OnItemClickListener {
        void onCustomDialogClickListener();
    }

    public interface OnItemCancelClickListener {
        void onCancelDialogClickListener();
    }
}