package com.tdr.registrationV3.service.impl.car;


import com.tdr.registrationV3.bean.BlcakCarBean;
import com.tdr.registrationV3.bean.InsuranceBean;
import com.tdr.registrationV3.constants.UrlConstants;
import com.tdr.registrationV3.http.utils.Callback;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.http.utils.NoCallback;
import com.tdr.registrationV3.service.BasePresenter;
import com.tdr.registrationV3.service.BaseService;
import com.tdr.registrationV3.service.presenter.RegisterPresenter;

import java.util.List;

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

    @Override
    public void checkShelvesNumber(RequestBody route) {
        invoke(mService.checkShelvesNumber(UrlConstants.electriccars_checkBlackCar, route), new NoCallback<DdcResult<List<BlcakCarBean>>>() {
            @Override
            public void onResponse(DdcResult<List<BlcakCarBean>> data) {

                if (data.getCode() == 0) {
                    if(data.getData()!=null&&data.getData().size()>0){
                        mView.checkShelvesNumberSuccess(data.getData());
                    }else {
                        mView.checkShelvesNumberFail(data.getMsg());
                    }

                } else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }
}
