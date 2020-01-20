package com.tdr.registration.service.impl.city;


import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.bean.CityBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BaseView;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.CityPresenter;

import java.util.List;


public class CityImpl extends BasePresenter<BaseView> implements CityPresenter.Presenter {
    private BaseService mService;

    public CityImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }

    @Override
    public void getCity() {
        invoke(mService.getCity(UrlConstants.cityConfigure_getCityList), new Callback<DdcResult<List<CityBean>>>() {
            @Override
            public void onResponse(DdcResult<List<CityBean>> data) {

                mView.loadingSuccessForData(data.getData());

            }
        });
    }
}
