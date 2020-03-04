package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.StatisticsBean;
import com.tdr.registrationv3.service.BaseView;

import okhttp3.RequestBody;


public interface StatisticsPresenter {

    interface View extends BaseView<StatisticsBean> {
    }

    interface Presenter {
        void getStatistics(RequestBody route);
        void query2Unit(RequestBody route);


    }
}
