package com.tdr.registrationV3.service.impl.city;


import com.tdr.registrationV3.bean.CityBean;
import com.tdr.registrationV3.constants.UrlConstants;
import com.tdr.registrationV3.http.utils.Callback;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.BaseView;
import com.tdr.registrationV3.service.BasePresenter;
import com.tdr.registrationV3.service.BaseService;
import com.tdr.registrationV3.service.presenter.CityPresenter;

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
