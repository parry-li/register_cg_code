package com.tdr.registrationV3.ui.fragment.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parry.utils.code.SPUtils;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.InsuranceBean;
import com.tdr.registrationV3.bean.LableListBean;
import com.tdr.registrationV3.bean.PhotoConfigBean;
import com.tdr.registrationV3.bean.PhotoListBean;
import com.tdr.registrationV3.bean.RegisterPutBean;
import com.tdr.registrationV3.bean.VehicleConfigBean;
import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.service.impl.car.RegisterImpl;
import com.tdr.registrationV3.service.presenter.RegisterPresenter;
import com.tdr.registrationV3.ui.activity.CodeTableActivity;
import com.tdr.registrationV3.ui.activity.car.ChangeRegisterActivity;

import com.tdr.registrationV3.ui.fragment.base.LoadingBaseFragment;
import com.tdr.registrationV3.utils.ActivityUtil;
import com.tdr.registrationV3.utils.RegularUtil;
import com.tdr.registrationV3.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangeRegisterPeopleFragment extends LoadingBaseFragment<RegisterImpl> implements RegisterPresenter.View {
    private static final int CODE_TABLE_CARD = 2001;
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.people_name)
    EditText peopleName;
    @BindView(R.id.people_card)
    TextView peopleCard;
    @BindView(R.id.people_card_allow)
    ImageView peopleCardAllow;
    @BindView(R.id.people_card_num)
    EditText peopleCardNum;
    @BindView(R.id.people_phone1)
    EditText peoplePhone1;
    @BindView(R.id.people_phone2)
    EditText peoplePhone2;
    @BindView(R.id.people_adr)
    EditText peopleAdr;
    @BindView(R.id.people_remark)
    EditText peopleRemark;
    @BindView(R.id.button_next)
    TextView buttonNext;

    private String cardCode = "1";
    private Activity mActivity;


    @Override
    protected RegisterImpl setPresenter() {
        return new RegisterImpl();
    }

    @Override
    protected void loadData() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register_people;
    }

    @Override
    protected void initView() {
        textTitle.setText("备案登记");
        comTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ChangeRegisterActivity) mActivity).setVpCurrentItem(0);
            }
        });
        mActivity = ChangeRegisterPeopleFragment.this.getActivity();
    }

    @OnClick({R.id.people_card, R.id.people_card_allow, R.id.button_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.people_card:
            case R.id.people_card_allow:
                Bundle bundle = new Bundle();
                bundle.putInt(BaseConstants.code_table, 6);
                startActivityForResult(ActivityUtil.goActivityForResultForFragment(mActivity,
                        CodeTableActivity.class, bundle), CODE_TABLE_CARD);
                break;
            case R.id.button_next:
                putData();
                break;
        }
    }

    private void putData() {
        String peopleNameStr = peopleName.getText().toString().trim();
        if (TextUtils.isEmpty(peopleNameStr)) {
            ToastUtil.showWX("请输入姓名");
            return;
        }
        String peopleCardNumStr = peopleCardNum.getText().toString().trim();
        if (TextUtils.isEmpty(peopleCardNumStr)) {
            ToastUtil.showWX("请输入证件号");
            return;
        }
        if ("1".equals(cardCode)) {
            if (!RegularUtil.isIDCard18(peopleCardNumStr)) {
                ToastUtil.showWX("输入的证件号有误");
                return;
            }
        }
        String peoplePhone1Str = peoplePhone1.getText().toString().trim();
        if (TextUtils.isEmpty(peoplePhone1Str)) {
            ToastUtil.showWX("请输入联系手机");
            return;
        }
        if (!RegularUtil.isMobileExact(peoplePhone1Str)) {
            ToastUtil.showWX("输入的手机号码有误");
            return;
        }
        String peopleAdrStr = peopleAdr.getText().toString().trim();
        if (TextUtils.isEmpty(peopleAdrStr)) {
            ToastUtil.showWX("请输入地址");
            return;
        }
        String peoplePhone2Str = peoplePhone2.getText().toString().trim();
        String peopleRemarkStr = peopleRemark.getText().toString().trim();

        if (!TextUtils.isEmpty(peoplePhone2Str)) {
            if (!RegularUtil.isMobileExact(peoplePhone2Str)) {
                ToastUtil.showWX("输入的备用号码有误");
                return;
            }
        }

        ((ChangeRegisterActivity) mActivity).registerPutBean.setPeopleName(peopleNameStr);
        ((ChangeRegisterActivity) mActivity).registerPutBean.setPeopleCardNum(peopleCardNumStr);
        ((ChangeRegisterActivity) mActivity).registerPutBean.setPeopleCardType(cardCode);
        ((ChangeRegisterActivity) mActivity).registerPutBean.setPeoplePhone1(peoplePhone1Str);
        ((ChangeRegisterActivity) mActivity).registerPutBean.setPeoplePhone2(peoplePhone2Str);
        ((ChangeRegisterActivity) mActivity).registerPutBean.setPeopleAddr(peopleAdrStr);
        ((ChangeRegisterActivity) mActivity).registerPutBean.setPeopleRemark(peopleRemarkStr);

        sendData();

    }

    private void sendData() {
        try {

            RegisterPutBean registerBean = ((ChangeRegisterActivity) mActivity).registerPutBean;
            int subsystemId = SPUtils.getInstance().getInt(BaseConstants.Login_city_systemID);
            Map<String, Object> map = new HashMap<>();
            map.put("subsystemId", subsystemId);


            /*以下为baseInfo(基本信息)*/

            Map<String, Object> baseInfoMap = new HashMap<>();
            baseInfoMap.put("vehicleType", registerBean.getVehicleType());
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

            showSubmitRequestDialog(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_TABLE_CARD &&
                resultCode == ((ChangeRegisterActivity) mActivity).RESULT_OK) {
            String name = data.getStringExtra(BaseConstants.KEY_NAME);
            cardCode = data.getStringExtra(BaseConstants.KEY_VALUE);
            peopleCard.setText(name);

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

    }

    @Override
    public void getInsuranceFail(String msg) {

    }

    @Override
    public void changeFail(String msg) {
        showCustomWindowDialog("服务提示", msg, true);

    }

    @Override
    public void changeSuccess(String msg) {
        showCustomWindowDialog("服务提示", msg, false, true);
    }

    @Override
    public void loadingSuccessForData(DdcResult mData) {

    }

    @Override
    public void loadingFail(String msg) {

    }

    @Override
    protected void submitRequestData() {
        /*提交接口*/
        mPresenter.change(getSubmitBoby());
    }
}
