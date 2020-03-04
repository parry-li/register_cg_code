package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.CityBean;
import com.tdr.registrationv3.service.BaseView;

import java.util.List;


public interface CityPresenter {

    interface View extends BaseView<List<CityBean>> {

    }

    interface Presenter {
        void getCity();

    }
}
