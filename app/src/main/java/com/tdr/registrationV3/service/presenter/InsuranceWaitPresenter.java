package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.bean.InsuranceWaitBean;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.BaseView;

import java.util.List;

import okhttp3.RequestBody;


public interface InsuranceWaitPresenter {

    interface View extends BaseView<DdcResult<List<InsuranceWaitBean>>> {
        void pushAgainSuccess(String msg);

        void pushAgainFail(String msg);
    }

    interface Presenter {
        void getInsurance(RequestBody route);

        void pushAgain(RequestBody route);

    }
}
