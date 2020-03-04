package com.tdr.registrationv3.ui.activity.car;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.CarCheckBean;
import com.tdr.registrationv3.bean.EditInfoBean;
import com.tdr.registrationv3.bean.InfoBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.service.impl.car.CarQueryImpl;
import com.tdr.registrationv3.service.presenter.CarQueryPresenter;
import com.tdr.registrationv3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationv3.ui.activity.insurance.InsuranceActivity;
import com.tdr.registrationv3.utils.ActivityUtil;
import com.tdr.registrationv3.utils.ToastUtil;
import com.tdr.registrationv3.utils.UIUtils;
import com.tdr.registrationv3.view.CarQueryDialog;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.line_view)
    View lineView;
    private String rolePower = "";
    private CarQueryDialog queryDialog;
    private CarCheckBean carCheckBean;
    private int systemId;
    private InfoBean carInfoBean;
    private EditInfoBean editInfoBean;

    @Override
    protected void initTitle() {

        titleBackClickListener(comTitleBack);



    }

    @Override
    protected void loadData() {
        carCheckBean = new CarCheckBean();
    }

    @Override
    protected CarQueryImpl setPresenter() {
        return new CarQueryImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        systemId = SPUtils.getInstance().getInt(BaseConstants.City_systemID);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            rolePower = bundle.getString("rolePower");

            if (rolePower.equals(BaseConstants.funJurisdiction[1])) {//补办
                textTitle.setText("车牌补办");
            } else if (rolePower.equals(BaseConstants.funJurisdiction[2])) {//过户
                textTitle.setText("车辆过户");
            } else if (rolePower.equals(BaseConstants.funJurisdiction[0])) {//报废
                textTitle.setText("车辆报废");
            } else if (rolePower.equals("change_register")) {
                textTitle.setText("信息变更");
            } else if (rolePower.equals("insurance_change")) {
                textTitle.setText("服务变更");
                carId.setVisibility(View.GONE);
                lineView.setVisibility(View.GONE);
            } else if (rolePower.equals(BaseConstants.funJurisdiction[3])) {
                textTitle.setText("服务延期");
                carId.setVisibility(View.GONE);
                lineView.setVisibility(View.GONE);
            } else if (rolePower.equals(BaseConstants.funJurisdiction[4])) {
                textTitle.setText("服务购买");
                carId.setVisibility(View.GONE);
                lineView.setVisibility(View.GONE);
            }
        }

        UIUtils.setEditTextUpperCase(plateNumber);
        UIUtils.setEditTextUpperCase(carId);
        queryDialog = new CarQueryDialog();
        queryDialog.setOnCustomDialogClickListener(new CarQueryDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener() {
                if (TextUtils.isEmpty(rolePower)) {
                    ToastUtil.showWX("权限码有误");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(BaseConstants.rolePower, rolePower);

                if (rolePower.equals(BaseConstants.funJurisdiction[1])) {//补办
                    bundle.putSerializable(BaseConstants.data, carCheckBean);

                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, CarChangeActivity.class, bundle);

                } else if (rolePower.equals(BaseConstants.funJurisdiction[2])) {//过户

                    bundle.putSerializable(BaseConstants.data, carCheckBean);
                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, CarTransferActivity.class, bundle);

                } else if (rolePower.equals(BaseConstants.funJurisdiction[0])) {//报废

                    bundle.putSerializable(BaseConstants.data, carCheckBean);
                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, CarScrapActivity.class, bundle);

                } else if (rolePower.equals("change_register")) {//信息变更
                    String dataJson = new Gson().toJson(carInfoBean);
                    bundle.putString(BaseConstants.data,dataJson);
                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, ChangeRegisterMainActivity.class, bundle);
                } else if (rolePower.equals("insurance_change")
                        || rolePower.equals(BaseConstants.funJurisdiction[3])
                        || rolePower.equals(BaseConstants.funJurisdiction[4])
                        ) {//服务变更、服务购买、服务延期


                    if(rolePower.equals("insurance_change")){
                        /*保险变更没有数据时 不进入保险*/
                        if(editInfoBean.getPolicyList()==null||editInfoBean.getPolicyList().size()==0){
                            showCustomWindowDialog("温馨提示","车辆未购买保险或保险已续保不允许变更",false,true);
                            return;
                        }
                    }
                    bundle.putSerializable(BaseConstants.data, carCheckBean);
                    String dataJson = new Gson().toJson(editInfoBean);
                    bundle.putSerializable(BaseConstants.data2, dataJson);
                    ActivityUtil.goActivityWithBundle(CarQueryActivity.this, InsuranceActivity.class, bundle);
                }

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_car_query;
    }

    @Override
    protected void submitRequestData() {

    }


    @OnClick(R.id.button_confirm)
    public void onViewClicked() {

        String plateNumberStr = plateNumber.getText().toString().trim().toUpperCase();
        String carIdStr = carId.getText().toString().trim().toUpperCase();

        if (TextUtils.isEmpty(plateNumberStr)) {
            ToastUtil.showWX("请输入车牌号");
            return;
        }
        zProgressHUD.show();
        Map<String, Object> map = new HashMap<>();
        map.put("subsystemId", systemId);
        if (rolePower.equals("insurance_change")
                || rolePower.equals(BaseConstants.funJurisdiction[3])
                || rolePower.equals(BaseConstants.funJurisdiction[4])) {
            map.put("plateNumber", plateNumberStr);
            /*服务变更添加参数 筛选已续保的保险*/
            if(rolePower.equals("insurance_change")){
                map.put("serviceChange", "1");
            }

            mPresenter.getEditInfo(getRequestBody(map));
        } else {
            if (TextUtils.isEmpty(carIdStr)) {
                ToastUtil.showWX("请输入证件号");
                return;
            }
            map.put("plateNumber", plateNumberStr);
            map.put("cardId", carIdStr);
            mPresenter.queryCarInfo(getRequestBody(map));
        }

    }


    @Override
    public void loadingSuccessForData(final CarCheckBean mData) {
        zProgressHUD.dismiss();
        carCheckBean = mData;
        queryDialog.showCarQueryDialog(CarQueryActivity.this, mData);
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
    }

    @Override
    public void getEditInfoSuccess(EditInfoBean infoBean) {
        zProgressHUD.dismiss();
        editInfoBean = infoBean;
        carCheckBean.setId(infoBean.getId());
        carCheckBean.setBuyDate(infoBean.getBuyInfo().getBuyDate());
        carCheckBean.setVehicleType(infoBean.getBaseInfo().getVehicleType());
        carCheckBean.setPlateNumber(infoBean.getBaseInfo().getPlateNumber());
        carCheckBean.setCardId(infoBean.getOwnerInfo().getCardId());
        carCheckBean.setOwnerName(infoBean.getOwnerInfo().getOwnerName());
        carCheckBean.setVehicleBrandStr(infoBean.getBaseInfo().getVehicleBrandName());
        carCheckBean.setPhone1(infoBean.getOwnerInfo().getPhone1());
        carCheckBean.setColorIdStr(infoBean.getBaseInfo().getColorName());
        queryDialog.showCarQueryDialog(CarQueryActivity.this, carCheckBean);

    }

    @Override
    public void getEditInfoFail(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);
    }

    @Override
    public void queryCarInfoSuccess(InfoBean infoBean) {
        zProgressHUD.dismiss();
        carInfoBean = infoBean;
        carCheckBean.setId(infoBean.getElectriccars().getId());
        carCheckBean.setBuyDate(infoBean.getElectriccars().getBuyDate());
        carCheckBean.setVehicleType(infoBean.getElectriccars().getVehicleType());
        carCheckBean.setPlateNumber(infoBean.getElectriccars().getPlateNumber());
        carCheckBean.setCardId(infoBean.getElectriccars().getCardId());
        carCheckBean.setOwnerName(infoBean.getElectriccars().getOwnerName());
        carCheckBean.setVehicleBrandStr(infoBean.getElectriccars().getVehicleBrandName());
        carCheckBean.setPhone1(infoBean.getElectriccars().getPhone1());
        carCheckBean.setColorIdStr(infoBean.getElectriccars().getColorName());
        queryDialog.showCarQueryDialog(CarQueryActivity.this, carCheckBean);
    }

    @Override
    public void queryCarInfoFail(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);
    }


}
