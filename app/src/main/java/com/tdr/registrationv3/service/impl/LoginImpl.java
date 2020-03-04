package com.tdr.registrationv3.service.impl;


import com.tdr.registrationv3.bean.CityConfigureBean;
import com.tdr.registrationv3.bean.LoginBean;
import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.http.utils.Callback;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.BasePresenter;
import com.tdr.registrationv3.service.BaseService;

import com.tdr.registrationv3.service.presenter.LoginPresenter;

import java.util.List;

import okhttp3.RequestBody;


public class LoginImpl extends BasePresenter<LoginPresenter.View> implements LoginPresenter.Presenter {
    private BaseService mService;

    public LoginImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }


    @Override
    public void login(RequestBody route) {
        invoke(mService.login(UrlConstants.user_login, route), new Callback<DdcResult<LoginBean>>() {
            @Override
            public void onResponse(DdcResult<LoginBean> data) {
                mView.loadingSuccessForData(data.getData());

            }
        });
    }

    @Override
    public void getCityConfigureBySubsystemId(RequestBody route) {
        invoke(mService.getCityConfigure(UrlConstants.cityConfigure_getCityConfigureBySubsystemId, route), new Callback<DdcResult<List<CityConfigureBean>>>() {
            @Override
            public void onResponse(DdcResult<List<CityConfigureBean>> data) {
                mView.getCityConfigureSuccess(data.getData());
            }
        });
    }
}
