package com.tdr.registrationv3.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.CheckBean;
import com.tdr.registrationv3.bean.InsuranceBean;


import java.util.ArrayList;

import java.util.List;

/**
 *
 */

public class InsuranceTypeAdapter extends BaseQuickAdapter<InsuranceBean.PackagesBean, BaseViewHolder> {


    public List<CheckBean> mapList = new ArrayList<>();
    List<InsuranceBean.PackagesBean> newDataList;

    public InsuranceTypeAdapter(List<InsuranceBean.PackagesBean> data) {
        super(R.layout.item_change_type, data);
        newDataList = data;
        for (int i = 0; i < data.size(); i++) {
            mapList.add(new CheckBean(i, false));
        }
    }


    @Override
    protected void convert(final BaseViewHolder helper, final InsuranceBean.PackagesBean item) {

        final int position = helper.getLayoutPosition();
        final ImageView checkBox = helper.getView(R.id.check_label);
        helper.setText(R.id.check_tv,  item.getName());
        mapList.get(position).setCheck(item.isCheck());
        if (item.isCheck()) {
            checkBox.setImageResource(R.drawable.chang_select);
        } else {
            checkBox.setImageResource(R.drawable.chang_unselect);
        }

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheckBox(position);

            }
        });
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheckBox(position);

            }
        });


    }

    private RecyclerView recycleView;

    public void setRecycleView(RecyclerView recycleView) {
        this.recycleView = recycleView;
    }

    private void setCheckBox(int position) {

        int mSize = mapList.size();

        for (int i = 0; i < mSize; i++) {
            if (position == i) {
                if(mapList.get(i).isCheck()){
                    mapList.get(i).setCheck(false);
                }else {
                    mapList.get(i).setCheck(true);
                }

            } else {
                mapList.get(i).setCheck(false);
            }
        }
        onItemChangeClickListener.onItemChangeClickListener(position);

    }
    public void initCheckBox() {

        int mSize = mapList.size();

        for (int i = 0; i < mSize; i++) {
                mapList.get(i).setCheck(false);
        }
        notifyDataSetChanged();

    }

    // 全选按钮获取状态
    public List<CheckBean> getCheckBox() {
        // 返回状态
        return mapList;
    }

    OnItemChangeClickListener onItemChangeClickListener;

    public void setOnItemClickListener(OnItemChangeClickListener onItemChangeClickListener) {
        this.onItemChangeClickListener = onItemChangeClickListener;
    }

    public interface OnItemChangeClickListener {
        void onItemChangeClickListener(int position);
    }


}
