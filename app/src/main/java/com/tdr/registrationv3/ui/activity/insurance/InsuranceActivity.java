package com.tdr.registrationv3.ui.activity.insurance;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.adapter.InsuranceAdapter;
import com.tdr.registrationv3.bean.CarCheckBean;
import com.tdr.registrationv3.bean.EditInfoBean;
import com.tdr.registrationv3.bean.InsuranceBean;
import com.tdr.registrationv3.bean.InsuranceInfoBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.constants.UrlConstants;
import com.tdr.registrationv3.service.impl.car.InsuranceImpl;
import com.tdr.registrationv3.service.presenter.InsurancePresenter;
import com.tdr.registrationv3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationv3.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.tdr.registrationv3.constants.BaseConstants.rolePower;

/**
 * 服务变更、服务购买、服务延期
 */
public class InsuranceActivity extends LoadingBaseActivity<InsuranceImpl> implements InsurancePresenter.View {


    @BindView(R.id.insurance_rv)
    RecyclerView insuranceRv;
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.button_next)
    TextView buttonNext;
    @BindView(R.id.empty_iv)
    ImageView emptyIv;
    @BindView(R.id.empty_tv)
    TextView emptyTv;
    @BindView(R.id.empty_data_rl)
    RelativeLayout emptyDataRl;
    private InsuranceAdapter insuranceAdapter;
    private String rolePowerStr;
    private int systemId;
    private CarCheckBean checkBean;
    private List<InsuranceBean> adapterList;
    private EditInfoBean infoBean;

    @Override
    protected void initTitle() {

        titleBackClickListener(comTitleBack);
    }

    @Override
    protected void loadData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            /*rolePower.equals("insurance_change")
                        || rolePower.equals(BaseConstants.funJurisdiction[3])
                        || rolePower.equals(BaseConstants.funJurisdiction[4])*/
            checkBean = (CarCheckBean) bundle.getSerializable(BaseConstants.data);
            rolePowerStr = bundle.getString(rolePower);
            systemId = SPUtils.getInstance().getInt(BaseConstants.City_systemID);
            Map<String, Object> map = new HashMap<>();
            if ("insurance_change".equals(rolePowerStr)) {
                textTitle.setText("服务变更");
                map.put("subsystemId", systemId);
                map.put("vehicleType", checkBean.getVehicleType());
                map.put("insuranceMode", 0);
                map.put("buyDate", checkBean.getBuyDate());
                mPresenter.getNewAndRenewInsurance(UrlConstants.configure_getInsuranceConfigs, getRequestBody(map));
                getInsuranceForPlate(bundle);
            } else if (BaseConstants.funJurisdiction[4].equals(rolePowerStr)) {
                //新保
                textTitle.setText("服务购买");
                map.put("id", checkBean.getId());
                mPresenter.getNewAndRenewInsurance(UrlConstants.policy_getNewInsuranceConfigs, getRequestBody(map));
            } else if (BaseConstants.funJurisdiction[3].equals(rolePowerStr)) {
                //续保
                textTitle.setText("服务延期");
                map.put("id", checkBean.getId());
                mPresenter.getNewAndRenewInsurance(UrlConstants.policy_getRenewInsuranceConfigs, getRequestBody(map));
            }

            zProgressHUD.show();

        }

    }

    private void getInsuranceForPlate(Bundle bundle) {

        String dataJson = bundle.getString(BaseConstants.data2);
        if (!TextUtils.isEmpty(dataJson)) {
            infoBean = new Gson().fromJson(dataJson, EditInfoBean.class);
        }
    }

    @Override
    protected InsuranceImpl setPresenter() {
        return new InsuranceImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_instrance;
    }

    @Override
    protected void submitRequestData() {
        zProgressHUD.show();
        Map<String, Object> map = new HashMap<>();

        map.put("id", checkBean.getId());


        /*以下为insuranceInfo(保险信息)*/

        Map<String, Object> packagesInfo = new HashMap<>();
        List<InsuranceInfoBean> infoBeanList = new ArrayList<>();
        for (InsuranceBean bean : adapterList) {
            for (InsuranceBean.PackagesBean packagesBean : bean.getPackages()) {
                if (packagesBean.isCheck()) {
                    infoBeanList.add(new InsuranceInfoBean(bean.getId(), packagesBean.getId()));

                }
            }
        }
        packagesInfo.put("packages", infoBeanList);
        map.put("insuranceInfo", packagesInfo);
        if ("insurance_change".equals(rolePowerStr)) {
            map.put("subsystemId", systemId);
            mPresenter.submitData(UrlConstants.policy_edit, getRequestBody(map));
        } else {
            mPresenter.submitData(UrlConstants.policy_insured, getRequestBody(map));
        }
    }


    @OnClick(R.id.button_next)
    public void onViewClicked() {
        adapterList = insuranceAdapter.getData();
        boolean isFatherChecked = false;
        for (InsuranceBean insuranceBean : adapterList) {
            if (insuranceBean.getIsChoose() == 1 || insuranceBean.isChecked()) {
                boolean isHaveCheck = false;
                isFatherChecked = true;
                for (InsuranceBean.PackagesBean packagesBean : insuranceBean.getPackages()) {

                    if (packagesBean.isCheck()) {
                        isHaveCheck = true;
                    }
                }
                if (!isHaveCheck) {
                    ToastUtil.showWX("请选择" + insuranceBean.getName());
                    return;
                }
            }

        }

        if (!isFatherChecked) {
            ToastUtil.showWX("请选择保险");
            return;
        }

        showSubmitRequestDialog();


    }


    @Override
    public void loadingSuccessForData(List<InsuranceBean> mData) {
        if (mData.size() == 0) {
            emptyDataRl.setVisibility(View.VISIBLE);
        } else {
            emptyDataRl.setVisibility(View.GONE);

            if ("insurance_change".equals(rolePowerStr)) {
                if (infoBean != null) {

                    mData =  getSelectData(mData);
                }
            }
        }


        zProgressHUD.dismiss();
        insuranceRv.setLayoutManager(new LinearLayoutManager(this));
        insuranceAdapter = new InsuranceAdapter(this, mData, insuranceRv);
        insuranceRv.setAdapter(insuranceAdapter);
    }

    private List<InsuranceBean> getSelectData(List<InsuranceBean> mData) {
        List<EditInfoBean.PolicyListBean>
                selectPolicyList = infoBean.getPolicyList();//选择的数据
        int mSize = mData.size();
        for (int i = 0; i < mSize; i++) {
            InsuranceBean fatherData = mData.get(i);
            for (EditInfoBean.PolicyListBean selectBean : selectPolicyList) {
                if (selectBean.getInsuranceConfigId() == fatherData.getId()) {
                    /*保险数据*/
                    List<InsuranceBean.PackagesBean>
                            packages = fatherData.getPackages();
                    int packagesSize = packages.size();
                    for (int j = 0; j < packagesSize; j++) {

                        if (packages.get(j).getId() == selectBean.getInsurancePackageId()) {
                            mData.get(i).getPackages().get(j).setCheck(true);
                        }
                    }
                }

            }
        }


        return mData;
    }

    @Override
    public void loadingFail(String msg) {

        zProgressHUD.dismiss();
    }

    @Override
    public void submitDataSuccess(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, true);

    }

    @Override
    public void submitDataFail(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);
    }


}
