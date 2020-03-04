package com.tdr.registrationv3.service.impl;


import com.tdr.registrationv3.service.BaseView;
import com.tdr.registrationv3.service.presenter.CircleNearbyPresenter;
import com.tdr.registrationv3.service.BaseService;
import com.tdr.registrationv3.service.BasePresenter;


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
