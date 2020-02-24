package com.tdr.registrationV3.ui.activity.car;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.tdr.registrationV3.R;
import com.tdr.registrationV3.adapter.FragmentPageAdapter;
import com.tdr.registrationV3.bean.RegisterPutBean;
import com.tdr.registrationV3.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registrationV3.ui.fragment.register.RegisterCarFragment;
import com.tdr.registrationV3.ui.fragment.register.RegisterInsuranceFragment;
import com.tdr.registrationV3.ui.fragment.register.RegisterPeopleFragment;
import com.tdr.registrationV3.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RegisterMainActivity extends NoLoadingBaseActivity {
    @BindView(R.id.register_vp)
    NoScrollViewPager registerVp;
    public int vehicleType = 1;
    public RegisterPutBean registerPutBean;


    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        registerPutBean = new RegisterPutBean();
        vehicleType = getIntent().getExtras().getInt("car_type");
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new RegisterCarFragment());
        mFragmentList.add(new RegisterPeopleFragment());
        mFragmentList.add(new RegisterInsuranceFragment());
        registerVp.setNoScroll(true);
        registerVp.setAdapter(new FragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
        registerVp.setOffscreenPageLimit(2);
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
