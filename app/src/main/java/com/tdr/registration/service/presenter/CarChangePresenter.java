package com.tdr.registration.service.presenter;

import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BaseView;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public interface CarChangePresenter {

    interface View extends BaseView<DdcResult> {
        void sendImgSuccess(String photoId);
        void sendImgFail(String msg);
    }

    interface Presenter {
        void sendImg(MultipartBody.Part file);
        void carChange(RequestBody route);

    }
}
