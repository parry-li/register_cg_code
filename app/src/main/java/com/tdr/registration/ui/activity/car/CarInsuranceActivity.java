package com.tdr.registration.ui.activity.car;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tdr.registration.R;
import com.tdr.registration.adapter.InsuranceAdapter;
import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.impl.car.RegisterImpl;
import com.tdr.registration.service.presenter.RegisterPresenter;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarInsuranceActivity extends LoadingBaseActivity<RegisterImpl> implements RegisterPresenter.View {
    @BindView(R.id.IV)
    RecyclerView IV;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;
    private InsuranceAdapter insuranceAdapter;

    @Override
    protected void initTitle() {

    }

    @Override
    protected void loadData() {
        Map<String, Object> map = new HashMap<>();
        map.put("subsystemId", 13);
        map.put("vehicleType", 1);
        map.put("insuranceMode", 0);
        map.put("buyDate", "2020-02-07");
        mPresenter.getInsurance(getRequestBody(map));
    }

    @Override
    protected RegisterImpl setPresenter() {
        return new RegisterImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<InsuranceBean>>() {}.getType();
//        List<InsuranceBean> list = gson.fromJson(JSONS, type);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_instrance;
    }


    @Override
    public void checkPlateNumberSuccess() {

    }

    @Override
    public void checkPlateNumberFail(String msg) {

    }

    @Override
    public void getInsuranceSuccess(List<InsuranceBean> list) {
        IV.setLayoutManager(new LinearLayoutManager(this));
         insuranceAdapter = new InsuranceAdapter(this, list);
        IV.setAdapter(insuranceAdapter);
    }

    @Override
    public void getInsuranceFail(String msg) {

    }

    @Override
    public void changeFail(String msg) {

    }

    @Override
    public void changeSuccess(String msg) {

    }

    @Override
    public void loadingSuccessForData(DdcResult mData) {

    }

    @Override
    public void loadingFail(String msg) {

    }



    @OnClick(R.id.btn_submit)
    public void onViewClicked() {
        List<InsuranceBean> DATlIST = insuranceAdapter.getData();
        int s = DATlIST.size();
    }
}
