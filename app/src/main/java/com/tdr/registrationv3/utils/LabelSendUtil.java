package com.tdr.registrationv3.utils;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.listener.CustomSendLister;
import com.tdr.registrationv3.listener.CustomSendOperater;
import com.tdr.registrationv3.service.BaseService;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LabelSendUtil {

    /**
     * 得到标签
     */
    public static void checkLabel(final int photoPosition, final String lableNumber, final CustomSendLister customSendLister) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(UrlConstants.main_host_service)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                BaseService service = retrofit.create(BaseService.class);

                final CustomSendOperater operater = new CustomSendOperater();
                operater.setListener(customSendLister);

                int subsystemId = SPUtils.getInstance().getInt(BaseConstants.City_systemID);
                Map<String, Object> map = new HashMap<>();
                map.put("lableNumber", lableNumber);
                map.put("subsystemId", subsystemId);
                Call<DdcResult> call = service.checkLabel(UrlConstants.electriccars_checkOnlyOneLabel, getRequestBody(map));
                call.enqueue(new Callback<DdcResult>() {
                    @Override
                    public void onResponse(Call<DdcResult> call, Response<DdcResult> response) {
                        DdcResult data = (DdcResult) response.body();
                        if (data.getCode() == 0) {
                            operater.sendResult(true, photoPosition, lableNumber);
                        } else {
                            operater.sendResult(false, photoPosition, lableNumber);
                        }
                    }

                    @Override
                    public void onFailure(Call<DdcResult> call, Throwable t) {
                        operater.sendResult(true, photoPosition, lableNumber);

                    }
                });
            }
        }).start();


    }

    public static RequestBody getRequestBody(Map<String, Object> stringMap) {
        String strEntity = new Gson().toJson(stringMap);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), strEntity);
        return body;
    }
}
