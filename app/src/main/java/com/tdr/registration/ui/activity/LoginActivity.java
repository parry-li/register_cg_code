package com.tdr.registration.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registration.R;
import com.tdr.registration.bean.CityConfigureBean;
import com.tdr.registration.bean.CuBean;
import com.tdr.registration.bean.LoginBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.service.impl.CircleNearbyPresenterImpl;
import com.tdr.registration.service.impl.LoginImpl;
import com.tdr.registration.service.presenter.CircleNearbyPresenter;
import com.tdr.registration.service.presenter.LoginPresenter;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;
import com.tdr.registration.ui.activity.home.HomeActivity;
import com.tdr.registration.utils.ActivityUtil;
import com.tdr.registration.utils.ToastUtil;
import com.tdr.registration.view.CustomProgressDialog;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LoginActivity extends LoadingBaseActivity<LoginImpl> implements LoginPresenter.View {


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


    @Override
    protected void initTitle() {
        String cityNameStr = SPUtils.getInstance().getString(BaseConstants.Login_city_name, "");
        int citySystemId = SPUtils.getInstance().getInt(BaseConstants.Login_city_systemID, -100);
        if (citySystemId != -100) {
            cityName.setText(cityNameStr);
        }

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
                if (TextUtils.isEmpty(lName)) {
                    loginNameLine.setBackgroundResource(R.color.module_background);
                } else {
                    loginNameLine.setBackgroundResource(R.color.module_main);
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
                if (TextUtils.isEmpty(lName)) {
                    loginPwdLine.setBackgroundResource(R.color.module_background);
                } else {
                    loginPwdLine.setBackgroundResource(R.color.module_main);
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
//        String strEntity = new Gson().toJson(stringMap);
//        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), strEntity);
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
    public void loadingSuccessForData(LoginBean mData) {
        zProgressHUD.setMessage("获取配置中");
        loginData = mData;
        SPUtils.getInstance().put(BaseConstants.token, loginData.getToken());
        Map<String,Object> map = new HashMap<>();
        map.put("subsystemId",systemId+"");
        mPresenter.getCityConfigureBySubsystemId(getRequestBody(map));

    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg,true);
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
                String name = data.getStringExtra(BaseConstants.KEY_PICKED_CITY_NAME);
                systemId = data.getIntExtra(BaseConstants.KEY_PICKED_CITY_VALUE, -100);
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
        ActivityUtil.goActivityAndFinish(LoginActivity.this, HomeActivity.class);
    }

    @Override
    public void getCityConfigureFail(String msg) {
        zProgressHUD.dismiss();
        SPUtils.getInstance().put(BaseConstants.token, "");
        showCustomWindowDialog("服务提示", msg,true);

    }
}
