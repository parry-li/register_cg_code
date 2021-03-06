package com.tdr.registrationv3.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parry.utils.code.AppUtils;
import com.parry.utils.code.SPUtils;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.ui.activity.LoginActivity;
import com.tdr.registrationv3.ui.activity.base.BaseActivity;
import com.tdr.registrationv3.ui.activity.insurance.InsuranceWaitActivity;
import com.tdr.registrationv3.ui.activity.me.PasswordActivity;
import com.tdr.registrationv3.ui.fragment.base.NoCacheBaseFragment;
import com.tdr.registrationv3.utils.ActivityUtil;

import butterknife.BindView;
import butterknife.OnClick;


public class MeFragment extends NoCacheBaseFragment {
    @BindView(R.id.me_pwd)
    LinearLayout mePwd;
    @BindView(R.id.me_update)
    LinearLayout meUpdate;
    @BindView(R.id.me_version)
    LinearLayout meVersion;
    @BindView(R.id.me_problem)
    LinearLayout meProblem;
    @BindView(R.id.me_insurance)
    LinearLayout meInsurance;
    @BindView(R.id.me_out)
    LinearLayout meOut;
    @BindView(R.id.me_version_num)
    TextView meVersionNum;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_city)
    TextView userCity;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        meVersionNum.setText(AppUtils.getAppVersionName());
        String loginName = SPUtils.getInstance().getString(BaseConstants.Login_name);
        String unitName = SPUtils.getInstance().getString(BaseConstants.Login_unitName);
        userName.setText(loginName);
        userCity.setText(unitName);
    }

    @Override
    protected void submitRequestData() {

    }


    @OnClick({R.id.me_pwd, R.id.me_update, R.id.me_version, R.id.me_problem, R.id.me_insurance, R.id.me_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.me_pwd:
                ActivityUtil.goActivity(MeFragment.this.getActivity(), PasswordActivity.class);
                break;
            case R.id.me_update:
                break;
            case R.id.me_version:
                break;
            case R.id.me_problem:
                break;
            case R.id.me_insurance:
                ActivityUtil.goActivity(MeFragment.this.getActivity(), InsuranceWaitActivity.class);
                break;
            case R.id.me_out:
                BaseActivity.activity.clearDataForLoginOut();
                ActivityUtil.goActivityAndFinish(MeFragment.this.getActivity(), LoginActivity.class);
                break;
        }
    }



}
