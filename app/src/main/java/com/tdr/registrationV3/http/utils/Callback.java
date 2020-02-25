package com.tdr.registrationV3.http.utils;


import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.http.ApiException;
import com.tdr.registrationV3.http.Stateful;
import com.tdr.registrationV3.service.BaseView;
import com.tdr.registrationV3.utils.LogUtil;
import com.tdr.registrationV3.utils.ToastUtil;

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
                onFail("网络请求异常");
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
        } else if(result.getCode() == 1007) {
            onFail("登录失效，请重新登录");
        }else {
            onFail(result.getMsg());
        }


    }

    public void onResponse(T data) {

        ((BaseView) target).loadingSuccessForData(data);

    }


    public void onFail(String msg) {
        if (target != null) {
            target.setState(BaseConstants.STATE_SUCCESS);
            ((BaseView) target).loadingFail(msg);
            ToastUtil.showWX(msg);
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