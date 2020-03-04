package com.tdr.registrationv3.ui.activity.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.tdr.registrationv3.R;
import com.tdr.registrationv3.adapter.FragmentPageAdapter;
import com.tdr.registrationv3.bean.RegisterPutBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.rx.RxBus;
import com.tdr.registrationv3.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registrationv3.ui.fragment.register.RegisterCarFragment;
import com.tdr.registrationv3.ui.fragment.register.RegisterInsuranceFragment;
import com.tdr.registrationv3.ui.fragment.register.RegisterPeopleFragment;
import com.tdr.registrationv3.utils.PhotoUtils;
import com.tdr.registrationv3.view.NoScrollViewPager;

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

    public Intent resultData;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            resultData= data;
            switch (requestCode) {
                case PhotoUtils.CAMERA_REQESTCODE:
                    RxBus.getDefault().post(BaseConstants.BUX_SEND_CODE, PhotoUtils.CAMERA_REQESTCODE);
                    break;
                case PhotoUtils.ALBUM_REQESTCODE:
                    RxBus.getDefault().post(BaseConstants.BUX_SEND_CODE,PhotoUtils.ALBUM_REQESTCODE);
                    break;
            }
        }
    }
}
