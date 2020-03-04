package com.tdr.registrationv3.ui.activity.me;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tdr.registrationv3.R;
import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.impl.BaseRequestImpl;
import com.tdr.registrationv3.service.presenter.BaseRequestPresenter;
import com.tdr.registrationv3.ui.activity.LoginActivity;
import com.tdr.registrationv3.ui.activity.base.BaseActivity;
import com.tdr.registrationv3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationv3.utils.ActivityUtil;
import com.tdr.registrationv3.utils.ToastUtil;
import com.tdr.registrationv3.view.CustomWindowDialog;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class PasswordActivity extends LoadingBaseActivity<BaseRequestImpl> implements BaseRequestPresenter.View {
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.password_old)
    EditText passwordOld;
    @BindView(R.id.password_old_v)
    View passwordOldV;
    @BindView(R.id.password_new)
    EditText passwordNew;
    @BindView(R.id.password_new_v)
    View passwordNewV;
    @BindView(R.id.password_confirm)
    EditText passwordConfirm;
    @BindView(R.id.password_confirm_v)
    View passwordConfirmV;
    @BindView(R.id.button_next)
    TextView buttonNext;
    private CustomWindowDialog loginOutDialog;

    @Override
    protected void initTitle() {
        textTitle.setText("修改密码");
        titleBackClickListener(comTitleBack);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected BaseRequestImpl setPresenter() {
        return new BaseRequestImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        passwordOld.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    passwordOldV.setBackgroundResource(R.color.module_main);
                } else {
                    passwordOldV.setBackgroundResource(R.color.module_background);
                }
            }
        });
        passwordNew.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    passwordNewV.setBackgroundResource(R.color.module_main);
                } else {
                    passwordNewV.setBackgroundResource(R.color.module_background);
                }
            }
        });
        passwordConfirm.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    passwordConfirmV.setBackgroundResource(R.color.module_main);
                } else {
                    passwordConfirmV.setBackgroundResource(R.color.module_background);
                }
            }
        });


        passwordOld.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setButtonColor();
            }
        });
        passwordNew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setButtonColor();
            }
        });
        passwordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                setButtonColor();
            }
        });

        loginOutDialog = new CustomWindowDialog(PasswordActivity.this);
        loginOutDialog.setOnCustomDialogClickListener(new CustomWindowDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener() {
                BaseActivity.activity.clearDataForLoginOut();
                killAll();
                ActivityUtil.goActivityAndFinish(PasswordActivity.this, LoginActivity.class);
            }
        });

    }

    private void setButtonColor() {
        String oldStr = passwordOld.getText().toString().trim();
        String newStr = passwordNew.getText().toString().trim();
        String confirmStr = passwordConfirm.getText().toString().trim();
        if (!TextUtils.isEmpty(oldStr) && !TextUtils.isEmpty(newStr) && !TextUtils.isEmpty(confirmStr)) {
            buttonNext.setBackgroundResource(R.mipmap.button_select);
            buttonNext.setTextColor(getResources().getColor(R.color.module_white));
        } else {
            buttonNext.setBackgroundResource(R.mipmap.button_unselect);
            buttonNext.setTextColor(getResources().getColor(R.color.module_button_unselect));

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_password;
    }

    @Override
    protected void submitRequestData() {

        zProgressHUD.show();
        mPresenter.put(UrlConstants.user_updatePwd, getSubmitBoby());
    }


    @OnClick(R.id.button_next)
    public void onViewClicked() {
        String oldStr = passwordOld.getText().toString().trim();
        if (TextUtils.isEmpty(oldStr)) {
            ToastUtil.showWX("请输入原密码");
            return;
        }
        String newStr = passwordNew.getText().toString().trim();
        if (TextUtils.isEmpty(newStr)) {
            ToastUtil.showWX("请输入新密码");
            return;
        }
        String confirmStr = passwordConfirm.getText().toString().trim();
        if (TextUtils.isEmpty(confirmStr)) {
            ToastUtil.showWX("请输入确认新密码");
            return;
        }
        if (!newStr.equals(confirmStr)) {
            ToastUtil.showWX("新密码和确认密码不一致");
            return;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("oldPwd", oldStr);
        map.put("firstPwd", newStr);
        map.put("secondPwd", confirmStr);
        showSubmitRequestDialog(map);
    }

    @Override
    public void loadingSuccessForData(DdcResult mData) {
        zProgressHUD.dismiss();
        loginOutDialog.showCustomWindowDialog("服务提示", mData.getMsg(), true);
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
        loginOutDialog.showCustomWindowDialog("服务提示", msg, false, true);
    }
}
