package com.tdr.registrationV3.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tdr.registrationV3.constants.UrlConstants;


public class GlideUtil {

    public static void setImg(Context context, String photoId, ImageView imageView) {
        String url = UrlConstants.main_host_service + "api/ddc-service/zimgCommon/getImg?photoId="+photoId+"&width=120&height=120&quality=30";
        Glide.with(context)
                .load(url)
                .into(imageView);

    }
}
