package com.tdr.registrationV3.ui.activity.car;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.adapter.FragmentPageAdapter;
import com.tdr.registrationV3.bean.CarCheckBean;
import com.tdr.registrationV3.bean.InfoBean;
import com.tdr.registrationV3.bean.RegisterPutBean;
import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registrationV3.ui.fragment.register.ChangeRegisterCarFragment;
import com.tdr.registrationV3.ui.fragment.register.ChangeRegisterPeopleFragment;
import com.tdr.registrationV3.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChangeRegisterActivity extends NoLoadingBaseActivity {
    @BindView(R.id.register_vp)
    NoScrollViewPager registerVp;
    public int vehicleType = 1;
    public RegisterPutBean registerPutBean;
    public InfoBean infoBean;

    @Override
    protected void initTitle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            registerPutBean = new RegisterPutBean();
            String dataJson = bundle.getString(BaseConstants.data);
            infoBean = new Gson().fromJson(dataJson, InfoBean.class);
            registerPutBean.setVehicleType(infoBean.getElectriccars().getVehicleType());
        }
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        vehicleType = getIntent().getExtras().getInt("car_type");
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new ChangeRegisterCarFragment());
        mFragmentList.add(new ChangeRegisterPeopleFragment());
        registerVp.setNoScroll(true);
        registerVp.setAdapter(new FragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
        setVpCurrentItem(0);
    }

    public void setVpCurrentItem(int page) {
        registerVp.setCurrentItem(page);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register_main;
    }

    @Override
    protected void submitRequestData() {

    }


}
