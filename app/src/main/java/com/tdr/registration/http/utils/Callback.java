package com.tdr.registration.http.utils;



import com.parry.utils.code.ToastUtils;
import com.tdr.registration.AppConstants;
import com.tdr.registration.http.Stateful;
import com.tdr.registration.presenter.BaseView;
import com.tdr.registration.utils.LogUtil;

import rx.Subscriber;

/**
 * Created by parry
 */

public class Callback<T> extends Subscriber<T> {
    private Stateful target;

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
            e.printStackTrace();
            LogUtil.e("retrofit2_Callback_onError=     " + e.toString());
            onFail(e.toString());
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
                target.setState(AppConstants.STATE_SUCCESS);
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
            target.setState(AppConstants.STATE_ERROR);
            ((BaseView) target).loadingFail(msg);
            ToastUtils.showShort(msg);
        }

    }
}
