package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BaseView;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public interface RegisterPresenter {

    interface View extends BaseView<DdcResult> {

        void checkPlateNumberSuccess();

        void checkPlateNumberFail(String msg);

        void getInsuranceSuccess(List<InsuranceBean> list);

        void getInsuranceFail(String msg);

        void changeFail(String msg);

        void changeSuccess(String msg);
    }

    interface Presenter {
        void checkPlateNumber(RequestBody route);

        void getInsurance(RequestBody route);

        void register(RequestBody route);
        void change(RequestBody route);


    }
}
