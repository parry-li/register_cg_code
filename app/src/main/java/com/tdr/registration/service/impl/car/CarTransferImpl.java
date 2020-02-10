package com.tdr.registration.service.impl.car;


import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.CarTransferPresenter;

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
