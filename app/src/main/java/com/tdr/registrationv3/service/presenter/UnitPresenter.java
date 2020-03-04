package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.UnitBean;
import com.tdr.registrationv3.service.BaseView;

import okhttp3.RequestBody;


public interface UnitPresenter {

    interface View extends BaseView<UnitBean> {


    }

    interface Presenter {
        void getUnit(RequestBody route);


    }
}
