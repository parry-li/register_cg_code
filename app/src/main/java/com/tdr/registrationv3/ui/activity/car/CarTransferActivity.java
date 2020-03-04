package com.tdr.registrationv3.ui.activity.car;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.tdr.registrationv3.adapter.PhotoAdapter;
import com.tdr.registrationv3.bean.CarCheckBean;
import com.tdr.registrationv3.bean.PhotoConfigBean;
import com.tdr.registrationv3.bean.PhotoListBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.listener.CustomSendLister;
import com.tdr.registrationv3.service.impl.car.CarTransferImpl;
import com.tdr.registrationv3.service.presenter.CarTransferPresenter;
import com.tdr.registrationv3.ui.activity.CodeTableActivity;
import com.tdr.registrationv3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationv3.utils.ActivityUtil;
import com.tdr.registrationv3.utils.ConfigUtil;
import com.tdr.registrationv3.utils.ImageSendUtil;
import com.tdr.registrationv3.utils.PhotoUtils;
import com.tdr.registrationv3.utils.RegularUtil;
import com.tdr.registrationv3.utils.ToastUtil;
import com.tdr.registrationv3.utils.UIUtils;
import com.zhihu.matisse.Matisse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class CarTransferActivity extends LoadingBaseActivity<CarTransferImpl> implements CarTransferPresenter.View {
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
    @BindView(R.id.transfer_brand)
    TextView transferBrand;
    @BindView(R.id.transfer_color)
    TextView transferColor;
    @BindView(R.id.transfer_phone)
    TextView transferPhone;
    @BindView(R.id.transfer_ower)
    TextView transferOwer;
    @BindView(R.id.transfer_card)
    TextView transferCard;
    @BindView(R.id.transfer_name)
    EditText transferName;
    @BindView(R.id.transfer_card_type)
    TextView transferCardType;
    @BindView(R.id.transfer_new_cardnum)
    EditText transferNewCardnum;
    @BindView(R.id.transfer_rv)
    RecyclerView transferRv;
    @BindView(R.id.transfer_new_phone)
    EditText transferNewPhone;
    @BindView(R.id.transfer_new_phone2)
    EditText transferNewPhone2;
    @BindView(R.id.transfer_addr)
    EditText transferAddr;
    @BindView(R.id.transfer_reason)
    EditText transferReason;
    @BindView(R.id.transfer_bt)
    TextView transferBt;
    private CarCheckBean checkBean;
    private List<PhotoConfigBean.PhotoTypeInfoListBean> photoList;
    private PhotoAdapter photoAdapter;
    private int photoPosition;
    private static final int CODE_TABLE_PICK = 1000;
    private String cardCode;

    @Override
    protected void initTitle() {
        textTitle.setText("车辆过户");
        titleBackClickListener(comTitleBack);
        cardCode = "1";
        transferCardType.setText("身份证");

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected CarTransferImpl setPresenter() {
        return new CarTransferImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        UIUtils.setEditTextUpperCase(transferNewCardnum);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            checkBean = (CarCheckBean) bundle.getSerializable(BaseConstants.data);

            initCheckData();
            initPhotoRv();
        }
    }

    private void initCheckData() {
        changePlate.setText(checkBean.getPlateNumber());
        transferBrand.setText(checkBean.getVehicleBrandStr());
        transferColor.setText(checkBean.getColorIdStr());
        transferPhone.setText(checkBean.getPhone1());
        transferOwer.setText(checkBean.getOwnerName());
        transferCard.setText(checkBean.getCardId());
    }

    private boolean isSelectAlbum = false;//是否从相册选取
    private void initPhotoRv() {
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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        transferRv.setLayoutManager(linearLayoutManager);
        photoList = new ArrayList<>();
        if (configBean != null) {
            for (PhotoConfigBean.PhotoTypeInfoListBean photoBean : configBean.getPhotoTypeInfoList()) {
                if (photoBean.isIsValid()) {
                    if (photoBean.getPhotoIndex() == 2) {
                        photoBean.setIsRequire(true);
                    } else {
                        photoBean.setIsRequire(false);
                    }
                    photoList.add(photoBean);
                }
            }

        }

        photoAdapter = new PhotoAdapter(CarTransferActivity.this, photoList);
        transferRv.setAdapter(photoAdapter);
        photoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                photoPosition = position;
//                PhotoUtils.getPhotoByCamera(CarTransferActivity.this);
                if(isSelectAlbum){
                    /*相册*/
                    PhotoUtils.getPhotoByAlbum(CarTransferActivity.this);
                }else {
                    PhotoUtils.getPhotoByCamera(CarTransferActivity.this);
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == PhotoUtils.CAMERA_REQESTCODE) {
//
//            final Bitmap bitmap = PhotoUtils.getResultCameraPhoto();
//            Bitmap bitmapS = PhotoUtils.compressImageBySmile(bitmap);
//            Drawable drawable = new BitmapDrawable(bitmapS);
//            photoList.get(photoPosition).setDrawable(drawable);
//            photoList.get(photoPosition).setPhotoId(null);
//            photoAdapter.setNewData(photoList);
//            ImageSendUtil.sendImage(bitmap, photoPosition, customSendLister);
//        } else if (resultCode == RESULT_OK && requestCode == CODE_TABLE_PICK) {
//            String name = data.getStringExtra(BaseConstants.KEY_NAME);
//            cardCode = data.getStringExtra(BaseConstants.KEY_VALUE);
//            transferCardType.setText(name);
//        }


        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CODE_TABLE_PICK:
                    String name = data.getStringExtra(BaseConstants.KEY_NAME);
                    cardCode = data.getStringExtra(BaseConstants.KEY_VALUE);
                    transferCardType.setText(name);
                    break;
                case PhotoUtils.CAMERA_REQESTCODE:
                    setImageForResult();
                    break;
                case PhotoUtils.ALBUM_REQESTCODE://相册

                    /*拍照*/
                    String capture_type = "";
                    try {
                        capture_type = (String) data.getExtras().get("capture_type");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if ("camera".equals(capture_type)) {
                        PhotoUtils.getPhotoByCamera(CarTransferActivity.this);
                        return;
                    }
                    Uri s1 = Matisse.obtainResult(data).get(0);
                    PhotoUtils.setImageUri(s1);
                    setImageForResult();
                    break;
            }
        }


    }

    private void setImageForResult() {
        final Bitmap bitmap = PhotoUtils.getResultCameraPhoto();
        Bitmap bitmapS = PhotoUtils.compressImageBySmile(bitmap);
        Drawable drawable = new BitmapDrawable(bitmapS);
        photoList.get(photoPosition).setDrawable(drawable);
        photoList.get(photoPosition).setPhotoId(null);
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
            }
            photoAdapter.setNewData(photoList);
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_car_transfer;
    }

    @Override
    protected void submitRequestData() {
        zProgressHUD.show();
        mPresenter.carCTransfer(getSubmitBoby());
    }

    @OnClick({R.id.transfer_card_type, R.id.transfer_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.transfer_card_type:
                Bundle bundle = new Bundle();
                bundle.putInt(BaseConstants.code_table, 6);
                ActivityUtil.goActivityForResultWithBundle(CarTransferActivity.this, CodeTableActivity.class, bundle, CODE_TABLE_PICK);
                break;
            case R.id.transfer_bt:
                sendData();
                break;
        }
    }


    private void sendData() {
        String name = transferName.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showWX("请输入姓名");
            return;
        }
        String cardNum = transferNewCardnum.getText().toString().trim().toUpperCase();
        if (TextUtils.isEmpty(cardNum)) {
            ToastUtil.showWX("请输入证件号码");
            return;
        }
        if (cardCode.equals("1")) {
            if (!RegularUtil.isIDCard18(cardNum)) {
                ToastUtil.showWX("输入的证件号码有误");
                return;
            }
        }
        String phone = transferNewPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showWX("请输入联系手机");
            return;
        }
        if (!RegularUtil.isMobileExact(phone)) {
            ToastUtil.showWX("输入的联系手机有误");
            return;
        }
        String phone2 = transferNewPhone2.getText().toString().trim();
        if (!TextUtils.isEmpty(phone2)) {
            if (!RegularUtil.isMobileExact(phone)) {
                ToastUtil.showWX("输入的联备用号码有误");
                return;
            }
        }
        String addr = transferAddr.getText().toString().trim();
        if (TextUtils.isEmpty(addr)) {
            ToastUtil.showWX("请输入现住址");
            return;
        }

        String reason = transferReason.getText().toString().trim();
        String transferCardTypeStr = transferCardType.getText().toString().trim();
        Map<String, Object> map = new HashMap<>();
        map.put("electriccarsId", checkBean.getId());
        map.put("plateNumber", checkBean.getPlateNumber());
        map.put("ownerName", name);
        map.put("cardType", cardCode);
        map.put("cardId", cardNum);
        map.put("residentAddress", addr);
        map.put("cardName", transferCardTypeStr);
        map.put("phone1", phone);
        map.put("phone2", phone2);
        map.put("reason", reason);
        map.put("transferSource", "5");
        List<PhotoListBean> listBeans = new ArrayList<>();
        List<PhotoConfigBean.PhotoTypeInfoListBean> adapterData = photoAdapter.getData();
        for (PhotoConfigBean.PhotoTypeInfoListBean bean : adapterData) {
            if (!TextUtils.isEmpty(bean.getPhotoId())) {
                PhotoListBean photoListBean = new PhotoListBean();
                photoListBean.setPhotoType(bean.getPhotoType());
                photoListBean.setIndex(bean.getPhotoIndex());
                photoListBean.setPhoto(bean.getPhotoId());
                listBeans.add(photoListBean);
            } else {
                if (bean.getDrawable() != null) {
                    ToastUtil.showWX(bean.getPhotoName() + "正在上传");
                    return;
                } else {
                    if (bean.isIsRequire()) {
                        ToastUtil.showWX(bean.getPhotoName() + "未添加");
                        return;
                    }

                }
            }

        }
        if (listBeans != null && listBeans.size() > 0) {
            map.put("photoArray", listBeans);
        }

        showSubmitRequestDialog(map);

    }

    @Override
    public void loadingSuccessForData(DdcResult mData) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", "车辆过户成功", true);
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
    }


}
