package com.tdr.registrationv3.ui.activity.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.adapter.FragmentPageAdapter;
import com.tdr.registrationv3.bean.InfoBean;
import com.tdr.registrationv3.bean.RegisterPutBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.rx.RxBus;
import com.tdr.registrationv3.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registrationv3.ui.fragment.register.ChangeRegisterCarFragment;
import com.tdr.registrationv3.ui.fragment.register.ChangeRegisterPeopleFragment;
import com.tdr.registrationv3.utils.PhotoUtils;
import com.tdr.registrationv3.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChangeRegisterMainActivity extends NoLoadingBaseActivity {
    @BindView(R.id.register_vp)
    NoScrollViewPager registerVp;
    public int vehicleType = 1;
    public RegisterPutBean registerPutBean;
    public InfoBean infoBean;
    private Intent resultData;

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
