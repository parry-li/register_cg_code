package com.tdr.registration.presenter;

import com.tdr.registration.bean.CuBean;


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
