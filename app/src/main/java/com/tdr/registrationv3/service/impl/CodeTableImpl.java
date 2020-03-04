package com.tdr.registrationv3.service.impl;


import com.tdr.registrationv3.bean.CodeTableBean;
import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.http.utils.Callback;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.BasePresenter;
import com.tdr.registrationv3.service.BaseService;
import com.tdr.registrationv3.service.presenter.CodeTablePresenter;

import java.util.List;

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
