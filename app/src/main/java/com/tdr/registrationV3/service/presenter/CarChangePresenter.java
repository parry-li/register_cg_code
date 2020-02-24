package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.BaseView;

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
