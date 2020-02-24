package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.bean.CarCheckBean;
import com.tdr.registrationV3.bean.EditInfoBean;
import com.tdr.registrationV3.service.BaseView;

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
