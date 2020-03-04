package com.tdr.registrationv3.ui.activity.insurance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.InsuranceWaitBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.impl.insurance.InsuranceWaitImpl;
import com.tdr.registrationv3.service.presenter.InsuranceWaitPresenter;
import com.tdr.registrationv3.ui.activity.CodeTableActivity;
import com.tdr.registrationv3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationv3.utils.ActivityUtil;
import com.tdr.registrationv3.utils.RegularUtil;
import com.tdr.registrationv3.utils.ToastUtil;
import com.tdr.registrationv3.utils.UIUtils;
import com.tdr.registrationv3.view.CustomWindowDialog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class InsuranceWaitChangeActivity extends LoadingBaseActivity<InsuranceWaitImpl> implements InsuranceWaitPresenter.View {
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.wait_brand)
    TextView waitBrand;
    @BindView(R.id.wait_brand_arrow)
    ImageView waitBrandArrow;
    @BindView(R.id.wait_plate)
    EditText waitPlate;
    @BindView(R.id.wait_shelves)
    EditText waitShelves;
    @BindView(R.id.wait_engine)
    EditText waitEngine;
    @BindView(R.id.wait_color1)
    TextView waitColor1;
    @BindView(R.id.wait_color1_arrow)
    ImageView waitColor1Arrow;
    @BindView(R.id.wait_color2)
    TextView waitColor2;
    @BindView(R.id.wait_color2_arrow)
    ImageView waitColor2Arrow;
    @BindView(R.id.wait_owername)
    EditText waitOwername;
    @BindView(R.id.wait_cardType)
    TextView waitCardType;
    @BindView(R.id.wait_cardType_arrow)
    ImageView waitCardTypeArrow;
    @BindView(R.id.wait_cardnum)
    EditText waitCardnum;
    @BindView(R.id.wait_phone)
    EditText waitPhone;
    @BindView(R.id.wait_adr)
    EditText waitAdr;
    @BindView(R.id.button_next)
    TextView buttonNext;
    private InsuranceWaitBean waitBean;
    private final int CODE_TABLE_BRAND = 2001;
    private final int CODE_TABLE_COLOR = 2002;
    private final int CODE_TABLE_CARD = 2003;
    private String brandCode;
    private String color1;
    private String color2;
    private String cardTypeCode;


    @Override
    protected void initData(Bundle savedInstanceState) {
        String json = SPUtils.getInstance().getString(BaseConstants.data);
        if (!TextUtils.isEmpty(json)) {
            waitBean = new Gson().fromJson(json, InsuranceWaitBean.class);
            SPUtils.getInstance().remove(BaseConstants.data);
            initContentData();
        }
        UIUtils.setEditTextUpperCase(waitPlate);
        UIUtils.setEditTextUpperCase(waitCardnum);
    }

    private void initContentData() {
        waitBrand.setText(waitBean.getVehicleBrandName());
        waitPlate.setText(waitBean.getPlateNumber());
        waitShelves.setText(waitBean.getShelvesNumber());
        waitEngine.setText(waitBean.getEngineNumber());
        waitColor1.setText(waitBean.getColorName());
        waitColor2.setText(waitBean.getColorSecondName());
        waitOwername.setText(waitBean.getOwnerName());
        waitCardType.setText(waitBean.getCardName());
        waitCardnum.setText(waitBean.getCardId());
        waitPhone.setText(waitBean.getPhone1());
        waitAdr.setText(waitBean.getResidentAddress());

        brandCode = waitBean.getVehicleBrand();
        color1 = waitBean.getColorId();
        color2 = waitBean.getColorSecondId();
        cardTypeCode = waitBean.getCardType() + "";

    }

    @Override
    protected void initTitle() {
        titleBackClickListener(comTitleBack);
        textTitle.setText("修改");
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected InsuranceWaitImpl setPresenter() {
        return new InsuranceWaitImpl();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_wait_change;
    }

    @Override
    protected void submitRequestData() {
        zProgressHUD.show();
        mPresenter.pushAgain(getSubmitBoby());
    }


    @OnClick({R.id.wait_brand, R.id.wait_brand_arrow, R.id.wait_color1, R.id.wait_color1_arrow,
            R.id.wait_color2, R.id.wait_color2_arrow, R.id.wait_cardType, R.id.wait_cardType_arrow, R.id.button_next})
    public void onViewClicked(android.view.View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.wait_brand:
            case R.id.wait_brand_arrow:
                bundle.putInt(BaseConstants.code_table, 1);
                ActivityUtil.goActivityForResult(InsuranceWaitChangeActivity.this,
                        CodeTableActivity.class, bundle, CODE_TABLE_BRAND);
                break;
            case R.id.wait_color1:
            case R.id.wait_color1_arrow:
                isMainClolor = true;
                bundle.putInt(BaseConstants.code_table, 4);
                ActivityUtil.goActivityForResult(InsuranceWaitChangeActivity.this,
                        CodeTableActivity.class, bundle, CODE_TABLE_COLOR);
                break;
            case R.id.wait_color2:
            case R.id.wait_color2_arrow:
                isMainClolor = false;
                bundle.putInt(BaseConstants.code_table, 4);
                ActivityUtil.goActivityForResult(InsuranceWaitChangeActivity.this,
                        CodeTableActivity.class, bundle, CODE_TABLE_COLOR);
                break;
            case R.id.wait_cardType:
            case R.id.wait_cardType_arrow:
                bundle.putInt(BaseConstants.code_table, 6);
                ActivityUtil.goActivityForResult(InsuranceWaitChangeActivity.this,
                        CodeTableActivity.class, bundle, CODE_TABLE_CARD);
                break;
            case R.id.button_next:
                pushData();
                break;
        }
    }

    private void pushData() {
        String plateStr = waitPlate.getText().toString().trim().toUpperCase();
        if (TextUtils.isEmpty(plateStr)) {
            ToastUtil.showWX("请输入车牌号");
            return;
        }
        String shelvesStr = waitShelves.getText().toString().trim();
        if (TextUtils.isEmpty(shelvesStr)) {
            ToastUtil.showWX("请输入车架号");
            return;
        }
        String engineStr = waitEngine.getText().toString().trim();
        if (TextUtils.isEmpty(engineStr)) {
            ToastUtil.showWX("请输入电机号");
            return;
        }
        String nameStr = waitOwername.getText().toString().trim();
        if (TextUtils.isEmpty(nameStr)) {
            ToastUtil.showWX("请输入姓名");
            return;
        }
        String cardNumStr = waitCardnum.getText().toString().trim().toUpperCase();
        if (TextUtils.isEmpty(cardNumStr)) {
            ToastUtil.showWX("请输入证件号");
            return;
        }

        if (cardTypeCode.equals("1")) {
            if (!RegularUtil.isIDCard18(cardNumStr)) {
                ToastUtil.showWX("输入的证件号码有误");
                return;
            }
        }
        String phoneStr = waitPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phoneStr)) {
            ToastUtil.showWX("请输入联系手机");
            return;
        }
        if(!RegularUtil.isMobileExact(phoneStr)){
            ToastUtil.showWX("联系手机号码有误");
            return;
        }
        String adrStr = waitAdr.getText().toString().trim();

        if (TextUtils.isEmpty(adrStr)) {
            ToastUtil.showWX("请输入地址");
            return;
        }
        String brandStr = waitBrand.getText().toString().trim();
        String color1Str = waitColor1.getText().toString().trim();
        String color2Str = waitColor2.getText().toString().trim();
        String cardTypeStr = waitCardType.getText().toString().trim();


        Map<String, Object> map = new HashMap<>();
        map.put("id", waitBean.getId());
        map.put("plateNumber", plateStr);
        map.put("vehicleBrand", brandCode);
        map.put("vehicleBrandName", brandStr);
        map.put("colorId", color1);
        map.put("colorName", color1Str);
        map.put("colorSecondId", color2);
        map.put("colorSecondName", color2Str);
        map.put("engineNumber", engineStr);
        map.put("shelvesNumber", shelvesStr);
        map.put("ownerName", nameStr);
        map.put("cardId", cardNumStr);
        map.put("cardType", cardTypeCode);
        map.put("cardName", cardTypeStr);
        map.put("phone1", phoneStr);
        map.put("residentAddress", adrStr);
        showSubmitRequestDialog(map);

    }

    private boolean isMainClolor = true;//是否选择的是主颜色

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String name = data.getStringExtra(BaseConstants.KEY_NAME);
            String cardCode = data.getStringExtra(BaseConstants.KEY_VALUE);
            switch (requestCode) {

                case CODE_TABLE_BRAND:

                    waitBrand.setText(name);
                    brandCode = cardCode;
                    break;
                case CODE_TABLE_CARD:

                    waitCardType.setText(name);
                    cardTypeCode = cardCode;
                    break;
                case CODE_TABLE_COLOR:

                    if (isMainClolor) {
                        waitColor1.setText(name);
                        color1 = cardCode;
                    } else {
                        waitColor2.setText(name);
                        color2 = cardCode;
                    }
                    break;

            }


        }
    }

    @Override
    public void pushAgainSuccess(String msg) {
        zProgressHUD.dismiss();
        CustomWindowDialog customWindowDialog = new CustomWindowDialog(this);
        customWindowDialog.showCustomWindowDialog("服务提示", msg, true);
        customWindowDialog.setOnCustomDialogClickListener(new CustomWindowDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener() {
                setResult(RESULT_OK);
                finish();
            }
        });

    }

    @Override
    public void pushAgainFail(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);
    }

    @Override
    public void loadingSuccessForData(DdcResult<List<InsuranceWaitBean>> mData) {
        zProgressHUD.dismiss();
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
