package com.tdr.registration.ui.activity.home;

import android.os.Bundle;
import android.widget.Button;

import com.tdr.registration.R;
import com.tdr.registration.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registration.ui.activity.car.CarQueryActivity;
import com.tdr.registration.utils.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends NoLoadingBaseActivity {
    @BindView(R.id.chang_id)
    Button changId;

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }


    @OnClick(R.id.chang_id)
    public void onViewClicked() {
        ActivityUtil.goActivityAndFinish(HomeActivity.this, CarQueryActivity.class);
    }
}
