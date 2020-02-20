package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.EditInfoBean;
import com.tdr.registration.bean.UnitBean;
import com.tdr.registration.service.BaseView;

import java.util.List;

import okhttp3.RequestBody;


public interface UnitPresenter {

    interface View extends BaseView<UnitBean> {


    }

    interface Presenter {
        void getUnit(RequestBody route);


    }
}
