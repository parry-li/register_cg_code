package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.CityBean;
import com.tdr.registration.bean.EditInfoBean;
import com.tdr.registration.service.BaseView;

import java.util.List;

import okhttp3.RequestBody;


public interface CarQueryPresenter {

    interface View extends BaseView<CarCheckBean> {

        void getEditInfoSuccess(EditInfoBean infoBean);

        void getEditInfoFail(String msg);
    }

    interface Presenter {
        void checkCar(RequestBody route);

        void getEditInfo(RequestBody route);

    }
}
