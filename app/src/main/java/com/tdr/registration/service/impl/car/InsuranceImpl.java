package com.tdr.registration.service.impl.car;


import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.http.utils.NoCallback;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.InsurancePresenter;
import com.tdr.registration.service.presenter.RegisterPresenter;

import java.util.List;

import okhttp3.RequestBody;


public class InsuranceImpl extends BasePresenter<InsurancePresenter.View> implements InsurancePresenter.Presenter {
    private BaseService mService;

    public InsuranceImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }


    @Override
    public void getNewAndRenewInsurance(String url, RequestBody route) {
        invoke(mService.getInsurance(url, route), new Callback<DdcResult<List<InsuranceBean>>>() {
            @Override
            public void onResponse(DdcResult<List<InsuranceBean>> data) {

                if (data.getCode() == 0) {
                    mView.loadingSuccessForData(data.getData());
                } else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }

    @Override
    public void submitData(String url, RequestBody route) {
        invoke(mService.baseRequest(url, route), new Callback<DdcResult>() {
            @Override
            public void onResponse(DdcResult data) {
                if (data.getCode() == 0) {
                    mView.submitDataSuccess(data.getMsg());
                } else {
                    mView.submitDataFail(data.getMsg());
                }

            }
        });
    }
}
