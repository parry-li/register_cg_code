package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.bean.CodeTableBean;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.BaseView;

import java.util.List;

import okhttp3.RequestBody;


public interface CodeTablePresenter {

    interface View extends BaseView<DdcResult<List<CodeTableBean>>> {


    }

    interface Presenter {
        void getCodeTable(RequestBody route);




    }
}
