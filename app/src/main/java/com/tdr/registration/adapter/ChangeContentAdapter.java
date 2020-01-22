package com.tdr.registration.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registration.R;
import com.tdr.registration.bean.ItemModel;
import com.tdr.registration.bean.VehicleConfigBean;

import java.util.List;

/**
 *
 */

public class ChangeContentAdapter extends BaseQuickAdapter<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean, BaseViewHolder> {


    private List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> dataList;

    public ChangeContentAdapter(List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> data) {
        super(R.layout.item_change_content, data);
        dataList = data;

    }

    @Override
    protected void convert(final BaseViewHolder helper, VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean item) {
        final int position = helper.getLayoutPosition();
        helper.setText(R.id.change_photo_name, item.getLableName());
        TextView photoTv = helper.getView(R.id.change_photo_tv);
        TextView photoll = helper.getView(R.id.change_photo_ll);
        EditText photoEt = helper.getView(R.id.change_photo_et);
        ImageView photoIv = helper.getView(R.id.change_photo_iv);
        if (item.isNoScan()) {
            photoEt.setVisibility(View.VISIBLE);
            photoTv.setVisibility(View.GONE);
            photoIv.setVisibility(View.GONE);
        } else {
            photoEt.setVisibility(View.GONE);
            photoTv.setVisibility(View.VISIBLE);
            photoIv.setVisibility(View.VISIBLE);
        }
        photoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickListener(position);
            }
        });
        if (TextUtils.isEmpty(item.getEditValue())) {
            photoTv.setHint("请扫码" + item.getLableName());
        } else {
            photoTv.setText(item.getEditValue());
        }

        photoEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mData.get(position).setEditValue(editable.toString().trim());
            }
        });

    }

    public void setDataList(List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> data) {
        dataList = data;
    }

    public List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> getDataList() {
        return dataList;
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);
    }
}
