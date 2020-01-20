package com.tdr.registration.http.utils;


import com.google.gson.JsonParseException;
import com.parry.utils.code.ToastUtils;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.http.Stateful;
import com.tdr.registration.service.BaseView;
import com.tdr.registration.utils.LogUtil;

import org.json.JSONException;

import java.text.ParseException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by parry
 */

public class Callback<T> extends Subscriber<T> {
    private Stateful target;

    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public void setTarget(Stateful target) {
        this.target = target;
    }

    public void detachView() {
        if (target != null) {
            target = null;
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        try {
            if (e instanceof HttpException) {             //HTTP错误
                HttpException httpException = (HttpException) e;
                switch (httpException.code()) {
                    case UNAUTHORIZED:
                    case FORBIDDEN:
                        onFail(e.toString());       //权限错误，需要实现
                        break;
                    case NOT_FOUND:
                    case REQUEST_TIMEOUT:

                    case GATEWAY_TIMEOUT:
                        onFail("网络请求失败，请检查网络");
                        break;
                    case INTERNAL_SERVER_ERROR:
                    case BAD_GATEWAY:
                    case SERVICE_UNAVAILABLE:
                    default:
                        onFail(e.toString());   //均视为网络错误
                        break;
                }
            }
            LogUtil.e("retrofit2_Callback_onError=     " + e.toString());

            return;
        } catch (Exception exception) {
            LogUtil.e("retrofit2_Callback_onError_exception=    " + exception);
        }
    }

    @Override
    public void onNext(T data) {

        DdcResult result = (DdcResult) data;
        if (result.getCode() == 0) {
            if (target != null) {
                target.setState(BaseConstants.STATE_SUCCESS);
            }
            onResponse(data);
        } else {
            onFail(result.getMsg());
        }


    }

    public void onResponse(T data) {

        ((BaseView) target).loadingSuccessForData(data);

    }


    public void onFail(String msg) {
        if (target != null) {
            target.setState(BaseConstants.STATE_ERROR);
            ((BaseView) target).loadingFail(msg);
            ToastUtils.showShort(msg);
        }

    }
}
