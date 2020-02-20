package com.tdr.registration.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parry.utils.code.SPUtils;
import com.tdr.registration.R;
import com.tdr.registration.adapter.UnitAdapter;
import com.tdr.registration.bean.UnitBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.service.impl.car.UnitImpl;
import com.tdr.registration.service.presenter.UnitPresenter;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;
import com.tdr.registration.view.SearchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticsUnitActivity extends LoadingBaseActivity<UnitImpl> implements UnitPresenter.View {
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.unit_rv)
    RecyclerView unitRv;
    @BindView(R.id.empty_data_rl)
    RelativeLayout emptyDataRl;
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.all_tv)
    TextView allTv;

    private UnitAdapter unitAdapter;

    private List<UnitBean.ChildrenListBeanX> unitDta = new ArrayList<>();

    @Override
    public void loadingSuccessForData(UnitBean mData) {

        if (mData != null) {

            emptyDataRl.setVisibility(View.GONE);
            UnitBean.ChildrenListBeanX firstChild = new UnitBean.ChildrenListBeanX();
            firstChild.setUnitName(mData.getUnitName());
            firstChild.setUnitNo(mData.getUnitNo());
            firstChild.setUnitType(mData.getUnitType());
            unitDta.add(firstChild);
            if(mData.getChildrenList()!=null&&mData.getChildrenList().size()>0){
                for (UnitBean.ChildrenListBeanX secondBean : mData.getChildrenList()) {
                    UnitBean.ChildrenListBeanX secondChild = new UnitBean.ChildrenListBeanX();
                    secondChild.setUnitName(secondBean.getUnitName());
                    secondChild.setUnitNo(secondBean.getUnitNo());
                    secondChild.setUnitType(secondBean.getUnitType());
                    unitDta.add(secondChild);
                    if(secondBean.getChildrenList()!=null&&secondBean.getChildrenList().size()>0) {
                        for (UnitBean.ChildrenListBeanX.ChildrenListBean thirdBean : secondBean.getChildrenList()) {
                            UnitBean.ChildrenListBeanX thirdChild = new UnitBean.ChildrenListBeanX();
                            thirdChild.setUnitName(thirdBean.getUnitName());
                            thirdChild.setUnitNo(thirdBean.getUnitNo());
                            thirdChild.setUnitType(thirdBean.getUnitType());
                            unitDta.add(thirdChild);
                        }
                    }
                }
            }

            unitAdapter.setNewData(unitDta);
        } else {
            emptyDataRl.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void loadingFail(String msg) {
        emptyDataRl.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        List<UnitBean.ChildrenListBeanX> unitBeans = new ArrayList<>();
        unitAdapter = new UnitAdapter(unitBeans);
        unitRv.setLayoutManager(new LinearLayoutManager(this));
        unitRv.setAdapter(unitAdapter);
        unitAdapter.setOnItemClickListener(new UnitAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(UnitBean.ChildrenListBeanX item) {
                Intent data = new Intent();
                data.putExtra(BaseConstants.KEY_NAME, item.getUnitName());
                data.putExtra(BaseConstants.KEY_VALUE, item.getUnitNo());
                data.putExtra(BaseConstants.KEY_VALUE2, item.getUnitType() + "");
                setResult(RESULT_OK, data);
                finish();
            }
        });

        searchView.setSearchViewListener(new SearchView.SearchViewListener() {
            @Override
            public void onRefreshAutoComplete(String text) {

            }

            @Override
            public void onSearch(String text) {

                doSearch(text);
            }

            @Override
            public void onCancel() {
                unitAdapter.setNewData(unitDta);
                allTv.setVisibility(View.VISIBLE);
                emptyDataRl.setVisibility(View.GONE);
            }
        });
    }

    private void doSearch(String text) {
        List<UnitBean.ChildrenListBeanX> searchData = new ArrayList<>();
        for (UnitBean.ChildrenListBeanX unitBean : unitDta) {

            if (unitBean.getUnitName().contains(text)) {
                searchData.add(unitBean);
            }
        }
        if (searchData.size() == 0) {
            emptyDataRl.setVisibility(View.VISIBLE);
        } else {
            emptyDataRl.setVisibility(View.GONE);
        }
        allTv.setVisibility(View.GONE);
        unitAdapter.setNewData(searchData);

    }

    @Override
    protected void initTitle() {
        titleBackClickListener(comTitleBack);
    }

    @Override
    protected void loadData() {
        String cityCode = SPUtils.getInstance().getString(BaseConstants.Login_city_cityCode);
        Map<String, Object> map = new HashMap<>();
        map.put("unitNo", cityCode);
        mPresenter.getUnit(getRequestBody(map));
    }

    @Override
    protected UnitImpl setPresenter() {
        return new UnitImpl();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_unit;
    }

    @Override
    protected void submitRequestData() {

    }


}
