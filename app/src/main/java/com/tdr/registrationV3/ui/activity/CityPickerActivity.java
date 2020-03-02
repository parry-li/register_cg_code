package com.tdr.registrationV3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.CityBean;
import com.tdr.registrationV3.bean.OptionsBean;
import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.service.impl.city.CityImpl;
import com.tdr.registrationV3.service.presenter.CityPresenter;
import com.tdr.registrationV3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationV3.utils.UIUtils;
import com.tdr.registrationV3.view.CityPicker.adapter.CityListAdapter;
import com.tdr.registrationV3.view.CityPicker.adapter.ResultListAdapter;
import com.tdr.registrationV3.view.CityPicker.model.City;
import com.tdr.registrationV3.view.CityPicker.view.SideLetterBar;
import com.tdr.registrationV3.view.CustomOptionsDialog;
import com.tdr.registrationV3.view.SearchView;

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

    private RelativeLayout emptyView;

    private CityListAdapter mCityAdapter;
    private ResultListAdapter mResultAdapter;
    private List<City> mAllCities;
    private List<CityBean> mResultCities;
    //    private DBManager dbManager;
    private List<CityBean> cityList = new ArrayList<>();

    private SearchView searchView;
    private TextView noData;


    @Override
    protected int getLayoutId() {
        return R.layout.cp_activity_city_list;
    }

    @Override
    protected void submitRequestData() {

    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        initData();
        initView();

    }

    @Override
    protected void initTitle() {
        noData = (TextView) findViewById(R.id.empty_tv);
        emptyView = (RelativeLayout) findViewById(R.id.empty_data_rl);
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


        mCityAdapter = new CityListAdapter(this, cityList);
        mCityAdapter.setOnCityClickListener(new CityListAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(CityBean cityBean) {
                judgeCity(cityBean);
            }

            @Override
            public void onLocateClick() {

            }
        });

        mResultAdapter = new ResultListAdapter(this, null);

    }

    private void judgeCity(final CityBean cityBean) {
        if (cityBean.getSubsystemList() != null && cityBean.getSubsystemList().size() > 1) {

            final List<CityBean.SubsystemListBean> subsysList = cityBean.getSubsystemList();
            List<OptionsBean> strings = new ArrayList<>();
            for (CityBean.SubsystemListBean bean : cityBean.getSubsystemList()) {
                strings.add(new OptionsBean(bean.getSubsystemName(), ""));
            }
            CustomOptionsDialog customOptionsDialog = new CustomOptionsDialog(CityPickerActivity.this, "请选择字系统");
            customOptionsDialog.setPickerData(strings);
            customOptionsDialog.showDialog();
            customOptionsDialog.setOnCustomClickListener(new CustomOptionsDialog.OnItemClickListener() {
                @Override
                public void onCustomDialogClickListener(int options1, int options2, int options3) {
                    int mID = subsysList.get(options1).getId();
                    backWithData(cityBean.getUnitName(), mID, cityBean.getCityCode());
                }

            });

        } else {
            backWithData(cityBean.getUnitName(), cityBean.getSubsystemList().get(0).getId(), cityBean.getCityCode());
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

        searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setSearchViewListener(new SearchView.SearchViewListener() {
            @Override
            public void onRefreshAutoComplete(String text) {

            }

            @Override
            public void onSearch(String text) {
                String keyword = text;
                if (TextUtils.isEmpty(keyword)) {

                    emptyView.setVisibility(View.GONE);
                    mResultListView.setVisibility(View.GONE);
                } else {
                    noData.setText("暂无数据");
                    mListView.setVisibility(View.GONE);
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

            @Override
            public void onCancel() {
                if(cityList!=null&&cityList.size()>0){
                    emptyView.setVisibility(View.GONE);
                    mResultListView.setVisibility(View.GONE);
                    mListView.setVisibility(View.VISIBLE);
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


        TextView textTitle = (TextView) findViewById(R.id.text_title);
        textTitle.setText("切换城市");
        RelativeLayout com_title_back = (RelativeLayout) findViewById(R.id.com_title_back);
        titleBackClickListener(com_title_back);

        emptyView.setOnClickListener(this);

    }

    private List<CityBean> getResultCities(String keyword) {

        List<CityBean> beanList = new ArrayList<>();
        /*判断是否是中文*/
        if (UIUtils.isContainChinese(keyword)) {
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

    private void backWithData(String city, int value, String cityCode) {
        Intent data = new Intent();
        data.putExtra(BaseConstants.KEY_NAME, city);
        data.putExtra(BaseConstants.KEY_VALUE, value);
        data.putExtra(BaseConstants.Login_city_cityCode, cityCode);
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.empty_view) {
            if (UIUtils.isFastClick()) {
                if (!noData.getText().toString().equals("暂无数据")) {
                    zProgressHUD.show();
                    mPresenter.getCity();
                }
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void loadingSuccessForData(List<CityBean> cityBeanList) {
        zProgressHUD.dismiss();
        emptyView.setVisibility(View.GONE);
        cityList = cityBeanList;
        Collections.sort(cityList, new CityComparator());
        mCityAdapter.setNewData(cityList);

    }


    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
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
