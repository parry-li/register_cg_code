package com.tdr.registration.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parry.utils.code.SPUtils;
import com.tdr.registration.R;
import com.tdr.registration.adapter.StatisticsAdapter;
import com.tdr.registration.bean.StatisticsBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.service.impl.Statisticsmpl;
import com.tdr.registration.service.presenter.StatisticsPresenter;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;
import com.tdr.registration.utils.ActivityUtil;
import com.tdr.registration.utils.TimeUtil;
import com.tdr.registration.utils.ToastUtil;
import com.tdr.registration.view.CustomTimeDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人统计
 */
public class PersonageStatisticsActivity extends LoadingBaseActivity<Statisticsmpl> implements StatisticsPresenter.View {
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.start_time)
    TextView startTimeTV;
    @BindView(R.id.end_time)
    TextView endTimeTV;
    @BindView(R.id.query)
    TextView query;
    @BindView(R.id.base_name)
    TextView baseName;
    @BindView(R.id.base_no)
    TextView baseNo;
    @BindView(R.id.base_unit)
    TextView baseUnit;
    @BindView(R.id.base_car_num)
    TextView baseCarNum;
    @BindView(R.id.no_stolen_unm)
    TextView noStolenUnm;
    @BindView(R.id.stolen_unm)
    TextView stolenUnm;
    @BindView(R.id.plate_change)
    TextView plateChange;
    @BindView(R.id.pf_num)
    TextView pfNum;
    @BindView(R.id.all_money)
    TextView allMoney;
    @BindView(R.id.base_ll)
    LinearLayout baseLl;
    @BindView(R.id.statistics_rv)
    RecyclerView statisticsRv;
    @BindView(R.id.empty_data_rl)
    RelativeLayout emptyDataRl;
    @BindView(R.id.base_unit_arrow)
    ImageView baseUnitArrow;
    @BindView(R.id.new_sales)
    TextView newSales;
    @BindView(R.id.new_Road)
    TextView newRoad;

    private StatisticsAdapter statisticsAdapter;
    private String unitName;
    private String cityCode;
    private String cityName;
    private String lastStartTime;
    private String lastEndTime;
    private CustomTimeDialog timeDialog;
    private String unitNo;
    private String unitType;

    @Override
    protected void initData(Bundle savedInstanceState) {

        initBundle();

        initRv();
        initDialog();
    }

    boolean isPersonage = true;//false 为备案统计 true为个人统计

    private void initBundle() {
        String type = getIntent().getExtras().getString(BaseConstants.data);
        unitName = SPUtils.getInstance().getString(BaseConstants.Login_city_unitName);
        cityCode = SPUtils.getInstance().getString(BaseConstants.Login_city_cityCode);
        cityName = SPUtils.getInstance().getString(BaseConstants.Login_city_unitName);
        unitNo = SPUtils.getInstance().getString(BaseConstants.Login_city_unitNo);
        unitType = SPUtils.getInstance().getInt(BaseConstants.Login_city_unitType) + "";
        if ("Personage".equals(type)) {
            isPersonage = true;
            baseUnitArrow.setVisibility(View.GONE);
            textTitle.setText("个人统计");
        } else {
            textTitle.setText("备案统计");
            isPersonage = false;
            baseUnitArrow.setVisibility(View.VISIBLE);
        }
        baseNo.setText(unitNo);
        baseName.setText(cityName);
        baseUnit.setText(unitName);


    }

    private void initDialog() {
        timeDialog = new CustomTimeDialog(this, false);
        timeDialog.setOnCustomClickListener(new CustomTimeDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener(String value) {
                String currentTime = value;
                if (isStartTime) {
                    value = value + " 00:00:00";
                    if (TimeUtil.timeCompare(value, lastEndTime) != 1) {
                        startTimeTV.setText(currentTime);
                        lastStartTime = value;
                    } else {
                        ToastUtil.showWX("开始时间不能大于结束时间");
                    }

                } else {
                    value = value + " 23:59:59";
                    if (TimeUtil.timeCompare(lastStartTime, value) != 1) {
                        endTimeTV.setText(currentTime);
                        lastEndTime = value;
                    } else {
                        ToastUtil.showWX("开始时间不能大于结束时间");
                    }

                }
            }
        });
    }

    private void initRv() {
        List<StatisticsBean.PolicyListBean> listBeans = new ArrayList<>();
        statisticsRv.setLayoutManager(new LinearLayoutManager(this));
        statisticsAdapter = new StatisticsAdapter(this, listBeans);
        statisticsRv.setAdapter(statisticsAdapter);
    }

    @Override
    protected void initTitle() {
        titleBackClickListener(comTitleBack);
    }

    @Override
    protected void loadData() {
        String formatType = "yyyy-MM-dd";
        String currentTime = TimeUtil.getCurrentTime(formatType);
        String startTime = currentTime + " 00:00:00";
        String endTime = currentTime + " 23:59:59";
        startTimeTV.setText(currentTime);
        endTimeTV.setText(currentTime);
        lastStartTime = startTime;
        lastEndTime = endTime;
        getServiceData();
    }

    private void getServiceData() {
        Map<String, Object> map = new HashMap<>();
        map.put("startTime", lastStartTime);
        map.put("endTime", lastEndTime);
        if (!isPersonage) {
            map.put("unitNo", unitNo);
            map.put("unitType", unitType);
        }
        zProgressHUD.show();
        mPresenter.getStatistics(getRequestBody(map));
    }

    @Override
    protected Statisticsmpl setPresenter() {
        return new Statisticsmpl();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personage_statistics;
    }

    @Override
    protected void submitRequestData() {

    }


    private boolean isStartTime = false;
    private final int SELECT_UNIT = 1009;

    @OnClick({R.id.start_time, R.id.end_time, R.id.query, R.id.base_unit, R.id.base_unit_arrow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_time:
                isStartTime = true;
                timeDialog.showDialog();
                break;
            case R.id.end_time:
                isStartTime = false;
                timeDialog.showDialog();
                break;
            case R.id.query:
                getServiceData();
                break;
            case R.id.base_unit:
            case R.id.base_unit_arrow:
                if (!isPersonage) {

                    ActivityUtil.goActivityForResult(PersonageStatisticsActivity.this, StatisticsUnitActivity.class, SELECT_UNIT);
                }
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_UNIT && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                baseUnit.setText(bundle.getString(BaseConstants.KEY_NAME));
                baseNo.setText(bundle.getString(BaseConstants.KEY_VALUE));
                unitNo = bundle.getString(BaseConstants.KEY_VALUE);
                unitType = bundle.getString(BaseConstants.KEY_VALUE2);
            }
        }
    }

    @Override
    public void loadingSuccessForData(StatisticsBean mData) {
        zProgressHUD.dismiss();
        initServiceData(mData);

    }

    private void initServiceData(StatisticsBean mData) {
        baseCarNum.setText(mData.getTotalNumber() + "");
        stolenUnm.setText(mData.getHasRfidNumber() + "");
        noStolenUnm.setText(mData.getNoRfidNumber() + "");
        plateChange.setText(mData.getPlateChangeNumber() + "");
        pfNum.setText(mData.getHasPolicyNumber() + "");
        allMoney.setText(mData.getTotalAmount() + "");
        statisticsAdapter.setNewData(mData.getPolicyList());
        newSales.setText(mData.getNewVehicleNumber() + "");
        newRoad.setText(mData.getOldVehicleNumber() + "");
        if (mData.getPolicyList() == null || mData.getPolicyList().size() == 0) {
            emptyDataRl.setVisibility(View.VISIBLE);
        } else {
            emptyDataRl.setVisibility(View.GONE);
        }
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
    }


}
