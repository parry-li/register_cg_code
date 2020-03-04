package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.CarCheckBean;
import com.tdr.registrationv3.bean.EditInfoBean;
import com.tdr.registrationv3.bean.InfoBean;
import com.tdr.registrationv3.service.BaseView;

import okhttp3.RequestBody;


public interface CarQueryPresenter {

    interface View extends BaseView<CarCheckBean> {

        void getEditInfoSuccess(EditInfoBean infoBean);

        void getEditInfoFail(String msg);
        void queryCarInfoSuccess(InfoBean infoBean);

        void queryCarInfoFail(String msg);
    }

    interface Presenter {
        void checkCar(RequestBody route);

        void getEditInfo(RequestBody route);
        void queryCarInfo(RequestBody route);

    }
}
