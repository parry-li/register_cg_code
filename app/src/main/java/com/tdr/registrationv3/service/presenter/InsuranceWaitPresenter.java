package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.InsuranceWaitBean;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.BaseView;

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
