package com.tdr.registration.ui.activity.car;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registration.R;
import com.tdr.registration.adapter.ChangTypeAdapter;
import com.tdr.registration.adapter.ChangeContentAdapter;
import com.tdr.registration.adapter.ChangePhotoAdapter;
import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.PhotoConfigBean;
import com.tdr.registration.bean.VehicleConfigBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registration.utils.ActivityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarChangeActivity extends NoLoadingBaseActivity {
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.com_title_main_relativeLayout)
    RelativeLayout comTitleMainRelativeLayout;
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
    @BindView(R.id.change_type_rv)
    RecyclerView changeTypeRv;
    @BindView(R.id.change_photo_rv)
    RecyclerView changePhotoRv;
    @BindView(R.id.change_content_rv)
    RecyclerView changeContentRv;
    @BindView(R.id.change_reason)
    EditText changeReason;
    @BindView(R.id.change_button)
    TextView changeButton;
    private CarCheckBean checkBean;
    private ChangTypeAdapter changTypeAdapter;
    private ArrayList<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> changTypeList;
    private ArrayList<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> checkLabelList;
    private ChangeContentAdapter contentAdapter;

    @Override
    protected void initTitle() {
        titleBackClickListener(comTitleBack);
        textTitle.setText("车牌补办");
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            checkBean = (CarCheckBean) bundle.getSerializable(BaseConstants.data);
            initDataView(checkBean);
            initTypeRv();
            initPhotoRv();
            initLabelRv();
        }
    }
    private void Scan(int ScanType, boolean isshow, boolean isPlate, String ButtonName) {
        Bundle bundle = new Bundle();
        bundle.putInt("ScanType", ScanType);
        bundle.putBoolean("isShow", isshow);
        bundle.putBoolean("isPlateNumber", isPlate);
        bundle.putString("ButtonName", ButtonName);
        ActivityUtil.goActivityForResultWithBundle(this, QRCodeScanActivity.class, bundle,
                SCANNIN_QR_CODE);
    }
    private void initLabelRv() {
        changeContentRv.setLayoutManager(new LinearLayoutManager(this));
        List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> data = new ArrayList<>();
        contentAdapter = new ChangeContentAdapter(data);
        changeContentRv.setAdapter(contentAdapter);
        contentAdapter.setOnItemClickListener(new ChangeContentAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {

            }
        });
    }

    private void initPhotoRv() {
        String PhotoConfigJson = SPUtils.getInstance().getString(BaseConstants.PhotoConfig);
        PhotoConfigBean configBean = new Gson().fromJson(PhotoConfigJson, PhotoConfigBean.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        changePhotoRv.setLayoutManager(linearLayoutManager);
        List<PhotoConfigBean.PhotoTypeInfoListBean> photoList = new ArrayList<>();
        if (configBean != null) {
            for (PhotoConfigBean.PhotoTypeInfoListBean photoBean : configBean.getPhotoTypeInfoList()) {
                if (photoBean.isIsValid()) {
                    photoList.add(photoBean);
                }
            }

        }

        ChangePhotoAdapter photoAdapter = new ChangePhotoAdapter(photoList);
        changePhotoRv.setAdapter(photoAdapter);
    }

    private void initTypeRv() {
        String VehicleConfigJson = SPUtils.getInstance().getString(BaseConstants.VehicleConfig);
        VehicleConfigBean configBean = new Gson().fromJson(VehicleConfigJson, VehicleConfigBean.class);

        changTypeList = new ArrayList<>();
        VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean bean =
                new VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean();

        bean.setLableName("车牌号");
        bean.setIndex(0);
        changTypeList.add(bean);
        if (configBean != null) {
            List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> configList = new ArrayList<>();
            for (VehicleConfigBean.VehicleLicenseInfoListBean infoListBean : configBean.getVehicleLicenseInfoList()) {
                if (infoListBean.getTypeId() == checkBean.getVehicleType()) {
                    configList = infoListBean.getVehicleNbLableConfigList();
                    break;
                }
            }

            for (VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean configListBean : configList) {
                if (configListBean.isIsValid()) {
                    changTypeList.add(configListBean);
                }
            }
        }
        changeTypeRv.setLayoutManager(new GridLayoutManager(this, 3));
        changTypeAdapter = new ChangTypeAdapter(changTypeList);
        changeTypeRv.setAdapter(changTypeAdapter);
        changTypeAdapter.setOnItemClickListener(new ChangTypeAdapter.OnItemChangeClickListener() {
            @Override
            public void onItemChangeClickListener() {
                setLableAdapter();
            }
        });

    }

    private void setLableAdapter() {

        checkLabelList = new ArrayList<>();
        // 拿到所有数据
        Map<Integer, Boolean> isCheck = changTypeAdapter.getMap();
        // 获取到条目数量，map.size = list.size,所以
        int count = changTypeList.size();
        List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean>
                contentAdapterList = contentAdapter.getData();
        for (int j = 0; j < changTypeList.size(); j++) {
            changTypeList.get(j).setEditValue(null);

        }
        for (VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean adapterBean : contentAdapterList) {
            for (int j = 0; j < changTypeList.size(); j++) {
                if (changTypeList.get(j).getIndex() == adapterBean.getIndex()) {
                    changTypeList.get(j).setEditValue(adapterBean.getEditValue());
                }
            }
        }

        for (int i = 0; i < count; i++) {

            if (isCheck.get(i)) {
                checkLabelList.add(changTypeList.get(i));
            } else {
                changTypeList.get(i).setEditValue(null);
            }

        }

        contentAdapter.setNewData(checkLabelList);


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
    protected int getLayoutId() {
        return R.layout.activity_car_change;
    }


    @OnClick(R.id.change_button)
    public void onViewClicked() {
    }
}
