package com.tdr.registration.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registration.R;
import com.tdr.registration.bean.CheckBean;
import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.bean.InsuranceWaitBean;

import java.util.List;

/**
 *
 */

public class InsuranceWaitAdapter extends BaseQuickAdapter<InsuranceWaitBean, BaseViewHolder> {

    private Context context;

    public InsuranceWaitAdapter(Context context, List<InsuranceWaitBean> data) {
        super(R.layout.item_insurance_wait, data);
        this.context = context;


    }

    @Override
    protected void convert(final BaseViewHolder helper, final InsuranceWaitBean item) {
        helper.setText(R.id.wait_plate, item.getPlateNumber());

        TextView chang = helper.getView(R.id.wait_change);
        TextView push = helper.getView(R.id.wait_push);
        RecyclerView insuranceRv = helper.getView(R.id.wait_rv);

        insuranceRv.setLayoutManager(new LinearLayoutManager(context));
        final InsuranceWaitItemAdapter changTypeAdapter = new InsuranceWaitItemAdapter(item.getPolicyList());
        insuranceRv.setAdapter(changTypeAdapter);
        changTypeAdapter.setOnItemClickListener(new InsuranceWaitItemAdapter.OnItemChangeClickListener() {
            @Override
            public void onItemChangeClickListener(String msg) {

                onItemClickListener.onItemClickListener(msg);
            }
        });
        chang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemChangeClickListener.onChangeItemClickListener(item);
            }
        });
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemPushClickListener.onItemPushClickListener(item);
            }
        });

    }


    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(String msg);
    }

    public interface OnItemChangeClickListener {
        void onChangeItemClickListener(InsuranceWaitBean insuranceWaitBean);
    }

    OnItemChangeClickListener onItemChangeClickListener;

    public void setOnItemChangeClickListener(OnItemChangeClickListener onItemChangeClickListener) {
        this.onItemChangeClickListener = onItemChangeClickListener;
    }


    public interface OnItemPushClickListener {
        void onItemPushClickListener(InsuranceWaitBean insuranceWaitBean);
    }

    OnItemPushClickListener onItemPushClickListener;

    public void setOnItemPushClickListener(OnItemPushClickListener onItemPushClickListener) {
        this.onItemPushClickListener = onItemPushClickListener;
    }

}
