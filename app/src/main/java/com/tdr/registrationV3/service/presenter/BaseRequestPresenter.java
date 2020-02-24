package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.BaseView;

import okhttp3.RequestBody;


public interface BaseRequestPresenter {

    interface View extends BaseView<DdcResult> {

    }

    interface Presenter {
        void put(String url,RequestBody route);

    }
}
