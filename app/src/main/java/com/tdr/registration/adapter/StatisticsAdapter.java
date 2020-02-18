package com.tdr.registration.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registration.R;
import com.tdr.registration.bean.StatisticsBean;
import java.util.List;


/**
 *
 */

public class StatisticsAdapter extends BaseQuickAdapter<StatisticsBean.PolicyListBean, BaseViewHolder> {


    private Context context;

    public StatisticsAdapter(Context context, List<StatisticsBean.PolicyListBean> data) {
        super(R.layout.item_statistics, data);

        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final StatisticsBean.PolicyListBean item) {

        helper.setText(R.id.insurance_name, item.getName());
        helper.setText(R.id.insurance_unm, "总数量：" + item.getQuantity());
        helper.setText(R.id.insurance_money, "总金额：" + item.getAmount());
        RecyclerView statisticsRv = helper.getView(R.id.statistics_item_rv);
        statisticsRv.setLayoutManager(new LinearLayoutManager(context));
        StatisticsChildAdapter childAdapter = new StatisticsChildAdapter(item.getDetails());
        statisticsRv.setAdapter(childAdapter);
    }


    OnItemChangeClickListener onItemChangeClickListener;

    public void setOnItemClickListener(OnItemChangeClickListener onItemChangeClickListener) {
        this.onItemChangeClickListener = onItemChangeClickListener;
    }

    public interface OnItemChangeClickListener {
        void onItemChangeClickListener();
    }


}
