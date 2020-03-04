package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.CodeTableBean;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.BaseView;

import java.util.List;

import okhttp3.RequestBody;


public interface CodeTablePresenter {

    interface View extends BaseView<DdcResult<List<CodeTableBean>>> {


    }

    interface Presenter {
        void getCodeTable(RequestBody route);




    }
}
