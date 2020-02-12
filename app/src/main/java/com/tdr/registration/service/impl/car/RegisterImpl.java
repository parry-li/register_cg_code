package com.tdr.registration.service.impl.car;


import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.http.utils.NoCallback;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.CarChangePresenter;
import com.tdr.registration.service.presenter.RegisterPresenter;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class RegisterImpl extends BasePresenter<RegisterPresenter.View> implements RegisterPresenter.Presenter {
    private BaseService mService;

    public RegisterImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }

    @Override
    public void checkPlateNumber(RequestBody route) {
        invoke(mService.baseRequest(UrlConstants.electriccars_checkOnlyOnePlateNumber, route), new NoCallback<DdcResult>() {
            @Override
            public void onResponse(DdcResult data) {

                if (data.getCode() == 0) {

                    mView.checkPlateNumberSuccess();
                } else {
                    mView.checkPlateNumberFail(data.getMsg());
                }

            }
        });
    }

    @Override
    public void getInsurance(RequestBody route) {
        invoke(mService.getInsurance(UrlConstants.configure_getInsuranceConfigs, route), new Callback<DdcResult<List<InsuranceBean>>>() {
            @Override
            public void onResponse(DdcResult<List<InsuranceBean>> data) {

                if (data.getCode() == 0) {
                    mView.getInsuranceSuccess(data.getData());
                } else {
                    mView.getInsuranceFail(data.getMsg());
                }

            }
        });
    }

    @Override
    public void register(RequestBody route) {
        invoke(mService.baseRequest(UrlConstants.electriccars_registration, route), new NoCallback<DdcResult>() {
            @Override
            public void onResponse(DdcResult data) {

                if (data.getCode() == 0) {
                    mView.loadingSuccessForData(data);
                } else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }

    @Override
    public void change(RequestBody route) {
        invoke(mService.baseRequest(UrlConstants.electriccars_edit, route), new NoCallback<DdcResult>() {
            @Override
            public void onResponse(DdcResult data) {

                if (data.getCode() == 0) {
                    mView.changeSuccess(data.getMsg());
                } else {
                    mView.changeFail(data.getMsg());
                }

            }
        });
    }
}
