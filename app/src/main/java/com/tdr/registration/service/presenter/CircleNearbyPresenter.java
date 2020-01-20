package com.tdr.registration.service.presenter;

import com.tdr.registration.bean.CuBean;
import com.tdr.registration.service.BaseView;


import java.util.List;



public interface CircleNearbyPresenter {

    interface View extends BaseView<CuBean.DataBean> {

        void getLoadSuccess(List<CuBean.DataBean> dataBeans);
        void getLoadFail(String code);

        void loginSuccess(String token);


    }

    interface Presenter {
        void getCircleNear(String userid);
        void login(String userid);
    }
}
