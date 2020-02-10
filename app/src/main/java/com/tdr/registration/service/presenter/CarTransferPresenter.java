package com.tdr.registration.service.presenter;

import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BaseView;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public interface CarTransferPresenter {

    interface View extends BaseView<DdcResult> {
    }

    interface Presenter {

        void carCTransfer(RequestBody route);

    }
}
