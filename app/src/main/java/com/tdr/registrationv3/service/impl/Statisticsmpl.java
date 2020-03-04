package com.tdr.registrationv3.service.impl;


import com.tdr.registrationv3.bean.StatisticsBean;
import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.http.utils.Callback;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.BasePresenter;
import com.tdr.registrationv3.service.BaseService;
import com.tdr.registrationv3.service.presenter.StatisticsPresenter;

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

    @Override
    public void query2Unit(RequestBody route) {
        invoke(mService.getStatistics(UrlConstants.installSituation_query2Unit, route), new Callback<DdcResult<StatisticsBean>>() {
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
