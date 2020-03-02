package com.tdr.registrationV3.service.impl.insurance;


import com.tdr.registrationV3.bean.InsuranceWaitBean;
import com.tdr.registrationV3.constants.UrlConstants;
import com.tdr.registrationV3.http.utils.Callback;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.http.utils.NoCallback;
import com.tdr.registrationV3.service.BasePresenter;
import com.tdr.registrationV3.service.BaseService;
import com.tdr.registrationV3.service.presenter.InsuranceWaitPresenter;

import java.util.List;

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
        invoke(mService.baseRequest(UrlConstants.policy_reinsure, route), new NoCallback<DdcResult>() {
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
