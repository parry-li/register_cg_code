package com.tdr.registration.ui.fragment.register;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parry.utils.code.SPUtils;
import com.tdr.registration.R;
import com.tdr.registration.adapter.InsuranceAdapter;
import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.bean.InsuranceInfoBean;
import com.tdr.registration.bean.LableListBean;
import com.tdr.registration.bean.PhotoConfigBean;
import com.tdr.registration.bean.PhotoListBean;
import com.tdr.registration.bean.RegisterPutBean;
import com.tdr.registration.bean.VehicleConfigBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.impl.car.RegisterImpl;
import com.tdr.registration.service.presenter.RegisterPresenter;
import com.tdr.registration.ui.activity.car.RegisterMainActivity;
import com.tdr.registration.ui.fragment.base.LoadingBaseFragment;
import com.tdr.registration.utils.ToastUtil;
import com.tdr.registration.utils.UIUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class RegisterInsuranceFragment extends LoadingBaseFragment<RegisterImpl> implements RegisterPresenter.View {
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.insurance_rv)
    RecyclerView insuranceRv;
    @BindView(R.id.insurance_p_no)
    TextView insurancePNo;
    @BindView(R.id.insurance_p_gr)
    TextView insurancePGr;
    @BindView(R.id.insurance_p_qy)
    TextView insurancePQy;
    @BindView(R.id.insurance_kp_ll)
    LinearLayout insuranceKpLl;
    @BindView(R.id.button_next)
    TextView buttonNext;
    @BindView(R.id.empty_iv)
    ImageView emptyIv;
    @BindView(R.id.empty_tv)
    TextView emptyTv;
    @BindView(R.id.empty_data_rl)
    RelativeLayout emptyDataRl;

    private InsuranceAdapter insuranceAdapter;
    private int vehicleType;
    private List<InsuranceBean> adapterList;


    @Override
    protected RegisterImpl setPresenter() {
        return new RegisterImpl();
    }

    @Override
    protected void loadData() {
        try {
            int systemId = SPUtils.getInstance().getInt(BaseConstants.Login_city_systemID, -100);
            vehicleType = ((RegisterMainActivity) RegisterInsuranceFragment.this.getActivity()).vehicleType;
            String buyDate = ((RegisterMainActivity) RegisterInsuranceFragment.this.getActivity()).registerPutBean.getRegisterTime();
            Map<String, Object> map = new HashMap<>();
            map.put("subsystemId", systemId);
            map.put("vehicleType", vehicleType);
            map.put("insuranceMode", 0);
            map.put("buyDate", buyDate);
            mPresenter.getInsurance(getRequestBody(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register_insurance;
    }

    @Override
    protected void initView() {
        textTitle.setText("备案登记");
        comTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RegisterMainActivity) RegisterInsuranceFragment.this.getActivity()).setVpCurrentItem(1);
            }
        });
        initRv();
    }

    private void initRv() {
        List<InsuranceBean> insuranceBeans = new ArrayList<>();
        insuranceRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        insuranceAdapter = new InsuranceAdapter(RegisterInsuranceFragment.this.getContext(), insuranceBeans,insuranceRv);
        insuranceRv.setAdapter(insuranceAdapter);

    }

    private int insurance_bill = 1;

    @OnClick({R.id.insurance_p_no, R.id.insurance_p_gr, R.id.insurance_p_qy, R.id.button_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.insurance_p_no:
                insurancePNo.setTextColor(UIUtils.getColor(R.color.module_main));
                insurancePGr.setTextColor(UIUtils.getColor(R.color.module_text_3));
                insurancePQy.setTextColor(UIUtils.getColor(R.color.module_text_3));
                insurance_bill = 1;
                break;
            case R.id.insurance_p_gr:
                insurancePNo.setTextColor(UIUtils.getColor(R.color.module_text_3));
                insurancePGr.setTextColor(UIUtils.getColor(R.color.module_main));
                insurancePQy.setTextColor(UIUtils.getColor(R.color.module_text_3));
                insurance_bill = 2;
                break;
            case R.id.insurance_p_qy:
                insurancePNo.setTextColor(UIUtils.getColor(R.color.module_text_3));
                insurancePGr.setTextColor(UIUtils.getColor(R.color.module_text_3));
                insurancePQy.setTextColor(UIUtils.getColor(R.color.module_main));
                insurance_bill = 3;
                break;
            case R.id.button_next:
                putData();
                break;
        }
    }

    private void putData() {
        try {
          adapterList = insuranceAdapter.getData();

            for (InsuranceBean insuranceBean : adapterList) {
                if (insuranceBean.getIsChoose() == 1) {
                    boolean isHaveCheck = false;
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
            showSubmitRequestDialog();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkPlateNumberSuccess() {

    }

    @Override
    public void checkPlateNumberFail(String msg) {

    }

    @Override
    public void getInsuranceSuccess(List<InsuranceBean> list) {
        insuranceAdapter.setNewData(list);
        emptyDataRl.setVisibility(View.GONE);
    }

    @Override
    public void getInsuranceFail(String msg) {

        showCustomWindowDialog("服务提示", msg, true);
        emptyDataRl.setVisibility(View.VISIBLE);
    }

    @Override
    public void changeFail(String msg) {

    }

    @Override
    public void changeSuccess(String msg) {

    }

    @Override
    public void loadingSuccessForData(DdcResult mData) {

        showCustomWindowDialog("服务提示",mData.getMsg(),true);
    }

    @Override
    public void loadingFail(String msg) {
        showCustomWindowDialog("服务提示",msg,false,true);
        setState(BaseConstants.STATE_SUCCESS);
        zProgressHUD.dismiss();
    }


    @Override
    protected void submitRequestData() {
        RegisterPutBean registerBean = ((RegisterMainActivity) RegisterInsuranceFragment.this.getActivity()).registerPutBean;
        int subsystemId = SPUtils.getInstance().getInt(BaseConstants.Login_city_systemID);
        Map<String, Object> map = new HashMap<>();
        map.put("subsystemId", subsystemId);
        map.put("billType", insurance_bill);

        /*以下为baseInfo(基本信息)*/

        Map<String, Object> baseInfoMap = new HashMap<>();
        baseInfoMap.put("vehicleType", vehicleType);
        baseInfoMap.put("vehicleBrand", registerBean.getRegisterBrandCode());
        baseInfoMap.put("vehicleBrandName", registerBean.getRegisterBrand());
        baseInfoMap.put("colorId", registerBean.getRegisterColor1Id());
        baseInfoMap.put("colorName", registerBean.getRegisterColor1Name());
        baseInfoMap.put("colorSecondId", registerBean.getRegisterColor2Id());
        baseInfoMap.put("colorSecondName", registerBean.getRegisterColor2Name());
        baseInfoMap.put("plateNumber", registerBean.getRegisterPlate());
        baseInfoMap.put("plateType", "1");

        map.put("baseInfo", baseInfoMap);

        /*以下为labelInfo(标签信息)*/
        Map<String, Object> labelInfoMap = new HashMap<>();
        List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean>
                lableList = registerBean.getLableList();
        List<LableListBean> lableListBeanList = new ArrayList<>();
        for (VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean bean : lableList) {

            LableListBean lableBean = new LableListBean();
            String lablenumber = bean.getEditValue();
            lableBean.setIndex(bean.getIndex());
            lableBean.setLableType(lablenumber.substring(0, 4));
            lableBean.setLableNumber(lablenumber);
            lableListBeanList.add(lableBean);
        }
        labelInfoMap.put("lableList", lableListBeanList);
        labelInfoMap.put("engineNumber", registerBean.getRegisterElectrical());
        labelInfoMap.put("shelvesNumber", registerBean.getRegisterFrame());

        map.put("labelInfo", labelInfoMap);
        /*以下为buyInfo(车辆购买信息)*/
        Map<String, Object> buyInfoMap = new HashMap<>();

        buyInfoMap.put("buyDate", registerBean.getRegisterTime());
        buyInfoMap.put("buyPrice", registerBean.getRegisterPrice());


        List<PhotoConfigBean.PhotoTypeInfoListBean>
                photoList = registerBean.getPhotoList();

        List<PhotoListBean> photoListBeans = new ArrayList<>();
        for (PhotoConfigBean.PhotoTypeInfoListBean bean : photoList) {
            PhotoListBean photoBean = new PhotoListBean();
            photoBean.setIndex(bean.getPhotoIndex());
            photoBean.setPhtotoType(bean.getPhotoType() + "");
            photoBean.setPhoto(bean.getPhotoId());
            photoListBeans.add(photoBean);
        }

        buyInfoMap.put("photoList", photoListBeans);
        map.put("buyInfo", buyInfoMap);

        /*以下为ownerInfo(车主信息)*/
        Map<String, Object> ownerInfoMap = new HashMap<>();
        ownerInfoMap.put("ownerName", registerBean.getPeopleName());
        ownerInfoMap.put("cardType", registerBean.getPeopleCardType());
        ownerInfoMap.put("cardId", registerBean.getPeopleCardNum());
        ownerInfoMap.put("phone1", registerBean.getPeoplePhone1());
        ownerInfoMap.put("phone2", registerBean.getPeoplePhone2());
        ownerInfoMap.put("residentAddress", registerBean.getPeopleAddr());
        ownerInfoMap.put("remark", registerBean.getPeopleRemark());
        map.put("ownerInfo", ownerInfoMap);


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
        packagesInfo.put("packages",infoBeanList);
        map.put("insuranceInfo", packagesInfo);
        zProgressHUD.show();
        /*提交接口*/
        mPresenter.register(getRequestBody(map));
    }
}
