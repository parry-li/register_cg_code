package com.tdr.registrationv3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tdr.registrationv3.R;
import com.tdr.registrationv3.adapter.BrandListAdapter;
import com.tdr.registrationv3.adapter.CodeTableAllAdapter;
import com.tdr.registrationv3.bean.CodeTableBean;
import com.tdr.registrationv3.constants.BaseConstants;
import com.tdr.registrationv3.http.utils.DdcResult;
import com.tdr.registrationv3.service.impl.CodeTableImpl;
import com.tdr.registrationv3.service.presenter.CodeTablePresenter;
import com.tdr.registrationv3.ui.activity.base.LoadingBaseActivity;
import com.tdr.registrationv3.view.SearchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class CodeTableActivity extends LoadingBaseActivity<CodeTableImpl> implements CodeTablePresenter.View {


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
    @BindView(R.id.all_rv)
    ListView allRv;
    @BindView(R.id.result_rv)
    RecyclerView resultRv;
    @BindView(R.id.empty_iv)
    ImageView emptyIv;
    @BindView(R.id.empty_tv)
    TextView emptyTv;
    @BindView(R.id.empty_data_rl)
    RelativeLayout emptyDataRl;
    private int codeType;
    //    private CodeTableHotAdapter hotAdapter;
    private BrandListAdapter allAdapter;
    private List<CodeTableBean> codeTableList;
    private CodeTableAllAdapter resultAdapter;

    @Override
    protected void initTitle() {
        /*0字典类型说明，1电动车品牌,2电动车类型,3 登记点类型,4颜色,5基站类型,6证件类型,7来历凭证,8基站运维状态,
         * 9业主单位,10运维单位,11基站用途,12保险公司,13车辆类型,15警车品牌,16 蓄电池品牌,17 蓄电池型号,18 经营范围,
         * 19 NB标签报警类型 20 电动车注销原因 21 所属部门*/

        if (codeType == 1) {
            textTitle.setText("电动车品牌");
        } else if (codeType == 2) {
            textTitle.setText("电动车类型");
        } else if (codeType == 3) {
            textTitle.setText("登记点类型");
        } else if (codeType == 4) {
            textTitle.setText("颜色");
        } else if (codeType == 6) {
            textTitle.setText("证件类型");
        } else if (codeType == 13) {
            textTitle.setText("车辆类型");
        } else if (codeType == 16) {
            textTitle.setText("蓄电池品牌");
        } else if (codeType == 17) {
            textTitle.setText("蓄电池型号");
        }

        emptyDataRl.setVisibility(View.GONE);
        titleBackClickListener(comTitleBack);
    }

    @Override
    protected void loadData() {
        zProgressHUD.show();
        Bundle bundle = getIntent().getExtras();
        codeType = bundle.getInt(BaseConstants.code_table, 1);

        getCode();
    }

    private int pagerSize = 1;

    private void getCode() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", codeType);
        map.put("page", 1);
        map.put("size", 0);
        mPresenter.getCodeTable(getRequestBody(map));
    }

    @Override
    protected CodeTableImpl setPresenter() {
        return new CodeTableImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        initHotRv();


        searchView.setSearchViewListener(new SearchView.SearchViewListener() {
            @Override
            public void onRefreshAutoComplete(String text) {

            }

            @Override
            public void onSearch(String text) {

                if (TextUtils.isEmpty(text)) {

                    allRv.setVisibility(View.VISIBLE);
                    emptyDataRl.setVisibility(View.GONE);
                    resultRv.setVisibility(View.GONE);
                    return;
                }

                allRv.setVisibility(View.GONE);
                resultRv.setVisibility(View.VISIBLE);
                List<CodeTableBean> list = new ArrayList<>();

                for (CodeTableBean bean : codeTableList) {
                    if (bean.getName().toLowerCase().contains(text)) {
                        list.add(bean);
                    }
                }

                if (list.size() > 0) {
                    resultAdapter.setNewData(list);
                } else {
                    emptyDataRl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancel() {
                allRv.setVisibility(View.VISIBLE);
                resultRv.setVisibility(View.GONE);
                emptyDataRl.setVisibility(View.GONE);
            }
        });

    }

    private void initAllRv() {
        allAdapter = new BrandListAdapter(this, codeTableList);
        allRv.setAdapter(allAdapter);
        allAdapter.setOnItemClickListener(new BrandListAdapter.OnItemConfirmClickListener() {
            @Override
            public void onItemClickListener(CodeTableBean tableBean) {
                backWithData(tableBean);
            }
        });

    }

    private void initHotRv() {
        List<CodeTableBean> beans = new ArrayList<>();
        resultRv.setLayoutManager(new LinearLayoutManager(this));
        resultAdapter = new CodeTableAllAdapter(beans);
        resultRv.setAdapter(resultAdapter);
        resultAdapter.setOnItemClickListener(new CodeTableAllAdapter.OnItemConfirmClickListener() {
            @Override
            public void onItemClickListener(CodeTableBean tableBean) {
                backWithData(tableBean);
            }
        });
    }

    private void backWithData(CodeTableBean tableBean) {
        Intent data = new Intent();
        data.putExtra(BaseConstants.KEY_NAME, tableBean.getName());
        data.putExtra(BaseConstants.KEY_VALUE, tableBean.getCode());
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_code_table;
    }

    @Override
    protected void submitRequestData() {

    }

    @Override
    public void loadingSuccessForData(final DdcResult<List<CodeTableBean>> data) {

        List<CodeTableBean> mData = data.getData();
        codeTableList = mData;

        initAllRv();
        zProgressHUD.dismiss();
        emptyDataRl.setVisibility(View.GONE);
        searchView.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadingFail(String msg) {
        zProgressHUD.dismiss();
        emptyDataRl.setVisibility(View.VISIBLE);
        searchView.setVisibility(View.GONE);
    }



}
