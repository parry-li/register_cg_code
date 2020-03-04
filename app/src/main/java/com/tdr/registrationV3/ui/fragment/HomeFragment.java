package com.tdr.registrationV3.ui.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parry.utils.code.SPUtils;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.adapter.HomeAdapter;
import com.tdr.registrationV3.bean.ItemModel;
import com.tdr.registrationV3.bean.OptionsBean;
import com.tdr.registrationV3.bean.VehicleConfigBean;
import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.ui.activity.LoginActivity;
import com.tdr.registrationV3.ui.activity.base.BaseActivity;
import com.tdr.registrationV3.ui.activity.car.CarQueryActivity;
import com.tdr.registrationV3.ui.activity.car.RegisterMainActivity;
import com.tdr.registrationV3.ui.activity.home.PersonageStatisticsActivity;
import com.tdr.registrationV3.ui.fragment.base.NoCacheBaseFragment;
import com.tdr.registrationV3.utils.ActivityUtil;
import com.tdr.registrationV3.utils.ConfigUtil;
import com.tdr.registrationV3.utils.LogUtil;
import com.tdr.registrationV3.view.CustomOptionsDialog;
import com.tdr.registrationV3.view.CustomWindowDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class HomeFragment extends NoCacheBaseFragment implements EasyPermissions.PermissionCallbacks {
    @BindView(R.id.home_city_ll)
    LinearLayout homeCityLl;
    @BindView(R.id.home_register_ll)
    LinearLayout homeRegisterLl;
    @BindView(R.id.home_bxbg_ll)
    LinearLayout homeBxbgLl;
    @BindView(R.id.home_xxbg_ll)
    LinearLayout homeXxbgLl;
    @BindView(R.id.home_grtj_ll)
    LinearLayout homeGrtjLl;
    @BindView(R.id.home_rv)
    RecyclerView homeRv;
    @BindView(R.id.home_city_name)
    TextView homeCityName;

    private static final int PERMISSION_CODE = 124;
    private static final String[] PERMISSION_CONTENT =
            {Manifest.permission.CAMERA, Manifest.permission.VIBRATE};


    private int[] funImgs = {
            R.mipmap.home_clbf, R.mipmap.home_cpbb,
            R.mipmap.home_clgh,
            R.mipmap.homg_fwyq,
            R.mipmap.home_clydj, R.mipmap.home_tj};
    private String[] funTitles = {
            "车辆报废", "车牌补办",
            "车辆过户", "服务延期",
            "服务购买", "备案统计"
    };
    private CustomOptionsDialog optionsDialog;
    private String cityName;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        cityName = SPUtils.getInstance().getString(BaseConstants.City_name);
        homeCityName.setText(cityName);
        initRv();
        initRegisterDialog();
        getPermission();
    }

    private void initRv() {
        List<ItemModel> modelList = new ArrayList<>();
        int size = funImgs.length;
        for (int i = 0; i < size; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.setItemBitResc(funImgs[i]);
            itemModel.setItemName(funTitles[i]);
            itemModel.setRolePower(BaseConstants.funJurisdiction[i]);
            modelList.add(itemModel);
        }
        HomeAdapter homeAdapter = new HomeAdapter(modelList);
        homeRv.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        homeRv.setAdapter(homeAdapter);
        homeRv.setNestedScrollingEnabled(false);
        homeAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(String rolePower, int position) {
                if(!getPermission()){
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("rolePower", rolePower);
                if (BaseConstants.funJurisdiction[1].equals(rolePower)/*车牌补办*/
                        || rolePower.equals(BaseConstants.funJurisdiction[2])/*车辆过户*/
                        || rolePower.equals(BaseConstants.funJurisdiction[0])/*车辆报废*/
                        || rolePower.equals(BaseConstants.funJurisdiction[3])/*服务延期*/
                        || rolePower.equals(BaseConstants.funJurisdiction[4])/*服务购买*/
                        ) {
                    ActivityUtil.goActivityWithBundle(HomeFragment.this.getActivity(), CarQueryActivity.class, bundle);

                } else if (BaseConstants.funJurisdiction[5].equals(rolePower)) {
                    bundle.putString(BaseConstants.data, "");
                    ActivityUtil.goActivity(HomeFragment.this.getActivity(), PersonageStatisticsActivity.class, bundle);
                }

            }
        });

    }


    @OnClick({R.id.home_city_ll, R.id.home_register_ll, R.id.home_bxbg_ll, R.id.home_xxbg_ll, R.id.home_grtj_ll})
    public void onViewClicked(View view) {
        if(!getPermission()){
          return;
        }
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.home_city_ll:

                CustomWindowDialog customWindowDialog = new CustomWindowDialog(HomeFragment.this.getActivity());
                customWindowDialog.showCustomWindowDialog("温馨提示",
                        "您选择的城市是：" + cityName + ",如需切换，请先退出当前账号的登录", false);
                customWindowDialog.setAffirmText("退出登录");
                customWindowDialog.setOnCustomDialogClickListener(new CustomWindowDialog.OnItemClickListener() {
                    @Override
                    public void onCustomDialogClickListener() {
                        BaseActivity.activity.clearDataForLoginOut();
                        ActivityUtil.goActivityAndFinish(HomeFragment.this.getActivity(), LoginActivity.class);
                    }
                });
                break;
            case R.id.home_register_ll://备案登记

                if (optionsDialog != null) {
                    optionsDialog.showDialog();
                } else {
                    goRegisterActivity(1);
                }

                break;
            case R.id.home_bxbg_ll://服务变更
                bundle = new Bundle();
                bundle.putString("rolePower", "insurance_change");
                ActivityUtil.goActivity(HomeFragment.this.getActivity(), CarQueryActivity.class, bundle);
                break;
            case R.id.home_xxbg_ll://信息变更
                bundle.putString("rolePower", "change_register");
                ActivityUtil.goActivity(HomeFragment.this.getActivity(), CarQueryActivity.class, bundle);
                break;
            case R.id.home_grtj_ll:
                bundle.putString(BaseConstants.data, "Personage");
                ActivityUtil.goActivity(HomeFragment.this.getActivity(), PersonageStatisticsActivity.class, bundle);
                break;
        }
    }

    private void initRegisterDialog() {

        try {
            VehicleConfigBean configBean = ConfigUtil.getVehicleConfig();
            final List<OptionsBean> strings = new ArrayList<>();

            if (configBean.getVehicleLicenseInfoList() != null && configBean.getVehicleLicenseInfoList().size() > 0) {
                for (VehicleConfigBean.VehicleLicenseInfoListBean bean :
                        configBean.getVehicleLicenseInfoList()) {
                    if (bean.isIsValid()) {
                        strings.add(new OptionsBean(bean.getVehicleTypeName(), bean.getTypeId()));
                    }

                }

                optionsDialog = new CustomOptionsDialog(HomeFragment.this.getContext(), "请选择车辆类型");
                optionsDialog.setPickerData(strings);
                optionsDialog.setOnCustomClickListener(new CustomOptionsDialog.OnItemClickListener() {
                    @Override
                    public void onCustomDialogClickListener(int options1, int options2, int options3) {
                        goRegisterActivity((int) strings.get(options1).getValue());
                    }

                });
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void goRegisterActivity(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt("car_type", type);
        ActivityUtil.goActivity(HomeFragment.this.getActivity(), RegisterMainActivity.class, bundle);
    }


    @Override
    protected void submitRequestData() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    /**获取权限
     * @return
     */
    @AfterPermissionGranted(PERMISSION_CODE)
    public boolean getPermission() {
        if (EasyPermissions.hasPermissions(this.getContext(), PERMISSION_CONTENT)) {
            LogUtil.i("hasPermissions");

            return true;
        } else {
            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_location_contacts),
                    PERMISSION_CODE,
                    PERMISSION_CONTENT);
            return false;
        }
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        LogUtil.i("onPermissionsGranted");
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        LogUtil.i("onPermissionsDenied");
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setTitle("温馨提示")
                    .setNegativeButton("取消")
                    .setRationale(R.string.permisson_dialog_content)
                    .setPositiveButton("确定")
                    .build().show();

        }
    }


}
