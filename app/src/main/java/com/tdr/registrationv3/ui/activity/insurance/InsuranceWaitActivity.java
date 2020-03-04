package com.tdr.registrationv3.ui.activity.insurance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.adapter.InsuranceWaitAdapter;
import com.tdr.registrationv3.bean.InsuranceWaitBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.impl.insurance.InsuranceWaitImpl;
import com.tdr.registrationv3.service.presenter.InsuranceWaitPresenter;
import com.tdr.registrationv3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationv3.utils.ActivityUtil;
import com.tdr.registrationv3.view.SearchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class InsuranceWaitActivity extends LoadingBaseActivity<InsuranceWaitImpl> implements InsuranceWaitPresenter.View {


    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.insurance_rv)
    RecyclerView insuranceRv;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.empty_iv)
    ImageView emptyIv;
    @BindView(R.id.empty_tv)
    TextView emptyTv;
    @BindView(R.id.empty_data_rl)
    RelativeLayout emptyDataRl;
    private InsuranceWaitBean insuranceWaitBean;
    private InsuranceWaitAdapter waitAdapter;
    private String lastKeyWord;
    private int againPosition;

    private final int GO_TO_CHANGE_ACTIVITY = 1020;

    @Override
    protected void initData(Bundle savedInstanceState) {

        initRv();

        initRefresh();
        initEditView();
    }


    private boolean isRefresh = true;
    private boolean isSearch = false;

    private void initEditView() {
        searchView.setSearchViewListener(new SearchView.SearchViewListener() {
            @Override
            public void onRefreshAutoComplete(String text) {

            }

            @Override
            public void onSearch(String text) {
                //搜索
                isSearch = true;
                pager = 1;
                zProgressHUD.show();
                lastKeyWord = text;
                getInsuranceData(text);
            }

            @Override
            public void onCancel() {
                lastKeyWord = "";
                pager = 1;
                zProgressHUD.show();
                isSearch = true;
                getInsuranceData("");
            }
        });


    }

    private String keyName;

    private void initRefresh() {
        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh = false;
                isSearch = false;
                getInsuranceData("");
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pager = 1;
                isRefresh = true;
                isSearch = false;
                getInsuranceData("");
            }
        });
    }

    private void initRv() {
        insuranceRv.setLayoutManager(new LinearLayoutManager(this));
        List<InsuranceWaitBean> waitBeans = new ArrayList<>();
        waitAdapter = new InsuranceWaitAdapter(this, waitBeans);
        insuranceRv.setAdapter(waitAdapter);
        waitAdapter.setOnItemClickListener(new InsuranceWaitAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(String msg) {
                showCustomWindowDialog("温馨提示", msg, false, true);
            }
        });

        waitAdapter.setOnItemChangeClickListener(new InsuranceWaitAdapter.OnItemChangeClickListener() {
            @Override
            public void onChangeItemClickListener(InsuranceWaitBean insuranceWaitBean) {

                String beanJson = new Gson().toJson(insuranceWaitBean);
                SPUtils.getInstance().put(BaseConstants.data, beanJson);
                ActivityUtil.goActivityForResult(InsuranceWaitActivity.this, InsuranceWaitChangeActivity.class,GO_TO_CHANGE_ACTIVITY);
            }
        });

        waitAdapter.setOnItemPushClickListener(new InsuranceWaitAdapter.OnItemPushClickListener() {
            @Override
            public void onItemPushClickListener(int position, InsuranceWaitBean insuranceWaitItem) {

                againPosition = position;
                insuranceWaitBean = insuranceWaitItem;
                showSubmitRequestDialog("确定重新投保？");
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GO_TO_CHANGE_ACTIVITY&&resultCode ==RESULT_OK){
            removeAdapterData();
        }
    }

    @Override
    protected void initTitle() {
        titleBackClickListener(comTitleBack);
        textTitle.setText("待投保");
    }

    @Override
    protected void loadData() {
        zProgressHUD.show();
        getInsuranceData("");

    }

    private int pager = 1;

    @Override
    protected InsuranceWaitImpl setPresenter() {
        return new InsuranceWaitImpl();
    }

    private void getInsuranceData(String key) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", pager);
        map.put("size", 10);
        map.put("keywords", key);
        mPresenter.getInsurance(getRequestBody(map));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_instrance_wait;
    }

    @Override
    protected void submitRequestData() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", insuranceWaitBean.getId());
        map.put("plateNumber", insuranceWaitBean.getPlateNumber());
        map.put("vehicleBrand", insuranceWaitBean.getVehicleBrand());
        map.put("vehicleBrandName", insuranceWaitBean.getVehicleBrandName());
        map.put("colorId", insuranceWaitBean.getColorId());
        map.put("colorName", insuranceWaitBean.getColorName());
        map.put("colorSecondId", insuranceWaitBean.getColorSecondId());
        map.put("colorSecondName", insuranceWaitBean.getColorSecondName());
        map.put("engineNumber", insuranceWaitBean.getEngineNumber());
        map.put("shelvesNumber", insuranceWaitBean.getShelvesNumber());
        map.put("ownerName", insuranceWaitBean.getOwnerName());
        map.put("cardId", insuranceWaitBean.getCardId());
        map.put("cardType", insuranceWaitBean.getCardType());
        map.put("cardName", insuranceWaitBean.getCardName());
        map.put("phone1", insuranceWaitBean.getPhone1());
        map.put("residentAddress", insuranceWaitBean.getResidentAddress());

        zProgressHUD.show();
        mPresenter.pushAgain(getRequestBody(map));
    }

    @Override
    public void pushAgainSuccess(String msg) {

        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);

        removeAdapterData();

    }

    private void removeAdapterData() {
        waitAdapter.remove(againPosition);
        if(waitAdapter.getData().size() == 0){
            emptyDataRl.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void pushAgainFail(String msg) {
        zProgressHUD.dismiss();
        showCustomWindowDialog("服务提示", msg, false, true);
    }

    @Override
    public void loadingSuccessForData(DdcResult<List<InsuranceWaitBean>> mData) {
        if (mData.getData().size() > 0) {
            emptyDataRl.setVisibility(View.GONE);
            if (pager == 1) {
                waitAdapter.setNewData(mData.getData());
            } else {
                waitAdapter.addData(mData.getData());
            }
            pager++;
        } else {
            if (pager == 1) {
                emptyDataRl.setVisibility(View.VISIBLE);
            }
//            if( !isSearch){
//                etSearch.setEnabled(false);
//            }

        }

        zProgressHUD.dismiss();
        if (isRefresh) {
            refresh.finishRefresh();
        } else {
            refresh.finishLoadmore();
        }
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
        if (pager == 1) {
            emptyDataRl.setVisibility(View.VISIBLE);
        }
        if (isRefresh) {
            refresh.finishRefresh();
        } else {
            refresh.finishLoadmore();
        }
    }

}
