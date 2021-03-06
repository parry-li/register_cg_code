package com.tdr.registrationv3.ui.fragment.register;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.adapter.LabelAdapter;
import com.tdr.registrationv3.adapter.PhotoAdapter;
import com.tdr.registrationv3.bean.BlcakCarBean;
import com.tdr.registrationv3.bean.InfoBean;
import com.tdr.registrationv3.bean.InsuranceBean;
import com.tdr.registrationv3.bean.PhotoConfigBean;
import com.tdr.registrationv3.bean.RegisterConfigBean;
import com.tdr.registrationv3.bean.VehicleConfigBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.listener.CustomSendLister;
import com.tdr.registrationv3.rx.RxBus;
import com.tdr.registrationv3.service.impl.car.RegisterImpl;
import com.tdr.registrationv3.service.presenter.RegisterPresenter;
import com.tdr.registrationv3.ui.activity.CodeTableActivity;
import com.tdr.registrationv3.ui.activity.base.BaseActivity;
import com.tdr.registrationv3.ui.activity.car.ChangeRegisterMainActivity;
import com.tdr.registrationv3.ui.activity.car.RegisterMainActivity;
import com.tdr.registrationv3.ui.fragment.base.LoadingBaseFragment;
import com.tdr.registrationv3.utils.ConfigUtil;
import com.tdr.registrationv3.utils.ImageSendUtil;
import com.tdr.registrationv3.utils.LabelSendUtil;
import com.tdr.registrationv3.utils.PhotoUtils;
import com.tdr.registrationv3.utils.ScanUtil;
import com.tdr.registrationv3.utils.ToastUtil;
import com.tdr.registrationv3.utils.UIUtils;
import com.tdr.registrationv3.view.ChackBlackCarDialog;
import com.tdr.registrationv3.view.CustomTimeDialog;
import com.zhihu.matisse.Matisse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class ChangeRegisterCarFragment extends LoadingBaseFragment<RegisterImpl> implements RegisterPresenter.View {

    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.car_photo_rv)
    RecyclerView carPhotoRv;
    @BindView(R.id.car_brand)
    TextView carBrand;
    @BindView(R.id.car_brand_allow)
    ImageView carBrandAllow;
    @BindView(R.id.car_plate)
    EditText carPlate;
    @BindView(R.id.car_label_rv)
    RecyclerView carLabelRv;
    @BindView(R.id.car_frame)
    EditText carFrame;
    @BindView(R.id.car_electrical)
    EditText carElectrical;
    @BindView(R.id.car_color_main)
    TextView carColorMain;
    @BindView(R.id.car_color1_allow)
    ImageView carColor1Allow;
    @BindView(R.id.car_color_minor)
    TextView carColorMinor;
    @BindView(R.id.car_color2_allow)
    ImageView carColor2Allow;
    @BindView(R.id.car_time)
    TextView carTime;
    @BindView(R.id.car_time_allow)
    ImageView carTimeAllow;
    private final int CODE_TABLE_BRAND = 2001;
    private final int CODE_TABLE_COLOR = 2002;
    @BindView(R.id.car_frame_x)
    TextView carFrameX;
    @BindView(R.id.car_electrical_x)
    TextView carElectricalX;
    @BindView(R.id.button_next)
    TextView buttonNext;
    @BindView(R.id.car_plate_tv)
    TextView carPlateTv;
    @BindView(R.id.car_plate_scan)
    ImageView carPlateScan;
    @BindView(R.id.car_price)
    EditText carPrice;


    private ArrayList<PhotoConfigBean.PhotoTypeInfoListBean> photoList;
    private PhotoAdapter photoAdapter;
    private int photoPosition;
    private CustomTimeDialog timeDialog;
    private Activity mActivity;
    private String cardBrandType;
    private String carColorMainId;
    private String carColorMinorId;
    private LabelAdapter contentAdapter;
    private int contentPosition;
    private VehicleConfigBean.EngineNoRegularBean engIneBean;
    private VehicleConfigBean.ShelvesNoRegularBean shelvesBean;
    private VehicleConfigBean.VehicleLicenseInfoListBean vehicleInfoBean;
    private String carRegular;
    private int vehicleType;
    private boolean isCheckBlackCar = false;//是否校验黑车默认不校验
    private InfoBean infoBean;
    private CompositeSubscription buxSubscription;

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
        return R.layout.fragment_register_car;
    }

    @Override
    protected void initView() {
        mActivity = ChangeRegisterCarFragment.this.getActivity();
        infoBean = ((ChangeRegisterMainActivity) mActivity).infoBean;
        UIUtils.setEditTextUpperCase(carFrame);
        UIUtils.setEditTextUpperCase(carElectrical);
        UIUtils.setEditTextUpperCase(carPlate);
        initTitle();

        VehicleConfigBean vehicleBean = ConfigUtil.getVehicleConfig();
        if (vehicleBean == null) {
            return;
        }
        vehicleType = infoBean.getElectriccars().getVehicleType();
        initContentView(vehicleBean);
        initPhotoRv(infoBean);
        initLabelRv(infoBean);

        intContentData(infoBean);
        registerBux();
    }

    private void intContentData(InfoBean infoBean) {
        carBrand.setText(infoBean.getElectriccars().getVehicleBrandName());
        carPlate.setText(infoBean.getElectriccars().getPlateNumber());
        carPlateTv.setText(infoBean.getElectriccars().getPlateNumber());
        carFrame.setText(infoBean.getElectriccars().getShelvesNumber());
        carElectrical.setText(infoBean.getElectriccars().getEngineNumber());
        carColorMain.setText(infoBean.getElectriccars().getColorName());
        carColorMinor.setText(infoBean.getElectriccars().getColorSecondName());
        carTime.setText(infoBean.getElectriccars().getBuyDate());
        carPrice.setText(infoBean.getElectriccars().getBuyPrice() + "");

        carColorMainId = infoBean.getElectriccars().getColorId();
        carColorMinorId = infoBean.getElectriccars().getColorSecondId();
        cardBrandType = infoBean.getElectriccars().getVehicleBrand();
    }

    private void initContentView(VehicleConfigBean vehicleBean) {

        RegisterConfigBean registerConfigBean = ConfigUtil.getRegisterConfig();
        if (registerConfigBean != null) {
            /*默认 1不进行校验 2表示校验*/
            if (registerConfigBean.getBlackCheck() == 2) {
                isCheckBlackCar = true;
            }
        }

        engIneBean = vehicleBean.getEngineNoRegular();
        if (!engIneBean.isIsRequire()) {
            carElectricalX.setVisibility(View.GONE);
        }

        /*车架*/
        shelvesBean = vehicleBean.getShelvesNoRegular();
        if (!shelvesBean.isIsRequire()) {
            carFrameX.setVisibility(View.GONE);
        }

        for (VehicleConfigBean.VehicleLicenseInfoListBean infoBean : vehicleBean.getVehicleLicenseInfoList()) {
            if (infoBean.getTypeId() == vehicleType) {
                vehicleInfoBean = infoBean;
            }
        }

        if (vehicleInfoBean != null) {
            carRegular = vehicleInfoBean.getVehicleNoReg();

            /*车牌扫码*/
            if (vehicleInfoBean.isVehicleNoScan()) {
                carPlateTv.setVisibility(View.VISIBLE);
                carPlateScan.setVisibility(View.VISIBLE);
                carPlate.setVisibility(View.GONE);
            } else {
                carPlateTv.setVisibility(View.GONE);
                carPlateScan.setVisibility(View.GONE);
                carPlate.setVisibility(View.VISIBLE);
            }
        }



        timeDialog = new CustomTimeDialog(mActivity, false);
        timeDialog.setOnCustomClickListener(new CustomTimeDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener(String value) {
                carTime.setText(value);
            }
        });
    }

    private void initLabelRv(InfoBean infoBean) {
        List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> infoLabelList
                = vehicleInfoBean.getVehicleNbLableConfigList();
        if (infoBean.getElectriccarsMapList() != null && infoBean.getElectriccarsMapList().size() > 0) {
            for (int i = 0; i < infoLabelList.size(); i++) {

                for (InfoBean.ElectriccarsMapListBean mapBean : infoBean.getElectriccarsMapList()) {

                    if (infoLabelList.get(i).getIndex() == mapBean.getLableOrdinal()) {
                        infoLabelList.get(i).setEditValue(mapBean.getOriginalLableNumber());
                    }
                }
            }
        }

        carLabelRv.setLayoutManager(new LinearLayoutManager(mActivity));
        contentAdapter = new LabelAdapter(infoLabelList);
        carLabelRv.setAdapter(contentAdapter);
        contentAdapter.setOnItemClickListener(new LabelAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, String name) {
                contentPosition = position;

                scan(name);
            }
        });
    }
    private boolean isSelectAlbum = false;//是否从相册选取
    private void initPhotoRv(InfoBean infoBean) {
        PhotoConfigBean configBean = ConfigUtil.getPhotoConfig();
        if (configBean == null) {
            return;
        }


        /*默认1不开启，2开启*/
        int albumInt = configBean.getIsEnableAlbum();
        if(albumInt == 2){
            isSelectAlbum =true;
        }else {
            isSelectAlbum =false;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        carPhotoRv.setLayoutManager(linearLayoutManager);


        photoList = new ArrayList<>();
        if (configBean != null) {
            for (PhotoConfigBean.PhotoTypeInfoListBean photoBean : configBean.getPhotoTypeInfoList()) {
                if (photoBean.isIsValid()) {
                    if (infoBean.getPhotoList() != null && infoBean.getPhotoList().size() > 0) {

                        for (InfoBean.PhotoListBean infoListBean : infoBean.getPhotoList()) {

                            if (infoListBean.getIndex() == photoBean.getPhotoIndex()) {
                                if (!TextUtils.isEmpty(infoListBean.getPhoto())) {
                                    photoBean.setHaveDrawable(true);
                                }
                                photoBean.setChagePhotoId(infoListBean.getPhoto());
                                photoBean.setPhotoId(infoListBean.getPhoto());
                            }
                        }


                    }
                    photoList.add(photoBean);
                }
            }

        }

        photoAdapter = new PhotoAdapter(mActivity, photoList);
        carPhotoRv.setAdapter(photoAdapter);
        photoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                photoPosition = position;
                photoList.get(position).setChagePhotoId(null);
//                Intent intent = PhotoUtils.getPhotoByCameraForFragment(mActivity);
//                startActivityForResult(intent, PhotoUtils.CAMERA_REQESTCODE);

                if(isSelectAlbum){
                    /*相册*/
                    PhotoUtils.getPhotoByAlbum(mActivity);
                }else {
                    PhotoUtils.getPhotoByCamera(mActivity);
                }
            }
        });
    }

    private void initTitle() {
        BaseActivity.activity.titleBackClickListener(comTitleBack);
        textTitle.setText("信息变更");

    }

    private void scan(String name) {
        startActivityForResult(ScanUtil.ScanForFragment(mActivity, name), ScanUtil.SCANNIN_QR_CODE);
    }

    private boolean isMainClolor = true;//是否选择的是主颜色

    @OnClick({R.id.car_brand, R.id.car_brand_allow, R.id.car_color_main,
            R.id.car_color1_allow, R.id.car_color_minor,
            R.id.car_color2_allow, R.id.car_time,
            R.id.car_time_allow, R.id.button_next, R.id.car_plate_tv, R.id.car_plate_scan})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(mActivity,
                CodeTableActivity.class);
        switch (view.getId()) {
            case R.id.car_brand:
            case R.id.car_brand_allow:
                bundle.putInt(BaseConstants.code_table, 1);
                intent.putExtras(bundle);
                startActivityForResult(intent, CODE_TABLE_BRAND);
                break;
            case R.id.car_color_main:
            case R.id.car_color1_allow:
                isMainClolor = true;
                bundle.putInt(BaseConstants.code_table, 4);
                intent.putExtras(bundle);
                startActivityForResult(intent, CODE_TABLE_COLOR);
                break;
            case R.id.car_color_minor:
            case R.id.car_color2_allow:
                isMainClolor = false;
                bundle.putInt(BaseConstants.code_table, 4);
                intent.putExtras(bundle);
                startActivityForResult(intent, CODE_TABLE_COLOR);
                break;
            case R.id.car_time:
            case R.id.car_time_allow:
                timeDialog.showDialog();
                break;
            case R.id.car_plate_tv:
            case R.id.car_plate_scan:
                contentPosition = -1000;
                scan("车牌号");
                break;
            case R.id.button_next:
                putData();
                break;
        }
    }

    private void putData() {
        for (PhotoConfigBean.PhotoTypeInfoListBean bean : photoList) {
            if (bean.isIsValid()) {
                if (!bean.isHaveDrawable()) {
                    ToastUtil.showWX("请添加" + bean.getPhotoName());
                    return;
                }
            }
        }
        String carPlateStr;
        if (vehicleInfoBean.isVehicleNoScan()) {
            /*扫码*/
            carPlateStr = carPlateTv.getText().toString().trim();
        } else {
            carPlateStr = carPlate.getText().toString().trim().toUpperCase();
        }

        if (TextUtils.isEmpty(carPlateStr)) {
            ToastUtil.showWX("请输入车牌号");
            return;
        }

        String scanNum = ScanUtil.checkPlateNumber(true, carRegular, carPlateStr);
        if (TextUtils.isEmpty(scanNum)) {
            ToastUtil.showWX("输入的车牌有误");
            return;
        }
        String carBrandStr = carBrand.getText().toString().trim();
        if (TextUtils.isEmpty(carBrandStr)) {
            ToastUtil.showWX("请输入车辆品牌");
            return;
        }
        List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean>
                contentAdapterList = contentAdapter.getData();
        for (VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean bean : contentAdapterList) {

            if (bean.isIsValid() && bean.isIsRequired()) {

                if (TextUtils.isEmpty(bean.getEditValue())) {
                    ToastUtil.showWX("请扫描" + bean.getLableName());
                    return;
                }
            }
            /*验证标签是否唯一*/
            if (bean.isExit()) {
                ToastUtil.showWX(bean.getLableName() + "录入数据已存在，请更换");
                return;
            }
        }
        String carFrameStr = carFrame.getText().toString().trim().toUpperCase();
        if (TextUtils.isEmpty(carFrameStr)) {
            ToastUtil.showWX("请输入车架号");
            return;
        }
        if (!"*".equals(carFrameStr)) {

            if (shelvesBean.isIsRequire()) {
                int mSize = carFrameStr.length();
                if (mSize < shelvesBean.getLenMin() || mSize > shelvesBean.getLenMax()) {
                    ToastUtil.showWX("输入的车架号有误");
                    return;
                }
            }
        }
        String carElectricalStr = carElectrical.getText().toString().trim().toUpperCase();
        if (TextUtils.isEmpty(carElectricalStr)) {
            ToastUtil.showWX("请输入电机号");
            return;
        }
        if (!"*".equals(carElectricalStr)) {

            if (engIneBean.isIsRequire()) {
                int mSize = carElectricalStr.length();
                if (mSize < engIneBean.getLenMin() || mSize > engIneBean.getLenMax()) {
                    ToastUtil.showWX("输入的电机号有误");
                    return;
                }
            }
        }
        String carColorMainStr = carColorMain.getText().toString().trim();
        String carColorMinorStr = carColorMinor.getText().toString().trim();
        if (TextUtils.isEmpty(carColorMainStr)) {
            ToastUtil.showWX("请选择主颜色");
            return;
        }
        String carColorTimeStr = carTime.getText().toString().trim();
        if (TextUtils.isEmpty(carColorTimeStr)) {
            ToastUtil.showWX("请选择时间");
            return;
        }
        String carPriceStr = carPrice.getText().toString().trim();

        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterPlate(carPlateStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterBrand(carBrandStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterFrame(carFrameStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterElectrical(carElectricalStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterColor1Id(carColorMainId);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterColor1Name(carColorMainStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterColor2Id(carColorMinorId);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterColor2Name(carColorMinorStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterTime(carColorTimeStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setLableList(contentAdapter.getData());
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setPhotoList(photoAdapter.getData());
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterPrice(carPriceStr);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setRegisterBrandCode(cardBrandType);
        ((ChangeRegisterMainActivity) mActivity).registerPutBean.setId(infoBean.getElectriccars().getId());

        /*车牌是否改变*/
        if (carPlateStr.equals(infoBean.getElectriccars().getPlateNumber())) {

            /*车架是否改变*/
            if (carFrameStr.equals(infoBean.getElectriccars().getShelvesNumber())) {
                ((ChangeRegisterMainActivity) mActivity).setVpCurrentItem(1);
            } else {
                checkShelves(carFrameStr);
            }
        } else {
            /*车牌改变，判断车牌*/
            zProgressHUD.show();
            Map<String, Object> map = new HashMap<>();
            map.put("plateNumber", carPlateStr);
            map.put("subsystemId", systemBaseID);
            mPresenter.checkPlateNumber(((BaseActivity) mActivity).getRequestBody(map));
        }


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == mActivity.RESULT_OK) {

            switch (requestCode) {

                case CODE_TABLE_BRAND:
                    String name = data.getStringExtra(BaseConstants.KEY_NAME);
                    String cardCode = data.getStringExtra(BaseConstants.KEY_VALUE);
                    carBrand.setText(name);
                    cardBrandType = cardCode;
                    break;
                case CODE_TABLE_COLOR:
                    String name1 = data.getStringExtra(BaseConstants.KEY_NAME);
                    String cardCode1 = data.getStringExtra(BaseConstants.KEY_VALUE);
                    if (isMainClolor) {
                        carColorMain.setText(name1);
                        carColorMainId = cardCode1;
                    } else {
                        carColorMinor.setText(name1);
                        carColorMinorId = cardCode1;
                    }
                    break;
//                case PhotoUtils.CAMERA_REQESTCODE:
//
//                    final Bitmap bitmap = PhotoUtils.getResultCameraPhoto();
//                    Bitmap bitmapS = PhotoUtils.compressImageBySmile(bitmap);
//                    Drawable drawable = new BitmapDrawable(bitmapS);
//                    photoList.get(photoPosition).setDrawable(drawable);
//                    photoList.get(photoPosition).setHaveDrawable(true);
//                    photoList.get(photoPosition).setPhotoId(null);
//                    photoList.get(photoPosition).setChagePhotoId(null);
//                    photoAdapter.setNewData(photoList);
//                    ImageSendUtil.sendImage(bitmap, photoPosition, customSendLister);
//                    break;

                case ScanUtil.SCANNIN_QR_CODE:
                    setScanData(data);
                    break;
            }


        }
    }


    /**
     * 注册bux
     */
    private void registerBux() {

        if (this.buxSubscription == null) {
            Subscription mSubscription = RxBus.getDefault().toObservable(BaseConstants.BUX_SEND_CODE, Integer.class)
                    .subscribe(new Action1<Integer>() {
                        @Override
                        public void call(Integer integer) {
                            if (integer == PhotoUtils.CAMERA_REQESTCODE) {//拍照
                                setImageForResult();
                            } else if (integer == PhotoUtils.ALBUM_REQESTCODE) {//相册
                                Intent data = ((RegisterMainActivity) mActivity).resultData;
                                /*拍照*/
                                String capture_type = "";
                                try {
                                    capture_type = (String) data.getExtras().get("capture_type");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if ("camera".equals(capture_type)) {

                                    PhotoUtils.getPhotoByCamera(mActivity);
                                    return;
                                }
                                Uri s1 = Matisse.obtainResult(data).get(0);
                                PhotoUtils.setImageUri(s1);
                                setImageForResult();
                            }

                        }
                    });
            if (this.buxSubscription == null) {
                buxSubscription = new CompositeSubscription();
            }
            buxSubscription.add(mSubscription);
        }
    }

    private void setImageForResult() {
        final Bitmap bitmap = PhotoUtils.getResultCameraPhoto();
        Bitmap bitmapS = PhotoUtils.compressImageBySmile(bitmap);
        Drawable drawable = new BitmapDrawable(bitmapS);
        photoList.get(photoPosition).setDrawable(drawable);
        photoList.get(photoPosition).setHaveDrawable(true);
        photoList.get(photoPosition).setPhotoId(null);
        photoList.get(photoPosition).setChagePhotoId(null);
        photoAdapter.setNewData(photoList);
        ImageSendUtil.sendImage(bitmap, photoPosition, customSendLister);
    }
    CustomSendLister customSendLister = new CustomSendLister() {
        @Override
        public void sendResult(Boolean isSuccess, int position, String photoId) {
            if (isSuccess) {
                photoList.get(position).setPhotoId(photoId);
            } else {
                photoList.get(position).setDrawable(null);
                photoList.get(position).setHaveDrawable(false);
                photoList.get(position).setChagePhotoId(null);
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
            if (contentPosition == -1000) {
                scanNum = ScanUtil.checkPlateNumber(true, carRegular, labelNumber);
                if (TextUtils.isEmpty(scanNum)) {
                    ToastUtil.showWX("输入的车牌有误");
                    return;
                } else {
                    carPlateTv.setText(scanNum);
                }
            } else {
                List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean>
                        contentAdapterList = contentAdapter.getData();
                VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean
                        item = contentAdapterList.get(contentPosition);

                if (ScanUtil.checkTheft(item.getEqType(), item.getLableName(), labelNumber)) {
                    scanNum = labelNumber;
                }

                if (!TextUtils.isEmpty(scanNum)) {
                    contentAdapterList.get(contentPosition).setEditValue(scanNum);
                    contentAdapter.setNewData(contentAdapterList);
                    LabelSendUtil.checkLabel(contentPosition, scanNum, labelLister);
                }
            }


        }
    }

    private CustomSendLister labelLister = new CustomSendLister() {
        @Override
        public void sendResult(Boolean isSuccess, int position, String value) {
            /*标签不唯一*/
            List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean>
                    contentAdapterList = contentAdapter.getData();
            if (!isSuccess) {
                contentAdapterList.get(position).setExit(true);
            } else {
                contentAdapterList.get(position).setExit(false);
            }
            contentAdapter.setNewData(contentAdapterList);
        }
    };


    @Override
    public void checkPlateNumberSuccess() {
        setState(BaseConstants.STATE_SUCCESS);
        String frame = ((ChangeRegisterMainActivity) ChangeRegisterCarFragment.this.getActivity()).registerPutBean.getRegisterFrame();

        /*黑车配置2和不是*进行校验*/
        if (isCheckBlackCar
                && !"*".equals(frame)
                &&!frame.equals(infoBean.getElectriccars().getShelvesNumber())) {
            checkShelves(frame);
        } else {
            zProgressHUD.dismiss();
            ((ChangeRegisterMainActivity) mActivity).setVpCurrentItem(1);
        }

    }

    /**
     * 校验车架号
     * @param frame
     */
    private void checkShelves(String frame) {
        Map<String, Object> map = new HashMap<>();
        map.put("shelvesNumber", frame);
        map.put("subsystemId", systemBaseID);
        mPresenter.checkShelvesNumber(getRequestBody(map));
    }


    @Override
    public void checkPlateNumberFail(String msg) {
        setState(BaseConstants.STATE_SUCCESS);
        showCustomWindowDialog("服务提示", msg, true);
    }

    @Override
    public void getInsuranceSuccess(List<InsuranceBean> list) {

    }

    @Override
    public void getInsuranceFail(String msg) {

    }

    @Override
    public void changeFail(String msg) {

    }

    @Override
    public void changeSuccess(String msg) {

    }

    @Override
    public void checkShelvesNumberFail(String msg) {
        setState(BaseConstants.STATE_SUCCESS);
        zProgressHUD.dismiss();
        ((ChangeRegisterMainActivity) mActivity).setVpCurrentItem(1);
    }

    @Override
    public void checkShelvesNumberSuccess(List<BlcakCarBean> data) {
        zProgressHUD.dismiss();
        ChackBlackCarDialog blackCarDialog = new ChackBlackCarDialog(mActivity);
        blackCarDialog.showCustomWindowDialog(data);
        blackCarDialog.setOnCustomDialogClickListener(new ChackBlackCarDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener() {

                ((ChangeRegisterMainActivity) mActivity).setVpCurrentItem(1);
            }
        });

    }

    @Override
    public void loadingSuccessForData(DdcResult mData) {
        setState(BaseConstants.STATE_SUCCESS);
    }

    @Override
    public void loadingFail(String msg) {
        setState(BaseConstants.STATE_SUCCESS);
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);
    }


    @Override
    protected void submitRequestData() {

    }
}
