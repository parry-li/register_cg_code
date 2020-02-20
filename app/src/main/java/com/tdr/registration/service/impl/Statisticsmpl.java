package com.tdr.registration.service.impl;


import com.tdr.registration.bean.StatisticsBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.CarChangePresenter;
import com.tdr.registration.service.presenter.StatisticsPresenter;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class Statisticsmpl extends BasePresenter<StatisticsPresenter.View> implements StatisticsPresenter.Presenter {
    private BaseService mService;

    public Statisticsmpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }


    @Override
    public void getStatistics(RequestBody route) {
        invoke(mService.getStatistics(UrlConstants.installSituation_query2User, route), new Callback<DdcResult<StatisticsBean>>() {
            @Override
            public void onResponse(DdcResult<StatisticsBean> data) {

                if (data.getCode() == 0) {

                    mView.loadingSuccessForData(data.getData());
                } else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }


}
