package com.tdr.registrationv3.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.constants.UrlConstants;


public class GlideUtil {

    /**
     * 压缩图
     *
     * @param context
     * @param photoId
     * @param imageView
     */
    public static void setImg(Context context, String photoId, final ImageView imageView) {
        String url = UrlConstants.main_host_service + "api/ddc-service/zimgCommon/getImg?photoId=" + photoId + "&width=120&height=120&quality=30";

        Glide.with(context).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageView.setBackgroundDrawable(new BitmapDrawable(resource));
            }
        });

    }

    /**
     * 原图
     *
     * @param
     * @param context
     * @param photoId
     * @param imageView
     */
    public static void setImgOriginal(Context context, String photoId, final ImageView imageView) {
        String url = UrlConstants.main_host_service + "api/ddc-service/zimgCommon/getImg?photoId=" + photoId;

        Glide.with(context).load(url).asBitmap()
                .placeholder(R.mipmap.image_load)//图片加载出来前，显示的图片
                .fallback(R.mipmap.yl_load_error) //url为空的时候,显示的图片
                .error(R.mipmap.yl_load_error)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                        imageView.setImageBitmap(resource);
                    }
                });

    }
}
