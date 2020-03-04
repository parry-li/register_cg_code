package com.tdr.registrationv3.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.StatisticsBean;

import java.util.List;

/**
 *
 */

public class StatisticsChildAdapter extends BaseQuickAdapter<StatisticsBean.PolicyListBean.DetailsBean, BaseViewHolder> {


    public StatisticsChildAdapter(List<StatisticsBean.PolicyListBean.DetailsBean> data) {
        super(R.layout.item_statistics_child, data);

    }

    @Override
    protected void convert(final BaseViewHolder helper, final StatisticsBean.PolicyListBean.DetailsBean item) {

        int position = helper.getAdapterPosition();
        ImageView iconIv = helper.getView(R.id.chile_iv);
        if(position == 0){
            iconIv.setImageResource(R.mipmap.statistics_circle_1);
        }else if(position == 1){
                iconIv.setImageResource(R.mipmap.statistics_circle_2);
        }else if(position == 2){
            iconIv.setImageResource(R.mipmap.statistics_circle_3);
        }

        helper.setText(R.id.chile_year, item.getName());
        helper.setText(R.id.chile_unm, "数量：" + item.getQuantity());
        helper.setText(R.id.chile_money, "金额：" + item.getAmount());

    }




}
