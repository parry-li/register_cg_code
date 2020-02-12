package com.tdr.registration.ui.activity.me;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parry.utils.code.KeyboardUtils;
import com.parry.utils.code.SPUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.tdr.registration.R;
import com.tdr.registration.adapter.InsuranceWaitAdapter;
import com.tdr.registration.bean.InsuranceWaitBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.http.utils.DdcResult;
import com.tdr.registration.service.impl.insurance.InsuranceWaitImpl;
import com.tdr.registration.service.presenter.InsuranceWaitPresenter;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;
import com.tdr.registration.utils.ActivityUtil;
import com.tdr.registration.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InsuranceWaitActivity extends LoadingBaseActivity<InsuranceWaitImpl> implements InsuranceWaitPresenter.View {


    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_search_clear)
    ImageView ivSearchClear;
    @BindView(R.id.tv_search_cancel)
    TextView tvSearchCancel;
    @BindView(R.id.insurance_rv)
    RecyclerView insuranceRv;
    @BindView(R.id.empty_iv)
    ImageView emptyIv;
    @BindView(R.id.empty_tv)
    TextView emptyTv;
    @BindView(R.id.empty_data_rl)
    RelativeLayout emptyDataRl;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private InsuranceWaitBean insuranceWaitBean;
    private InsuranceWaitAdapter waitAdapter;

    @Override
    protected void initData(Bundle savedInstanceState) {

        initRv();

        initRefresh();
        initEditView();
    }

    private boolean isRefresh =true;
    private boolean isSearch =false;
    private void initEditView() {
        tvSearchCancel.setText("搜索");
        tvSearchCancel.setVisibility(View.GONE);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                keyName = editable.toString().trim();
                if (!TextUtils.isEmpty(editable)) {
                    tvSearchCancel.setVisibility(View.VISIBLE);
                } else {
                    tvSearchCancel.setVisibility(View.GONE);
                }
            }
        });

        ivSearchClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setText("");
            }
        });
        tvSearchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager = 1;
                zProgressHUD.show();
                isSearch=true;
                getInsuranceData(keyName);
            }
        });

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    KeyboardUtils.hideSoftInput(InsuranceWaitActivity.this);
                    keyName = etSearch.getText().toString().trim();
                    if (TextUtils.isEmpty(keyName)) {
                        ToastUtil.showWX("搜索栏不能为空！");
                    } else {
                        //搜索
                        isSearch=true;
                        pager = 1;
                        zProgressHUD.show();
                        getInsuranceData(keyName);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private String keyName;

    private void initRefresh() {
        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh =false;
                isSearch =false;
                getInsuranceData("");
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pager = 1;
                isRefresh =true;
                isSearch =false;
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
                SPUtils.getInstance().put(BaseConstants.data,beanJson);
                ActivityUtil.goActivity(InsuranceWaitActivity.this, InsuranceWaitChangeActivity.class);
            }
        });

        waitAdapter.setOnItemPushClickListener(new InsuranceWaitAdapter.OnItemPushClickListener() {
            @Override
            public void onItemPushClickListener(InsuranceWaitBean insuranceWaitItem) {

                insuranceWaitBean = insuranceWaitItem;
                showSubmitRequestDialog("确定重新投保？");
            }
        });
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

    private void getInsuranceData(String key) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", pager);
        map.put("size", 10);
        map.put("keywords", key);
        mPresenter.getInsurance(getRequestBody(map));
    }

    @Override
    protected InsuranceWaitImpl setPresenter() {
        return new InsuranceWaitImpl();
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

        mPresenter.pushAgain(getRequestBody(map));
    }

    @Override
    public void pushAgainSuccess(String msg) {

    }

    @Override
    public void pushAgainFail(String msg) {

    }

    @Override
    public void loadingSuccessForData(DdcResult<List<InsuranceWaitBean>> mData) {
        if(mData.getData().size()>0){
            emptyDataRl.setVisibility(View.GONE);
            if(pager==1){
                waitAdapter.setNewData(mData.getData());
            }else {
                waitAdapter.addData(mData.getData());
            }
            pager++;
        }else {
            if(pager==1){
                emptyDataRl.setVisibility(View.VISIBLE);
            }
//            if( !isSearch){
//                etSearch.setEnabled(false);
//            }

        }
        tvSearchCancel.setVisibility(View.GONE);
        zProgressHUD.dismiss();
        if(isRefresh){
            refresh.finishRefresh();
        }else {
            refresh.finishLoadmore();
        }
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
        if(pager==1) {
            emptyDataRl.setVisibility(View.VISIBLE);
        }
        if(isRefresh){
            refresh.finishRefresh();
        }else {
            refresh.finishLoadmore();
        }
    }


}
