package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.CityConfigureBean;
import com.tdr.registrationv3.bean.LoginBean;
import com.tdr.registrationv3.service.BaseView;

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
