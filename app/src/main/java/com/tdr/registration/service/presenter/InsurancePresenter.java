package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.EditInfoBean;
import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.service.BaseView;

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
