package com.tdr.registration.ui.activity.car;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tdr.registration.R;
import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.CityBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.service.impl.car.CarQueryImpl;
import com.tdr.registration.service.presenter.CarQueryPresenter;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;
import com.tdr.registration.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registration.utils.ActivityUtil;
import com.tdr.registration.utils.ToastUtil;
import com.tdr.registration.view.CarQueryDialog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;

public class CarQueryActivity extends LoadingBaseActivity<CarQueryImpl> implements CarQueryPresenter.View {
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.plate_number)
    EditText plateNumber;
    @BindView(R.id.car_id)
    EditText carId;
    @BindView(R.id.button_confirm)
    TextView buttonConfirm;
    private String rolePower = "";
    private CarQueryDialog queryDialog;
    private CarCheckBean carCheckBean;

    @Override
    protected void initTitle() {

        titleBackClickListener(comTitleBack);


    }

    @Override
    protected void loadData() {

    }

    @Override
    protected CarQueryImpl setPresenter() {
        return new CarQueryImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            rolePower = bundle.getString("rolePower");

            if (rolePower.equals(BaseConstants.funJurisdiction[1])) {//补办
                textTitle.setText("车牌补办");
            } else if (rolePower.equals(BaseConstants.funJurisdiction[2])) {//过户
                textTitle.setText("车辆过户");
            } else if (rolePower.equals(BaseConstants.funJurisdiction[0])) {//报废
                textTitle.setText("车辆报废");
            } else if (rolePower.equals("changeRegister")) {
                textTitle.setText("信息变更");
            }
        }

        queryDialog = new CarQueryDialog();
        queryDialog.setOnCustomDialogClickListener(new CarQueryDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener() {
                if (TextUtils.isEmpty(rolePower)) {
                    ToastUtil.showWX("权限码有误");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable(BaseConstants.data, carCheckBean);
                if (rolePower.equals(BaseConstants.funJurisdiction[1])) {//补办
                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, CarChangeActivity.class, bundle);
                } else if (rolePower.equals(BaseConstants.funJurisdiction[2])) {//过户
                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, CarTransferActivity.class, bundle);
                } else if (rolePower.equals(BaseConstants.funJurisdiction[0])) {//报废
                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, CarScrapActivity.class, bundle);
                }else if (rolePower.equals("changeRegister")) {//信息变更
                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, ChangeRegisterActivity.class, bundle);
                }

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_car_query;
    }


    @OnClick(R.id.button_confirm)
    public void onViewClicked() {

        String plateNumberStr = plateNumber.getText().toString().trim();
        String carIdStr = carId.getText().toString().trim();

        if (TextUtils.isEmpty(plateNumberStr)) {
            ToastUtil.showWX("请输入车牌号");
            return;
        }
        if (TextUtils.isEmpty(carIdStr)) {
            ToastUtil.showWX("请输入证件号");
            return;
        }
        zProgressHUD.show();
        Map<String, Object> map = new HashMap<>();
        map.put("plateNumber", plateNumberStr);
        map.put("cardId", carIdStr);
        mPresenter.checkCar(getRequestBody(map));
    }


    @Override
    public void loadingSuccessForData(final CarCheckBean mData) {
        zProgressHUD.dismiss();

        queryDialog.showCarQueryDialog(CarQueryActivity.this, mData);
       carCheckBean =mData;


    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
    }
}
