package com.tdr.registration.ui.activity.car;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.tdr.registration.R;
import com.tdr.registration.adapter.FragmentPageAdapter;
import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.RegisterPutBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registration.ui.fragment.register.ChangeRegisterCarFragment;
import com.tdr.registration.ui.fragment.register.ChangeRegisterPeopleFragment;
import com.tdr.registration.ui.fragment.register.RegisterCarFragment;
import com.tdr.registration.ui.fragment.register.RegisterPeopleFragment;
import com.tdr.registration.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChangeRegisterActivity extends NoLoadingBaseActivity {
    @BindView(R.id.register_vp)
    NoScrollViewPager registerVp;
    public int vehicleType = 1;
    public RegisterPutBean registerPutBean;
    public CarCheckBean checkBean;

    @Override
    protected void initTitle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            checkBean = (CarCheckBean) bundle.getSerializable(BaseConstants.data);
            registerPutBean.setVehicleType(checkBean.getVehicleType());
        }
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        registerPutBean = new RegisterPutBean();
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
