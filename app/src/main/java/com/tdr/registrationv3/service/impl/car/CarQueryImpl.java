package com.tdr.registrationv3.service.impl.car;


import com.tdr.registrationv3.bean.CarCheckBean;
import com.tdr.registrationv3.bean.EditInfoBean;
import com.tdr.registrationv3.bean.InfoBean;
import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.http.utils.NoCallback;
import com.tdr.registrationv3.service.BasePresenter;
import com.tdr.registrationv3.service.BaseService;
import com.tdr.registrationv3.service.presenter.CarQueryPresenter;

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

    @Override
    public void queryCarInfo(RequestBody route) {
        invoke(mService.queryCarInfo(UrlConstants.electriccars_info, route), new NoCallback<DdcResult<InfoBean>>() {
            @Override
            public void onResponse(DdcResult<InfoBean> data) {
                if (data.getCode() == 0) {
                    mView.queryCarInfoSuccess(data.getData());
                } else {
                    mView.queryCarInfoFail(data.getMsg());
                }

            }
        });
    }
}
