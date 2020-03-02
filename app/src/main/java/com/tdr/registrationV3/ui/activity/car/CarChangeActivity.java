package com.tdr.registrationV3.ui.activity.car;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.adapter.ChangTypeAdapter;
import com.tdr.registrationV3.adapter.LabelAdapter;
import com.tdr.registrationV3.adapter.PhotoAdapter;
import com.tdr.registrationV3.bean.CarCheckBean;
import com.tdr.registrationV3.bean.LableListBean;
import com.tdr.registrationV3.bean.PhotoConfigBean;
import com.tdr.registrationV3.bean.PhotoListBean;
import com.tdr.registrationV3.bean.VehicleConfigBean;
import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.http.utils.DdcResult;
import com.tdr.registrationV3.listener.CustomSendLister;
import com.tdr.registrationV3.service.impl.car.CarChangeImpl;
import com.tdr.registrationV3.service.presenter.CarChangePresenter;
import com.tdr.registrationV3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationV3.utils.ConfigUtil;
import com.tdr.registrationV3.utils.ImageSendUtil;
import com.tdr.registrationV3.utils.PhotoUtils;
import com.tdr.registrationV3.utils.ScanUtil;
import com.tdr.registrationV3.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class CarChangeActivity extends LoadingBaseActivity<CarChangeImpl> implements CarChangePresenter.View {
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
    private LabelAdapter contentAdapter;
    private int contentPosition = -1;
    private String carRegular;
    private List<PhotoConfigBean.PhotoTypeInfoListBean> photoList;
    private PhotoAdapter photoAdapter;
    private int photoPosition = -1;
    private List<PhotoConfigBean.PhotoTypeInfoListBean> photoData;
    private List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> contentData;

    @Override
    protected void initTitle() {
        titleBackClickListener(comTitleBack);
        textTitle.setText("车牌补办");
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected CarChangeImpl setPresenter() {
        return new CarChangeImpl();
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

    private void initLabelRv() {

        List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean>
                data = new ArrayList<>();

        changeContentRv.setLayoutManager(new LinearLayoutManager(this));
        contentAdapter = new LabelAdapter(data, false);
        changeContentRv.setAdapter(contentAdapter);
        contentAdapter.setOnItemClickListener(new LabelAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, String name) {

                contentPosition = position;
                ScanUtil.Scan(CarChangeActivity.this, name);
            }
        });
    }

    private void initPhotoRv() {
        PhotoConfigBean configBean = ConfigUtil.getPhotoConfig();
        if (configBean == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        changePhotoRv.setLayoutManager(linearLayoutManager);
        photoList = new ArrayList<>();
        if (configBean != null) {
            for (PhotoConfigBean.PhotoTypeInfoListBean photoBean : configBean.getPhotoTypeInfoList()) {
                if (photoBean.isIsValid()) {
                    photoBean.setIsRequire(false);
                    photoList.add(photoBean);
                }
            }

        }

        photoAdapter = new PhotoAdapter(CarChangeActivity.this, photoList);
        changePhotoRv.setAdapter(photoAdapter);
        photoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                photoPosition = position;
                PhotoUtils.getPhotoByCamera(CarChangeActivity.this);
            }
        });
    }

    private void initTypeRv() {
        VehicleConfigBean configBean = ConfigUtil.getVehicleConfig();
        if (configBean == null) {

            return;
        }
        changTypeList = new ArrayList<>();

        if (configBean != null) {
            boolean isScanCar = false;
            List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> configList = new ArrayList<>();
            for (VehicleConfigBean.VehicleLicenseInfoListBean infoListBean : configBean.getVehicleLicenseInfoList()) {
                if (infoListBean.getTypeId() == checkBean.getVehicleType()) {
                    configList = infoListBean.getVehicleNbLableConfigList();
                    carRegular = infoListBean.getVehicleNoReg();
                    isScanCar = infoListBean.isVehicleNoScan();
                    break;
                }
            }
            VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean bean =
                    new VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean();

            bean.setLableName("车牌号");
            bean.setIndex(0);
            bean.setScan(isScanCar);// 是否扫描
            changTypeList.add(bean);
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

        checkLabelList = new ArrayList<>();//集合数据
        // 拿到所有数据
        Map<Integer, Boolean> isCheck = changTypeAdapter.getMap();
        // 获取到条目数量
        int count = changTypeList.size();
        List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean>
                contentAdapterList = contentAdapter.getData();

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

        /*车牌 照片1必须*/
        boolean isHavePlate = false;
        for (int i = 0; i < checkLabelList.size(); i++) {
            if (checkLabelList.get(i).getIndex() == 0) {
                isHavePlate = true;

            }
        }
        List<PhotoConfigBean.PhotoTypeInfoListBean> photoData = photoAdapter.getData();
        for (int k = 0; k < photoData.size(); k++) {

            if (photoData.get(k).getPhotoIndex() == 1) {
                photoData.get(k).setIsRequire(isHavePlate);
            } else {
                photoData.get(k).setIsRequire(false);
            }

        }
        photoAdapter.setNewData(photoData);


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

    @Override
    protected void submitRequestData() {

        Map<String, Object> map = new HashMap<>();
        map.put("id", checkBean.getId());
        map.put("reason", changeReason.getText().toString().trim());


        /*照片数据*/
        List<PhotoListBean> photoListBeans = new ArrayList<>();
        for (int i = 0; i < photoData.size(); i++) {
            PhotoListBean bean = new PhotoListBean();
            bean.setIndex(photoData.get(i).getPhotoIndex());
            bean.setPhoto(photoData.get(i).getPhotoId());
            bean.setPhotoType(photoData.get(i).getPhotoType());
            bean.setPhotoName(photoData.get(i).getPhotoName());
            photoListBeans.add(bean);
        }
        map.put("photoList", photoListBeans);
        /*标签数据*/
        List<LableListBean> lableListBeans = new ArrayList<>();
        for (int i = 0; i < contentData.size(); i++) {
            LableListBean bean = new LableListBean();
            bean.setIndex(contentData.get(i).getIndex());
            bean.setLableNumber(contentData.get(i).getEditValue());
            bean.setLabelName(contentData.get(i).getEditValue());
            if (contentData.get(i).getIndex() != 0) {
                bean.setLableType(contentData.get(i).getEditValue().substring(0, 4));
            }
            lableListBeans.add(bean);
        }
        map.put("changeContentList", lableListBeans);
        zProgressHUD.show();
        mPresenter.carChange(getRequestBody(map));
    }


    @OnClick(R.id.change_button)
    public void onViewClicked() {
        putData();
    }

    private void putData() {
        contentData = contentAdapter.getData();
        if (contentData == null || contentData.size() == 0) {
            ToastUtil.showWX("请选择补办类型");
            return;
        }
        boolean isPlate = false;
        for (int i = 0; i < contentData.size(); i++) {

            if (contentData.get(i).getIndex() == 0) {
                isPlate = true;
            }
            if (TextUtils.isEmpty(contentData.get(i).getEditValue())) {
                ToastUtil.showWX("请输入" + contentData.get(i).getLableName());
                return;
            }
            if (isPlate) {
                String plateNum = ScanUtil.checkPlateNumber(true, carRegular, contentData.get(i).getEditValue());
                if (TextUtils.isEmpty(plateNum)) {
                    return;
                }
            }

        }
        photoData = photoAdapter.getData();
        /*车牌必须有照片*/
        if (isPlate) {
            for (int j = 0; j < photoData.size(); j++) {
                if (photoData.get(j).getPhotoIndex() == 1) {
                    if (TextUtils.isEmpty(photoData.get(j).getPhotoId())) {
                        if (photoData.get(j).getDrawable() != null) {
                            ToastUtil.showWX("正在上传" + photoData.get(j).getPhotoName());
                        } else {
                            ToastUtil.showWX("请选择" + photoData.get(j).getPhotoName());
                        }

                        return;
                    }
                }
            }
        }

        showSubmitRequestDialog();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ScanUtil.SCANNIN_QR_CODE:
                    setScanData(data);
                    break;
                case PhotoUtils.CAMERA_REQESTCODE:
                    Bitmap bitmap = PhotoUtils.getResultCameraPhoto();
                    Bitmap bitmapS = PhotoUtils.compressImageBySmile(bitmap);
                    Drawable drawable = new BitmapDrawable(bitmapS);
                    photoList.get(photoPosition).setDrawable(drawable);
                    photoList.get(photoPosition).setPhotoId(null);
                    photoAdapter.setNewData(photoList);
                    ImageSendUtil.sendImage(bitmap, photoPosition, customSendLister);
                    break;
            }
        }
    }

    CustomSendLister customSendLister = new CustomSendLister() {
        @Override
        public void sendResult(Boolean isSuccess, int position, String photoId) {
            if (isSuccess) {
                photoList.get(position).setPhotoId(photoId);
            } else {
                photoList.get(position).setDrawable(null);
            }
            photoAdapter.setNewData(photoList);
        }
    };

    private void setScanData(Intent data) {
        if (data == null) {
            ToastUtil.showWX("没有扫描到二维码");
            return;
        } else {
            Bundle bundle = data.getExtras();
            String labelNumber = bundle.getString("result");
            String scanNum = "";
            List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean>
                    contentAdapterList = contentAdapter.getData();
            VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean
                    item = contentAdapterList.get(contentPosition);
            /*车牌*/
            if (contentAdapter.getData().get(contentPosition).getIndex() == 0) {
                boolean isScan = bundle.getBoolean("isScan");
                scanNum = ScanUtil.checkPlateNumber(isScan, carRegular, labelNumber);

            } else {
                if (ScanUtil.checkTheft(item.getEqType(), item.getLableName(), labelNumber)) {
                    scanNum = labelNumber;
                }
            }

            if (!TextUtils.isEmpty(scanNum)) {
                contentAdapterList.get(contentPosition).setEditValue(scanNum.toUpperCase());
                contentAdapter.setNewData(contentAdapterList);
            }
        }
    }


    @Override
    public void loadingSuccessForData(DdcResult mData) {
        zProgressHUD.dismiss();
        customBaseDialog.showCustomWindowDialog("服务提示", "补办成功", true);
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
        customBaseDialog.showCustomWindowDialog("服务提示", msg, false, true);
    }
}
