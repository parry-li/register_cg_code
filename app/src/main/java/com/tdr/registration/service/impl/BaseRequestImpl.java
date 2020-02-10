package com.tdr.registration.service.impl;


import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.BaseRequestPresenter;

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
