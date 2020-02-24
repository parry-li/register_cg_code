package com.tdr.registrationV3.service.impl;


import com.tdr.registrationV3.http.utils.Callback;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.BasePresenter;
import com.tdr.registrationV3.service.BaseService;
import com.tdr.registrationV3.service.presenter.BaseRequestPresenter;

import okhttp3.RequestBody;


public class BaseRequestImpl extends BasePresenter<BaseRequestPresenter.View> implements BaseRequestPresenter.Presenter {
    private BaseService mService;

    public BaseRequestImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }


    @Override
    public void put(String url, RequestBody route) {
        invoke(mService.baseRequest(url, route), new Callback<DdcResult>() {
            @Override
            public void onResponse(DdcResult data) {
                if (data.getCode() == 0) {

                    mView.loadingSuccessForData(data);
                } else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }
}
