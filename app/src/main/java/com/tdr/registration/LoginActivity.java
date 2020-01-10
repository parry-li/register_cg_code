package com.tdr.registration;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.parry.utils.code.LogUtils;
import com.parry.utils.code.ToastUtils;
import com.tdr.registration.bean.CuBean;
import com.tdr.registration.presenter.CircleNearbyPresenter;
import com.tdr.registration.presenter.CircleNearbyPresenterImpl;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;
import com.tdr.registration.view.CustomProgressDialog;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class LoginActivity extends LoadingBaseActivity<CircleNearbyPresenterImpl> implements CircleNearbyPresenter.View {
    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_bt)
    Button loginBt;
    @BindView(R.id.login_pwd)
    EditText loginPwd;

    @Override
    protected void initTitle() {

//        if (!TextUtils.isEmpty(SPUtils.getInstance().getString("token", ""))) {
//
//            finish();
//        }

        mPresenter.getCircleNear("");

    }


    @Override
    protected void loadData() {

    }

    @Override
    protected CircleNearbyPresenterImpl setPresenter() {
        return new CircleNearbyPresenterImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        loginName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String lName = loginName.getText().toString().trim();
                if (TextUtils.isEmpty(lName)) {
                    loginBt.setBackgroundResource(R.mipmap.login_bt_un);
                } else {
                    loginBt.setBackgroundResource(R.mipmap.login_bt);
                }
            }
        });

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getCircleNear("");
                sendData();
            }
        });
    }

    private void sendData() {
        String lName = loginName.getText().toString().trim();
        if (TextUtils.isEmpty(lName)) {
            ToastUtils.showShort("温馨提示：请输入用户名");
            return;
        }
        String lPwd = loginPwd.getText().toString().trim();
        if (TextUtils.isEmpty(lPwd)) {
            ToastUtils.showShort("温馨提示：请输入密码");
            return;
        }
        CustomProgressDialog.showDialog(LoginActivity.this);

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("UserName", lName);
        stringMap.put("Password", lPwd);
        JSONObject JB = new JSONObject(stringMap);


    }

    private void initOkt(String s) {


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void getLoadSuccess(List<CuBean.DataBean> dataBeans) {

    }

    @Override
    public void getLoadFail(String code) {

    }

    @Override
    public void loginSuccess(String token) {

    }

    @Override
    public void loadingSuccessForData(CuBean.DataBean mData) {

    }

    @Override
    public void loadingFail(String msg) {

    }

}
