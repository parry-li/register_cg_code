package com.tdr.registration.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.tdr.registration.R;
import com.tdr.registration.bean.CityBean;
import com.tdr.registration.constants.BaseConstants;
import com.tdr.registration.service.impl.city.CityImpl;
import com.tdr.registration.service.presenter.CityPresenter;
import com.tdr.registration.ui.activity.base.LoadingBaseActivity;
import com.tdr.registration.utils.Util;
import com.tdr.registration.view.CityPicker.adapter.CityListAdapter;
import com.tdr.registration.view.CityPicker.adapter.ResultListAdapter;
import com.tdr.registration.view.CityPicker.model.City;
import com.tdr.registration.view.CityPicker.view.SideLetterBar;
import com.tdr.registration.view.CustomOptionsDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Author parry
 */
public class CityPickerActivity extends LoadingBaseActivity<CityImpl> implements CityPresenter.View, View.OnClickListener {
    private ListView mListView;
    private ListView mResultListView;
    private SideLetterBar mLetterBar;
    private EditText searchBox;
    private ImageView clearBtn;
    private TextView cancelBtn;
    private ViewGroup emptyView;

    private CityListAdapter mCityAdapter;
    private ResultListAdapter mResultAdapter;
    private List<City> mAllCities;
    private List<CityBean> mResultCities;
    //    private DBManager dbManager;
    private List<CityBean> cityList;
    private TextView noData;


    @Override
    protected int getLayoutId() {
        return R.layout.cp_activity_city_list;
    }


    @Override
    protected void initData(Bundle savedInstanceState) {


    }

    @Override
    protected void initTitle() {
        noData = (TextView) findViewById(R.id.no_data);
        emptyView = (ViewGroup) findViewById(R.id.empty_view);
    }

    @Override
    protected void loadData() {
        mPresenter.getCity();
    }

    @Override
    protected CityImpl setPresenter() {
        return new CityImpl();
    }


    private void initData() {
//        dbManager = new DBManager(this);
//        dbManager.copyDBFile();

        mCityAdapter = new CityListAdapter(this, cityList);
        mCityAdapter.setOnCityClickListener(new CityListAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(CityBean cityBean) {
                judgeCity(cityBean);


            }

            @Override
            public void onLocateClick() {
//                mCityAdapter.updateLocateState(LocateState.LOCATING, null);
//                requestPermissions(CityPickerActivity.this, neededPermissions, CityPickerActivity.this);
            }
        });

        mResultAdapter = new ResultListAdapter(this, null);

    }

    private void judgeCity(final CityBean cityBean) {
        if (cityBean.getSubsystemList() != null && cityBean.getSubsystemList().size() > 1) {

            final List<CityBean.SubsystemListBean> subsysList = cityBean.getSubsystemList();
            List<String> strings = new ArrayList<>();
            for (CityBean.SubsystemListBean bean : cityBean.getSubsystemList()) {
                strings.add(bean.getSubsystemName());
            }
            CustomOptionsDialog customOptionsDialog = new CustomOptionsDialog(CityPickerActivity.this, strings);
            customOptionsDialog.showDialog();
            customOptionsDialog.setOnCustomClickListener(new CustomOptionsDialog.OnItemClickListener() {
                @Override
                public void onCustomDialogClickListener(int position, String s) {

                    int mID = subsysList.get(position).getId();
                    backWithData(cityBean.getUnitName(), mID);
                }
            });

        } else {
            backWithData(cityBean.getUnitName(), cityBean.getSubsystemList().get(0).getId());
        }
    }


    private void initView() {
        mListView = (ListView) findViewById(R.id.listview_all_city);
        mListView.setAdapter(mCityAdapter);

        TextView overlay = (TextView) findViewById(R.id.tv_letter_overlay);

        mLetterBar = (SideLetterBar) findViewById(R.id.side_letter_bar);
        mLetterBar.setOverlay(overlay);
        mLetterBar.setOnLetterChangedListener(new SideLetterBar.OnLetterChangedListener() {
            @Override
            public void onLetterChanged(String letter) {
                int position = mCityAdapter.getLetterPosition(letter);
                mListView.setSelection(position);
            }
        });

        searchBox = (EditText) findViewById(R.id.et_search);
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String keyword = s.toString();
                if (TextUtils.isEmpty(keyword)) {
                    clearBtn.setVisibility(View.GONE);
                    emptyView.setVisibility(View.GONE);
                    mResultListView.setVisibility(View.GONE);
                } else {
                    noData.setText("暂无数据");
                    clearBtn.setVisibility(View.VISIBLE);
                    mResultListView.setVisibility(View.VISIBLE);
                    mResultCities = getResultCities(keyword);
                    if (mResultCities == null || mResultCities.size() == 0) {
                        emptyView.setVisibility(View.VISIBLE);
                    } else {
                        emptyView.setVisibility(View.GONE);
                        mResultAdapter.changeData(mResultCities);
                    }
                }
            }
        });


        mResultListView = (ListView) findViewById(R.id.listview_search_result);
        mResultListView.setAdapter(mResultAdapter);
        mResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                judgeCity(mResultAdapter.getItem(position));
            }
        });

        clearBtn = (ImageView) findViewById(R.id.iv_search_clear);
        cancelBtn = (TextView) findViewById(R.id.tv_search_cancel);
        TextView textTitle = (TextView) findViewById(R.id.text_title);
        textTitle.setText("切换城市");
        RelativeLayout com_title_back = (RelativeLayout) findViewById(R.id.com_title_back);
        titleBackClickListener(com_title_back);

        clearBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        emptyView.setOnClickListener(this);

    }

    private List<CityBean> getResultCities(String keyword) {

        List<CityBean> beanList = new ArrayList<>();
        /*判断是否是中文*/
        if (Util.isContainChinese(keyword)) {
            for (CityBean cityBean : cityList) {
                if (cityBean.getUnitName().indexOf(keyword) != -1) {
                    beanList.add(cityBean);
                }
            }

        } else {
            /*不包含*/
            keyword = keyword.toLowerCase();
            for (CityBean cityBean : cityList) {
                if (cityBean.getAbbrSpell().toLowerCase().indexOf(keyword) != -1 ||
                        cityBean.getFullSpell().toLowerCase().indexOf(keyword) != -1) {
                    beanList.add(cityBean);
                }
            }
        }

        return beanList;
    }

    private void backWithData(String city, int value) {
        Intent data = new Intent();
        data.putExtra(BaseConstants.KEY_PICKED_CITY_NAME, city);
        data.putExtra(BaseConstants.KEY_PICKED_CITY_VALUE, value);
        setResult(RESULT_OK, data);
        finish();
//        RxBus.getDefault().post(BaseConstants.WECHA_SEARCH, city);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.iv_search_clear) {
            searchBox.setText("");
            clearBtn.setVisibility(View.GONE);
            emptyView.setVisibility(View.GONE);
            mResultListView.setVisibility(View.GONE);
            mResultCities = null;
        } else if (i == R.id.tv_search_cancel) {
            finish();

        } else if (i == R.id.empty_view) {
            if (!noData.getText().toString().equals("暂无数据")) {
                mPresenter.getCity();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       /* if (mLocationClient != null && mLocationClient.isStarted()) {
            mLocationClient.stop();
        }*/
    }


    @Override
    public void loadingSuccessForData(List<CityBean> cityBeanList) {
        emptyView.setVisibility(View.GONE);
        cityList = cityBeanList;
        Collections.sort(cityList, new CityComparator());
        initData();
        initView();
    }



    @Override
    public void loadingFail(String msg) {
        noData.setText("加载失败，请点击重新加载");
        emptyView.setVisibility(View.VISIBLE);
    }


    /**
     * a-z排序
     */
    private class CityComparator implements Comparator<CityBean> {
        @Override
        public int compare(CityBean lhs, CityBean rhs) {
            String a = lhs.getFullSpell().substring(0, 1);
            String b = rhs.getFullSpell().substring(0, 1);
            return a.compareTo(b);
        }
    }
}
