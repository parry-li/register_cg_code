package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.CityBean;
import com.tdr.registration.bean.CuBean;
import com.tdr.registration.service.BaseView;

import java.util.List;


public interface CityPresenter {

    interface View extends BaseView<List<CityBean>> {

    }

    interface Presenter {
        void getCity();

    }
}
