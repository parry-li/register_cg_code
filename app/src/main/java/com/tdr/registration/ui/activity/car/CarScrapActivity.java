package com.tdr.registration.ui.activity.car;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tdr.registration.R;
import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.constants.UrlConstants;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.impl.BaseRequestImpl;
import com.tdr.registration.service.presenter.BaseRequestPresenter;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;
import com.tdr.registration.utils.ToastUtil;
import com.tdr.registration.view.CustomTimeDialog;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarScrapActivity extends LoadingBaseActivity<BaseRequestImpl> implements BaseRequestPresenter.View {

    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.change_plate)
    TextView changePlate;
    @BindView(R.id.change_brand)
    TextView changeBrand;
    @BindView(R.id.change_color)
    TextView changeColor;
    @BindView(R.id.change_phone)
    TextView changePhone;
    @BindView(R.id.change_ower)
    TextView changeOwer;
    @BindView(R.id.change_card)
    TextView changeCard;
    @BindView(R.id.scrap_name)
    EditText scrapName;
    @BindView(R.id.scrap_time)
    TextView scrapTime;
    @BindView(R.id.scrap_reason)
    EditText scrapReason;
    @BindView(R.id.scrap_button)
    TextView scrapButton;
    private CarCheckBean checkBean;
    private CustomTimeDialog timeDialog;

    @Override
    protected void initData(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            checkBean = (CarCheckBean) bundle.getSerializable(BaseConstants.data);
            initDataView(checkBean);

        }
        timeDialog = new CustomTimeDialog(CarScrapActivity.this);
        timeDialog.setOnCustomClickListener(new CustomTimeDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener(String value) {
                scrapTime.setText(value);
            }
        });
    }

    private void initDataView(CarCheckBean checkBean) {
        changePlate.setText(checkBean.getPlateNumber());
        changeBrand.setText(checkBean.getVehicleBrandStr());
        changeColor.setText(checkBean.getColorIdStr());
        changePhone.setText(checkBean.getPhone1());
        changeOwer.setText(checkBean.getOwnerName());
        changeCard.setText(checkBean.getCardId());
    }

    @Override
    protected void initTitle() {
        titleBackClickListener(comTitleBack);
        textTitle.setText("车辆报废");
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected BaseRequestImpl setPresenter() {
        return new BaseRequestImpl();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_car_scrap;
    }

    @OnClick({R.id.scrap_time, R.id.scrap_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.scrap_time:
                timeDialog.showDialog();
                break;
            case R.id.scrap_button:
                putData();
                break;
        }
    }

    private void putData() {
        String name = scrapName.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showWX("请输入姓名");
            return;
        }
        String mTime = scrapTime.getText().toString().trim();
        if (TextUtils.isEmpty(mTime)) {
            ToastUtil.showWX("请选择时间");
            return;
        }
        String reason = scrapReason.getText().toString().trim();
        Map<String, Object> map = new HashMap<>();
        map.put("scrapName", name);
        map.put("plateNumber", checkBean.getPlateNumber());
        map.put("cardId", checkBean.getCardId());
        map.put("scrapTime", mTime);
        map.put("scrapReason", reason);
        mPresenter.put(UrlConstants.electriccarsScrap_add, getRequestBody(map));
    }

    @Override
    public void loadingSuccessForData(DdcResult mData) {

        showCustomWindowDialog("温馨提示", "报废成功", true);
    }

    @Override
    public void loadingFail(String msg) {

    }


}
