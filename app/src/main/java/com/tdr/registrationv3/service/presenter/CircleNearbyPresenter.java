package com.tdr.registrationv3.service.presenter;

import com.tdr.registrationv3.bean.CuBean;
import com.tdr.registrationv3.service.BaseView;


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
