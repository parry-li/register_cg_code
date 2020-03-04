package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.BaseView;

import okhttp3.RequestBody;


public interface CarChangePresenter {

    interface View extends BaseView<DdcResult> {

    }

    interface Presenter {

        void carChange(RequestBody route);
    }
}
