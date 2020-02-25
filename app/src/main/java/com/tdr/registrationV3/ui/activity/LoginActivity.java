package com.tdr.registrationV3.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parry.utils.code.SPUtils;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.CityConfigureBean;
import com.tdr.registrationV3.bean.LoginBean;
import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.service.impl.LoginImpl;
import com.tdr.registrationV3.service.presenter.LoginPresenter;
import com.tdr.registrationV3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationV3.ui.activity.home.HomeActivity;
import com.tdr.registrationV3.utils.ActivityUtil;
import com.tdr.registrationV3.utils.LogUtil;
import com.tdr.registrationV3.utils.ToastUtil;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;


public class LoginActivity extends LoadingBaseActivity<LoginImpl> implements LoginPresenter.View, EasyPermissions.PermissionCallbacks {


    @BindView(R.id.login_city)
    LinearLayout loginCity;
    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_name_line)
    View loginNameLine;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_pwd_line)
    View loginPwdLine;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.city_name)
    TextView cityName;

    private static final int CITY_PICK = 1000;
    private int systemId;
    private LoginBean loginData;
    //    private RxPermissions rxPermissions;
    private static final int PERMISSION_CODE= 124;
    private static final String[] PERMISSION_CONTENT =
            {Manifest.permission.CAMERA, Manifest.permission.VIBRATE};
    private String cityCode;

    @Override
    protected void initTitle() {
        String cityNameStr = SPUtils.getInstance().getString(BaseConstants.Login_city_name, "");
        systemId = SPUtils.getInstance().getInt(BaseConstants.Login_city_systemID, -100);
        if (systemId != -100) {
            cityName.setText(cityNameStr);
        }
        getPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected LoginImpl setPresenter() {
        return new LoginImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        loginName.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    loginNameLine.setBackgroundResource(R.color.module_main);
                } else {
                    loginNameLine.setBackgroundResource(R.color.module_background);
                }
            }
        });
        loginPwd.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    loginPwdLine.setBackgroundResource(R.color.module_main);
                } else {
                    loginPwdLine.setBackgroundResource(R.color.module_background);
                }
            }
        });

        loginName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginPwdLine.setBackgroundResource(R.color.module_background);
                String lPwd = loginPwd.getText().toString().trim();
                String lName = loginName.getText().toString().trim();
                if (TextUtils.isEmpty(lName) && TextUtils.isEmpty(lPwd)) {
                    loginButton.setBackgroundResource(R.mipmap.button_unselect);
                    loginButton.setTextColor(getResources().getColor(R.color.module_button_unselect));
                } else {
                    loginButton.setBackgroundResource(R.mipmap.button_select);
                    loginButton.setTextColor(getResources().getColor(R.color.module_white));
                }


            }
        });
        loginPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginNameLine.setBackgroundResource(R.color.module_background);
                String lPwd = loginPwd.getText().toString().trim();
                String lName = loginName.getText().toString().trim();
                if (TextUtils.isEmpty(lName) && TextUtils.isEmpty(lPwd)) {
                    loginButton.setBackgroundResource(R.mipmap.button_unselect);
                    loginButton.setTextColor(getResources().getColor(R.color.module_button_unselect));
                } else {
                    loginButton.setBackgroundResource(R.mipmap.button_select);
                    loginButton.setTextColor(getResources().getColor(R.color.module_white));
                }
            }
        });


    }

    private void sendData() {
        loginNameLine.setBackgroundResource(R.color.module_background);
        loginPwdLine.setBackgroundResource(R.color.module_background);

        String cityNameStr = cityName.getText().toString().trim();
        if (cityNameStr.equals("请选择城市") || systemId == -100) {
            ToastUtil.showWX("请选择城市");
            return;
        }
        String lName = loginName.getText().toString().trim();
        if (TextUtils.isEmpty(lName)) {
            ToastUtil.showWX("请输入用户名");
            return;
        }
        String lPwd = loginPwd.getText().toString().trim();
        if (TextUtils.isEmpty(lPwd)) {
            ToastUtil.showWX("请输入密码");
            return;
        }

        zProgressHUD.setMessage("账号登录中");
        zProgressHUD.show();

        Map<String, Object> stringMap = new HashMap<>();
        stringMap.put("login", lName);
        stringMap.put("password", lPwd);
        stringMap.put("isSubsystem", "1");
        stringMap.put("subsystemId", systemId);
        mPresenter.login(getRequestBody(stringMap));

    }


    @Override
    protected int getLayoutId() {
        String token = SPUtils.getInstance().getString(BaseConstants.token);

        if (!TextUtils.isEmpty(token)) {
            ActivityUtil.goActivityAndFinish(LoginActivity.this, HomeActivity.class);
        }
        return R.layout.activity_login;
    }

    @Override
    protected void submitRequestData() {

    }


    @Override
    public void loadingSuccessForData(LoginBean mData) {
        zProgressHUD.setMessage("获取配置中");
        loginData = mData;
        SPUtils.getInstance().put(BaseConstants.token, loginData.getToken());
        Map<String, Object> map = new HashMap<>();
        map.put("subsystemId", systemId + "");
        mPresenter.getCityConfigureBySubsystemId(getRequestBody(map));

    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);
    }


    @OnClick({R.id.login_city, R.id.login_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_city:
                ActivityUtil.goActivityForResult(LoginActivity.this, CityPickerActivity.class, CITY_PICK);
                break;
            case R.id.login_button:

                sendData();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CITY_PICK) {
                String name = data.getStringExtra(BaseConstants.KEY_NAME);
                 cityCode = data.getStringExtra(BaseConstants.Login_city_cityCode);
                systemId = data.getIntExtra(BaseConstants.KEY_VALUE, -100);
                cityName.setText(name);

            }

        }
    }

    @Override
    public void getCityConfigureSuccess(List<CityConfigureBean> cityConfigureBeanList) {
        zProgressHUD.dismiss();
        SPUtils.getInstance().put(BaseConstants.token, loginData.getToken());
        SPUtils.getInstance().put(BaseConstants.Login_city_name, cityName.getText().toString());
        SPUtils.getInstance().put(BaseConstants.Login_city_systemID, systemId);
        SPUtils.getInstance().put(BaseConstants.Login_city_unitName, loginData.getUnitName());
        SPUtils.getInstance().put(BaseConstants.Login_city_cityCode, cityCode);
        SPUtils.getInstance().put(BaseConstants.Login_city_unitNo, loginData.getUnitNo());
        SPUtils.getInstance().put(BaseConstants.Login_city_unitType, loginData.getUnitType());
        /*保存配置*/
        for (CityConfigureBean configureBean : cityConfigureBeanList) {
            SPUtils.getInstance().put(BaseConstants.APP_NAME+configureBean.getConfigureName(), configureBean.getContent());
        }
        ActivityUtil.goActivityAndFinish(LoginActivity.this, HomeActivity.class);


    }

    @Override
    public void getCityConfigureFail(String msg) {
        zProgressHUD.dismiss();
        SPUtils.getInstance().put(BaseConstants.token, "");
        showCustomWindowDialog("服务提示", msg, true);

    }

    @AfterPermissionGranted(PERMISSION_CODE)
    public void getPermission() {
        if (EasyPermissions.hasPermissions(this, PERMISSION_CONTENT)) {
            LogUtil.i("hasPermissions");
        } else {
            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_location_contacts),
                    PERMISSION_CODE,
                    PERMISSION_CONTENT);
        }
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        LogUtil.i("onPermissionsGranted");
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        LogUtil.i("onPermissionsDenied");
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
             new AppSettingsDialog.Builder(this)
                    .setTitle("温馨提示")
                    .setNegativeButton("取消")
                    .setRationale(R.string.permisson_dialog_content)
                    .setPositiveButton("确定")
                    .build().show();

        }
    }
}
