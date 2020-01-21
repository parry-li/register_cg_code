package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.CityBean;
import com.tdr.registration.bean.CityConfigureBean;
import com.tdr.registration.bean.LoginBean;
import com.tdr.registration.service.BaseView;

import java.util.List;

import okhttp3.RequestBody;


public interface LoginPresenter {

    interface View extends BaseView<LoginBean> {

        void getCityConfigureSuccess(List<CityConfigureBean> cityConfigureBean);

        void getCityConfigureFail(String msg);
    }

    interface Presenter {
        void login(RequestBody route);

        void getCityConfigureBySubsystemId(RequestBody route);

    }
}
