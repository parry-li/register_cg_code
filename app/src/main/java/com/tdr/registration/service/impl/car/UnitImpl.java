package com.tdr.registration.service.impl.car;


import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.EditInfoBean;
import com.tdr.registration.bean.UnitBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.http.utils.NoCallback;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.CarQueryPresenter;
import com.tdr.registration.service.presenter.UnitPresenter;

import java.util.List;

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
