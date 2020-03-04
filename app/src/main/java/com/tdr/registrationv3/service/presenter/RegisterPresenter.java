package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.BlcakCarBean;
import com.tdr.registrationv3.bean.InsuranceBean;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.BaseView;

import java.util.List;

import okhttp3.RequestBody;


public interface RegisterPresenter {

    interface View extends BaseView<DdcResult> {

        void checkPlateNumberSuccess();

        void checkPlateNumberFail(String msg);

        void getInsuranceSuccess(List<InsuranceBean> list);

        void getInsuranceFail(String msg);

        void changeFail(String msg);

        void changeSuccess(String msg);
        void checkShelvesNumberFail(String msg);

        void checkShelvesNumberSuccess(List<BlcakCarBean> msg);
    }

    interface Presenter {
        void checkPlateNumber(RequestBody route);

        void getInsurance(RequestBody route);

        void register(RequestBody route);
        void change(RequestBody route);

        void checkShelvesNumber (RequestBody route);


    }
}
