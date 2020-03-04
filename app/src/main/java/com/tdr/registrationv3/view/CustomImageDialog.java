package com.tdr.registrationv3.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.tdr.registrationv3.R;
import com.tdr.registrationv3.photoview.PhotoView;
import com.tdr.registrationv3.utils.GlideUtil;


/**
 * @author parry
 * @time 2017/6/7/007 14:20
 * @des ${TODO}
 */

public class CustomImageDialog {



    private Activity context;




    public  static void showCustomWindowDialog( Activity context,String photoId) {


        final Dialog dialog = new Dialog(context, R.style.TANCStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        View convertView = LayoutInflater.from(context)
                .inflate(R.layout.activity_image, null);
        dialog.setContentView(convertView);

        RelativeLayout dialogCancel = convertView.findViewById(R.id.com_title_back);
        PhotoView photoView =  convertView.findViewById(R.id.iv_photo);

        GlideUtil.setImgOriginal(context,photoId,photoView);
        dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        WindowManager windowManager = context.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = display.getWidth(); //设置宽度
        dialog.getWindow().setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

    }



}