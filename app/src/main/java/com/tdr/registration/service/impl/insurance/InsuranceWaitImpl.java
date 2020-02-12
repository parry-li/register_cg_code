package com.tdr.registration.service.impl.insurance;


import com.tdr.registration.bean.InsuranceWaitBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.http.utils.NoCallback;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.CarChangePresenter;
import com.tdr.registration.service.presenter.InsuranceWaitPresenter;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class InsuranceWaitImpl extends BasePresenter<InsuranceWaitPresenter.View> implements InsuranceWaitPresenter.Presenter {
    private BaseService mService;

    public InsuranceWaitImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }


    @Override
    public void getInsurance(RequestBody route) {
        invoke(mService.gWaitInsurance(UrlConstants.policy_failurePage, route), new Callback<DdcResult<List<InsuranceWaitBean>>>() {
            @Override
            public void onResponse(DdcResult<List<InsuranceWaitBean>> data) {

                if (data.getCode() == 0) {

                    mView.loadingSuccessForData(data);
                } else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }

    @Override
    public void pushAgain(RequestBody route) {
        invoke(mService.baseRequest(UrlConstants.policy_failurePage, route), new NoCallback<DdcResult>() {
            @Override
            public void onResponse(DdcResult data) {

                if (data.getCode() == 0) {
                    mView.pushAgainSuccess(data.getMsg());
                } else {
                    mView.pushAgainFail(data.getMsg());
                }

            }
        });
    }
}
