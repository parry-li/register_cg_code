package com.tdr.registration.http.utils;


import com.parry.utils.code.ToastUtils;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.http.ApiException;
import com.tdr.registration.http.Stateful;
import com.tdr.registration.service.BaseView;
import com.tdr.registration.utils.LogUtil;
import com.tdr.registration.utils.ToastUtil;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by parry
 *  不进行校验
 */

public class NoCallback<T> extends Callback<T>{
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
                LogUtil.i("httpException.code()      "+httpException.code());
                switch (httpException.code()) {
                    case UNAUTHORIZED:
                    case FORBIDDEN:
                        onFail("网络请求权限错误，请检查网络（"+httpException.code()+")");  //权限错误，需要实现
                        break;
                    case NOT_FOUND:
                    case REQUEST_TIMEOUT:
                    case GATEWAY_TIMEOUT:
                        onFail("网络请求超时，请检查网络（"+httpException.code()+")");
                        break;
                    case INTERNAL_SERVER_ERROR:
                    case BAD_GATEWAY:
                    case SERVICE_UNAVAILABLE:
                    default:
                        onFail("网络请求失败，请检查网络（"+httpException.code()+")");
                        break;
                }
            } else if (e instanceof ApiException) {
                onFailFw(e.getMessage());
            } else {
                onFailFw(e.getMessage());
            }
            LogUtil.e("retrofit2_Callback_onError=     " + e.getMessage());

            return;
        } catch (Exception exception) {
            LogUtil.e("retrofit2_Callback_onError_exception=    " + exception);
        }
    }

    @Override
    public void onNext(T data) {

        if (target != null) {
            target.setState(BaseConstants.STATE_SUCCESS);
        }
        onResponse(data);

    }

    public void onResponse(T data) {

        ((BaseView) target).loadingSuccessForData(data);

    }


    public void onFail(String msg) {
        if (target != null) {
            target.setState(BaseConstants.STATE_SUCCESS);
            ((BaseView) target).loadingFail(msg);
            ToastUtils.showShort(msg);
        }

    }

    public void onFailFw(String msg) {
        if (target != null) {
            target.setState(BaseConstants.STATE_SUCCESS);
            ((BaseView) target).loadingFail(msg);
            ToastUtil.showFW(msg);
        }

    }
}
