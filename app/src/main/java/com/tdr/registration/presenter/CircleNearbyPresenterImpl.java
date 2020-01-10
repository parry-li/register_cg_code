package com.tdr.registration.presenter;



import com.tdr.registration.bean.CuBean;
import com.tdr.registration.http.utils.Callback;
import com.tdr.registration.http.utils.DdcResult;


public class CircleNearbyPresenterImpl extends BasePresenter<CircleNearbyPresenter.View> implements CircleNearbyPresenter.Presenter {
    private NewsService mService;

    public CircleNearbyPresenterImpl() {
        this.mService = (NewsService) setRetrofitService(NewsService.class);
    }


    @Override
    public void getCircleNear(String userid) {
        invoke(mService.getCuData(userid), new Callback<DdcResult<CuBean>>() {
            @Override
            public void onResponse(DdcResult<CuBean> data) {

                if(data.getCode()==0){
                    if(data.getData()!=null){
                        mView.getLoadSuccess(data.getData().getData());
                    }
                }else {
//                    mView.getLoadFail(data.getError()+"");
                }


            }
        });
    }

    @Override
    public void login(String userid) {

    }
}
