package com.tdr.registrationv3.ui.fragment.register;

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
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.BlcakCarBean;
import com.tdr.registrationv3.bean.InfoBean;
import com.tdr.registrationv3.bean.InsuranceBean;
import com.tdr.registrationv3.bean.LableListBean;
import com.tdr.registrationv3.bean.PhotoConfigBean;
import com.tdr.registrationv3.bean.PhotoListBean;
import com.tdr.registrationv3.bean.RegisterPutBean;
import com.tdr.registrationv3.bean.VehicleConfigBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.impl.car.RegisterImpl;
import com.tdr.registrationv3.service.presenter.RegisterPresenter;
import com.tdr.registrationv3.ui.activity.CodeTableActivity;
import com.tdr.registrationv3.ui.activity.car.ChangeRegisterMainActivity;

import com.tdr.registrationv3.ui.fragment.base.LoadingBaseFragment;
import com.tdr.registrationv3.utils.ActivityUtil;
import com.tdr.registrationv3.utils.RegularUtil;
import com.tdr.registrationv3.utils.ToastUtil;
import com.tdr.registrationv3.utils.UIUtils;

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
        setState(BaseConstants.STATE_SUCCESS);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register_people;
    }

    @Override
    protected void initView() {
        textTitle.setText("信息变更");
        comTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ChangeRegisterMainActivity) mActivity).setVpCurrentItem(0);
            }
        });
        mActivity = ChangeRegisterPeopleFragment.this.getActivity();
        initContentData();
        UIUtils.setEditTextUpperCase(peopleCardNum);
    }

    private void initContentData() {
        InfoBean infoBean = ((ChangeRegisterMainActivity) mActivity).infoBean;
        peopleName.setText(infoBean.getElectriccars().getOwnerName());
        peopleCard.setText(infoBean.getElectriccars().getCardName());
        peopleCardNum.setText(infoBean.getElectriccars().getCardId());
        peoplePhone1.setText(infoBean.getElectriccars().getPhone1());
        peoplePhone2.setText(infoBean.getElectriccars().getPhone2());
        peopleAdr.setText(infoBean.getElectriccars().getResidentAddress());
        peopleRemark.setText(infoBean.getElectriccars().getRemark());

        cardCode = infoBean.getElectriccars().getCardType() + "";

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
        String peopleCardNumStr = peopleCardNum.getText().toString().trim().toUpperCase();
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
        String peopleCardStr = peopleCard.getText().toString().trim();

        if (!TextUtils.isEmpty(peoplePhone2Str)) {
            if (!RegularUtil.isMobileExact(peoplePhone2Str)) {
                ToastUtil.showWX("输入的备用号码有误");
                return;
            }
        }

        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setPeopleName(peopleNameStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setPeopleCardNum(peopleCardNumStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setPeopleCardType(cardCode);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setCardName(peopleCardStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setPeoplePhone1(peoplePhone1Str);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setPeoplePhone2(peoplePhone2Str);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setPeopleAddr(peopleAdrStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setPeopleRemark(peopleRemarkStr);

        sendData();

    }

    private void sendData() {
        try {

            RegisterPutBean registerBean = ((ChangeRegisterMainActivity) mActivity).registerPutBean;
            int subsystemId = SPUtils.getInstance().getInt(BaseConstants.City_systemID);
            Map<String, Object> map = new HashMap<>();
            map.put("subsystemId", subsystemId);
            map.put("id", registerBean.getId());


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
                lableBean.setLabelName(bean.getLableName());
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
                photoBean.setPhotoType(bean.getPhotoType());
                photoBean.setPhoto(bean.getPhotoId());
                photoBean.setPhotoName(bean.getPhotoName());
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
            ownerInfoMap.put("cardName", registerBean.getCardName());
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
                resultCode == ((ChangeRegisterMainActivity) mActivity).RESULT_OK) {
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
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);

    }

    @Override
    public void changeSuccess(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, true);
    }

    @Override
    public void checkShelvesNumberFail(String msg) {

    }

    @Override
    public void checkShelvesNumberSuccess(List<BlcakCarBean> msg) {

    }

    @Override
    public void loadingSuccessForData(DdcResult mData) {
        zProgressHUD.dismiss();
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);
    }


    @Override
    protected void submitRequestData() {
        /*提交接口*/
        zProgressHUD.show();
        mPresenter.change(getSubmitBoby());
    }
}
