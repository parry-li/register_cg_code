package com.tdr.registrationv3.utils;

import android.graphics.Bitmap;

import com.tdr.registrationv3.bean.PhotoBean;
import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.listener.CustomSendLister;
import com.tdr.registrationv3.listener.CustomSendOperater;
import com.tdr.registrationv3.service.BaseService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageSendUtil {

    /**
     * 得到标签
     */
    public static void sendImage(final Bitmap bitmap, final int photoPosition, final CustomSendLister customSendLister) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap mbitmap = PhotoUtils.getResultCameraPhotoCompress(bitmap);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(UrlConstants.main_host_service)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                BaseService service = retrofit.create(BaseService.class);

                final CustomSendOperater operater = new CustomSendOperater();
                operater.setListener(customSendLister);
                Call<DdcResult<PhotoBean>> call = service.sendImage(UrlConstants.zimgCommon_uploadMultFile, PhotoUtils.getRequestFile(mbitmap));
                call.enqueue(new Callback<DdcResult<PhotoBean>>() {
                    @Override
                    public void onResponse(Call<DdcResult<PhotoBean>> call, Response<DdcResult<PhotoBean>> response) {
                     String photoId =   response.body().getData().getPhotoId();
                        LogUtil.i("photoId:   "+photoId);
                        operater.sendResult(true, photoPosition,photoId);


                    }

                    @Override
                    public void onFailure(Call<DdcResult<PhotoBean>> call, Throwable t) {
                        operater.sendResult(false, photoPosition,"");

                    }
                });
            }
        }).start();


    }
}
