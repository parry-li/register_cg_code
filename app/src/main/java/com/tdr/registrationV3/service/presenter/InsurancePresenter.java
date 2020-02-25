package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.bean.InsuranceBean;
import com.tdr.registrationV3.service.BaseView;

import java.util.List;

import okhttp3.RequestBody;


public interface InsurancePresenter {

    interface View extends BaseView<List<InsuranceBean>> {

        void submitDataSuccess(String msg);
        void submitDataFail(String msg);


    }

    interface Presenter {
        void getNewAndRenewInsurance(String url, RequestBody route);

        void submitData(String url, RequestBody route);

    }
}