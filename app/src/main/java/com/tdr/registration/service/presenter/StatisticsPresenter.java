package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.StatisticsBean;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BaseView;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public interface StatisticsPresenter {

    interface View extends BaseView<StatisticsBean> {
    }

    interface Presenter {
        void getStatistics(RequestBody route);


    }
}
