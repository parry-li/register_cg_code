package com.tdr.registrationv3.service.impl.car;


import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.http.utils.Callback;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.BasePresenter;
import com.tdr.registrationv3.service.BaseService;
import com.tdr.registrationv3.service.presenter.CarChangePresenter;

import okhttp3.RequestBody;


public class CarChangeImpl extends BasePresenter<CarChangePresenter.View> implements CarChangePresenter.Presenter {
    private BaseService mService;

    public CarChangeImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }




    @Override
    public void carChange(RequestBody route) {
        invoke(mService.carChang(UrlConstants.electriccarsChange_register, route), new Callback<DdcResult>() {
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
}
