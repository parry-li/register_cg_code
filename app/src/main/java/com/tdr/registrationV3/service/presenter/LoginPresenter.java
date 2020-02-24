package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.bean.CityConfigureBean;
import com.tdr.registrationV3.bean.LoginBean;
import com.tdr.registrationV3.service.BaseView;

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
