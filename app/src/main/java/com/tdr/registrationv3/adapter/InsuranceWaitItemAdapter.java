package com.tdr.registrationv3.adapter;


import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.InsuranceWaitBean;

import java.util.List;

/**
 *
 */

public class InsuranceWaitItemAdapter extends BaseQuickAdapter<InsuranceWaitBean.PolicyListBean, BaseViewHolder> {


    public InsuranceWaitItemAdapter(List<InsuranceWaitBean.PolicyListBean> data) {
        super(R.layout.item_wait_item, data);


    }


    @Override
    protected void convert(final BaseViewHolder helper, final InsuranceWaitBean.PolicyListBean item) {


        helper.setText(R.id.insurance_name, item.getInsuranceType());
        helper.setText(R.id.insurance_label, item.getInsuranceSubtitle());
        helper.setText(R.id.insurance_time, item.getPolicyStartDate());
        helper.setText(R.id.wait_money, "¥" + item.getPrice());
        helper.setText(R.id.wait_year, item.getDeadLine() + "年");
        ImageView imageView = helper.getView(R.id.insurance_msg);
        if (item.getError() == 0) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
        }

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getError() != 0) {
                    onItemChangeClickListener.onItemChangeClickListener(item.getMessage());
                }
            }
        });
    }


    OnItemChangeClickListener onItemChangeClickListener;

    public void setOnItemClickListener(OnItemChangeClickListener onItemChangeClickListener) {
        this.onItemChangeClickListener = onItemChangeClickListener;
    }

    public interface OnItemChangeClickListener {
        void onItemChangeClickListener(String msg);
    }


}
