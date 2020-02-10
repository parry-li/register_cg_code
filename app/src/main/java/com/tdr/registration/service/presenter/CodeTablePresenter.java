package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.CodeTableBean;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.BaseView;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public interface CodeTablePresenter {

    interface View extends BaseView<DdcResult<List<CodeTableBean>>> {


    }

    interface Presenter {
        void getCodeTable(RequestBody route);




    }
}
