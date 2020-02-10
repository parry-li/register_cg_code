package com.tdr.registration.service.impl;


import com.tdr.registration.bean.CodeTableBean;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BasePresenter;
import com.tdr.registration.service.BaseService;
import com.tdr.registration.service.presenter.CarChangePresenter;
import com.tdr.registration.service.presenter.CodeTablePresenter;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class CodeTableImpl extends BasePresenter<CodeTablePresenter.View> implements CodeTablePresenter.Presenter {
    private BaseService mService;

    public CodeTableImpl() {
        this.mService = (BaseService) setRetrofitService(BaseService.class);
    }

    @Override
    public void getCodeTable(RequestBody route) {
        invoke(mService.codeTable(UrlConstants.codeTable_contentList, route), new Callback<DdcResult<List<CodeTableBean>>>() {
            @Override
            public void onResponse(DdcResult<List<CodeTableBean>> data) {

                if (data.getCode() == 0) {
                    mView.loadingSuccessForData(data);
                } else {
                    mView.loadingFail(data.getMsg());
                }

            }
        });
    }


}
