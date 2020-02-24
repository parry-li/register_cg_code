package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.bean.CityBean;
import com.tdr.registrationV3.service.BaseView;

import java.util.List;


public interface CityPresenter {

    interface View extends BaseView<List<CityBean>> {

    }

    interface Presenter {
        void getCity();

    }
}
