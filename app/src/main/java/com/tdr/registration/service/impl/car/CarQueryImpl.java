package com.tdr.registration.service.impl.car;


import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.CityBean;
import com.tdr.registration.bean.EditInfoBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.http.utils.NoCallback;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.BaseView;
import com.tdr.registration.service.presenter.CarQueryPresenter;
import com.tdr.registration.service.presenter.CityPresenter;

import java.util.List;

import okhttp3.RequestBody;


public class CarQueryImpl extends BasePresenter<CarQueryPresenter.View> implements CarQueryPresenter.Presenter {
    private BaseService mService;

    public CarQueryImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }

    @Override
    public void checkCar(RequestBody route) {
        invoke(mService.carCheck(UrlConstants.electriccarsChange_check, route), new NoCallback<DdcResult<CarCheckBean>>() {
            @Override
            public void onResponse(DdcResult<CarCheckBean> data) {

                if (data.getCode() == 0) {
                    mView.loadingSuccessForData(data.getData());
                } else {
                    mView.loadingFail(data.getMsg());
                }


            }
        });
    }

    @Override
    public void getEditInfo(RequestBody route) {
        invoke(mService.getEditInfo(UrlConstants.electriccars_editInfo, route), new NoCallback<DdcResult<EditInfoBean>>() {
            @Override
            public void onResponse(DdcResult<EditInfoBean> data) {
                if (data.getCode() == 0) {
                    mView.getEditInfoSuccess(data.getData());
                } else {
                    mView.getEditInfoFail(data.getMsg());
                }

            }
        });
    }
}
