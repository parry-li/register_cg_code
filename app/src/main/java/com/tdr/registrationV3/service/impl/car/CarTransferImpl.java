package com.tdr.registrationV3.service.impl.car;


import com.tdr.registrationV3.constants.UrlConstants;
import com.tdr.registrationV3.http.utils.Callback;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.BasePresenter;
import com.tdr.registrationV3.service.BaseService;
import com.tdr.registrationV3.service.presenter.CarTransferPresenter;

import okhttp3.RequestBody;


public class CarTransferImpl extends BasePresenter<CarTransferPresenter.View> implements CarTransferPresenter.Presenter {
    private BaseService mService;

    public CarTransferImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }


    @Override
    public void carCTransfer(RequestBody route) {
        invoke(mService.carChang(UrlConstants.electriccarsTransfer_add, route), new Callback<DdcResult>() {
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
