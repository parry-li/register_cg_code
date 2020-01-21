package com.tdr.registration.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.parry.utils.code.SPUtils;
import com.tdr.registration.R;
import com.tdr.registration.adapter.HomeAdapter;
import com.tdr.registration.bean.ItemModel;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.ui.activity.LoginActivity;
import com.tdr.registration.ui.activity.car.CarQueryActivity;
import com.tdr.registration.ui.fragment.base.NoCacheBaseFragment;
import com.tdr.registration.utils.ActivityUtil;

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


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        List<ItemModel> modelList = new ArrayList<>();
        int size = funImgs.length;
        for (int i = 0; i < size; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.setItemBitResc(funImgs[i]);
            itemModel.setItemName(funTitles[i]);
            modelList.add(itemModel);
        }
        HomeAdapter homeAdapter = new HomeAdapter(modelList);
        homeRv.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        homeRv.setAdapter(homeAdapter);
        homeRv.setNestedScrollingEnabled(false);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position == 1) {
                    /*车牌补办*/
                    ActivityUtil.goActivity(HomeFragment.this.getActivity(), CarQueryActivity.class);
                }
            }
        });

    }


    @OnClick({R.id.home_city_ll, R.id.home_register_ll, R.id.home_bxbg_ll, R.id.home_xxbg_ll, R.id.home_grtj_ll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_city_ll:
                SPUtils.getInstance().put(BaseConstants.token,"");
                ActivityUtil.goActivityAndFinish(HomeFragment.this.getActivity(), LoginActivity.class);
                break;
            case R.id.home_register_ll:
                break;
            case R.id.home_bxbg_ll:
                break;
            case R.id.home_xxbg_ll:
                break;
            case R.id.home_grtj_ll:
                break;
        }
    }
}
