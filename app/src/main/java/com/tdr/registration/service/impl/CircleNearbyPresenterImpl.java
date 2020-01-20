package com.tdr.registration.service.impl;


import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.bean.CityBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BaseView;
import com.tdr.registration.service.presenter.CircleNearbyPresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.BasePresenter;

import retrofit2.http.Url;


public class CircleNearbyPresenterImpl extends BasePresenter<BaseView> implements CircleNearbyPresenter.Presenter {
    private BaseService mService;

    public CircleNearbyPresenterImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }


    @Override
    public void getCircleNear(String userid) {
//        invoke(mService.getCity(UrlConstants.cityConfigure_getCityList), new Callback<DdcResult<Object>>() {
//            @Override
//            public void onResponse(DdcResult<Object> data) {
//
//
//            }
//        });
    }

    @Override
    public void login(String userid) {

    }
}
