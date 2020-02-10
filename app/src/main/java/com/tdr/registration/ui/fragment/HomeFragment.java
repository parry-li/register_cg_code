package com.tdr.registration.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registration.R;
import com.tdr.registration.adapter.HomeAdapter;
import com.tdr.registration.bean.ItemModel;
import com.tdr.registration.bean.OptionsBean;
import com.tdr.registration.bean.VehicleConfigBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.ui.activity.LoginActivity;
import com.tdr.registration.ui.activity.base.BaseActivity;
import com.tdr.registration.ui.activity.car.CarInsuranceActivity;
import com.tdr.registration.ui.activity.car.CarQueryActivity;
import com.tdr.registration.ui.activity.car.CarTransferActivity;
import com.tdr.registration.ui.activity.car.RegisterMainActivity;
import com.tdr.registration.ui.fragment.base.NoCacheBaseFragment;
import com.tdr.registration.utils.ActivityUtil;
import com.tdr.registration.utils.ConfigUtil;
import com.tdr.registration.utils.ToastUtil;
import com.tdr.registration.view.CustomOptionsDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends NoCacheBaseFragment {
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


    private int[] funImgs = {
            R.mipmap.home_clbf, R.mipmap.home_cpbb,
            R.mipmap.home_clgh, R.mipmap.home_clbk,
            R.mipmap.home_clfh, R.mipmap.homg_fwyq,
            R.mipmap.home_clydj, R.mipmap.home_tj,
            R.mipmap.home_ydkcx, R.mipmap.home_ydjtj,
            R.mipmap.home_xdcba, R.mipmap.home_xdccx,
            R.mipmap.home_clch};
    private String[] funTitles = {
            "车辆报废", "车牌补办",
            "车辆过户", "车辆布控",
            "车辆发还", "服务延期",
            "车辆预登记", "备案统计",
            "预登记查询", "预登记统计",
            "蓄电池备案", "蓄电池查询",
            "车辆查询"
    };
    private CustomOptionsDialog optionsDialog;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        initRv();
        initRegisterDialog();

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
                Bundle bundle = new Bundle();
                bundle.putString("rolePower", rolePower);
                if (BaseConstants.funJurisdiction[1].equals(rolePower)/*车牌补办*/
                        || rolePower.equals(BaseConstants.funJurisdiction[2])/*车辆过户*/
                        || rolePower.equals(BaseConstants.funJurisdiction[0])/*车辆报废*/
                        ) {
                    ActivityUtil.goActivityWithBundle(HomeFragment.this.getActivity(), CarQueryActivity.class, bundle);

                }

            }
        });

    }


    @OnClick({R.id.home_city_ll, R.id.home_register_ll, R.id.home_bxbg_ll, R.id.home_xxbg_ll, R.id.home_grtj_ll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_city_ll:
                BaseActivity.activity.clearDataForLoginOut();
                ActivityUtil.goActivityAndFinish(HomeFragment.this.getActivity(), LoginActivity.class);
                break;
            case R.id.home_register_ll://备案登记

                optionsDialog.showDialog();
                break;
            case R.id.home_bxbg_ll:
                ActivityUtil.goActivity(HomeFragment.this.getActivity(), CarInsuranceActivity.class);
                break;
            case R.id.home_xxbg_ll://信息变更
                Bundle bundle = new Bundle();
                bundle.putString("rolePower", "changeRegister");
                ActivityUtil.goActivity(HomeFragment.this.getActivity(), CarQueryActivity.class, bundle);
                break;
            case R.id.home_grtj_ll:
                break;
        }
    }

    private void initRegisterDialog() {

        try {
            VehicleConfigBean configBean = ConfigUtil.getVehicleConfig();
            List<OptionsBean> strings = new ArrayList<>();

            for (VehicleConfigBean.VehicleLicenseInfoListBean bean :
                    configBean.getVehicleLicenseInfoList()) {
                /* 当前调试后期加上*/
                /* 当前调试后期加上*/
                /* 当前调试后期加上*/
                /* 当前调试后期加上*/
                /* 当前调试后期加上*/
                /* 当前调试后期加上*/
                /* 当前调试后期加上*/
                /* 当前调试后期加上*/

//                if (bean.isIsValid()) {
                strings.add(new OptionsBean(bean.getVehicleTypeName(), bean.getTypeId()));
//                }

            }
            optionsDialog = new CustomOptionsDialog(HomeFragment.this.getContext(), strings);
            optionsDialog.setOnCustomClickListener(new CustomOptionsDialog.OnItemClickListener() {
                @Override
                public void onCustomDialogClickListener(int position, OptionsBean optionsBean) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("car_type", (int) optionsBean.getValue());
                    ActivityUtil.goActivity(HomeFragment.this.getActivity(), RegisterMainActivity.class, bundle);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
