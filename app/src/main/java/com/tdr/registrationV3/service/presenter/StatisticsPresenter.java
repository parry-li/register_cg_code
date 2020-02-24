package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.bean.StatisticsBean;
import com.tdr.registrationV3.service.BaseView;

import okhttp3.RequestBody;


public interface StatisticsPresenter {

    interface View extends BaseView<StatisticsBean> {
    }

    interface Presenter {
        void getStatistics(RequestBody route);


    }
}
