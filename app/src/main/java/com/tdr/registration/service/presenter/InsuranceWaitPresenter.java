package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.InsuranceWaitBean;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BaseView;

import java.util.List;

import okhttp3.MultipartBody;
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
