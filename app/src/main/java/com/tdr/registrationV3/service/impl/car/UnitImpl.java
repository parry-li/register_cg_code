package com.tdr.registrationV3.service.impl.car;


import com.tdr.registrationV3.bean.UnitBean;
import com.tdr.registrationV3.constants.UrlConstants;
import com.tdr.registrationV3.http.utils.Callback;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.BasePresenter;
import com.tdr.registrationV3.service.BaseService;
import com.tdr.registrationV3.service.presenter.UnitPresenter;

import okhttp3.RequestBody;


public class UnitImpl extends BasePresenter<UnitPresenter.View> implements UnitPresenter.Presenter {
    private BaseService mService;

    public UnitImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }

    @Override
    public void getUnit(RequestBody route) {
        invoke(mService.getUnit(UrlConstants.unit_unitTreeByUnitNo, route), new Callback<DdcResult<UnitBean>>() {
            @Override
            public void onResponse(DdcResult<UnitBean> data) {
                if (data.getCode() == 0) {
                    mView.loadingSuccessForData(data.getData());
                } else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }
}
