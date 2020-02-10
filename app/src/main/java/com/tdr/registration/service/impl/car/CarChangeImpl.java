package com.tdr.registration.service.impl.car;


import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.PhotoBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.http.utils.NoCallback;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.BaseView;
import com.tdr.registration.service.presenter.CarChangePresenter;
import com.tdr.registration.service.presenter.CarQueryPresenter;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class CarChangeImpl extends BasePresenter<CarChangePresenter.View> implements CarChangePresenter.Presenter {
    private BaseService mService;

    public CarChangeImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }



    @Override
    public void sendImg(MultipartBody.Part file) {
//        invoke(mService.sendImage(UrlConstants.zimgCommon_uploadMultFile, file), new NoCallback<DdcResult<PhotoBean>>() {
//            @Override
//            public void onResponse(DdcResult<PhotoBean> data) {
//
//                if(data.getCode() == 0){
//
//                    mView.sendImgSuccess(data.getData().getPhotoId());
//                }else {
//                    mView.sendImgFail(data.getMsg());
//                }
//
//            }
//        });
    }

    @Override
    public void carChange(RequestBody route) {
        invoke(mService.carChang(UrlConstants.electriccarsChange_register, route), new Callback<DdcResult>() {
            @Override
            public void onResponse(DdcResult data) {

                if(data.getCode() == 0){

                    mView.loadingSuccessForData(data);
                }else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }
}
