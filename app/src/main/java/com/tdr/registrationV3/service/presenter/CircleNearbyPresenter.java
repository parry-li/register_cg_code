package com.tdr.registrationV3.service.presenter;

import com.tdr.registrationV3.bean.CuBean;
import com.tdr.registrationV3.service.BaseView;


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
