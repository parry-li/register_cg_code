package com.tdr.registrationV3.adapter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.VehicleConfigBean;

import java.util.List;

/**
 *
 */

public class LabelAdapter extends BaseQuickAdapter<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean, BaseViewHolder> {


    private boolean isSHowX;

    public LabelAdapter(List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> data) {
        super(R.layout.item_change_content, data);
        isSHowX = true;

    }

    public LabelAdapter(List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> data, boolean isShowX) {
        super(R.layout.item_change_content, data);
        this.isSHowX = isShowX;

    }

    @Override
    protected void convert(final BaseViewHolder helper, final VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean item) {
        final int position = helper.getLayoutPosition();
        helper.setText(R.id.change_photo_name, item.getLableName());
        TextView photoTv = helper.getView(R.id.change_photo_tv);
        LinearLayout photoll = helper.getView(R.id.change_photo_ll);
        EditText photoEt = helper.getView(R.id.change_photo_et);
        ImageView photoIv = helper.getView(R.id.change_photo_iv);
        TextView change_x = helper.getView(R.id.change_x);
        if (isSHowX) {
            if(item.isIsRequired()){
                change_x.setVisibility(View.VISIBLE);
            }else {
                change_x.setVisibility(View.INVISIBLE);
            }
        } else {
            change_x.setVisibility(View.INVISIBLE);
        }

        photoEt.setVisibility(View.GONE);
        photoTv.setVisibility(View.VISIBLE);
        photoIv.setVisibility(View.VISIBLE);
        if (item.getIndex() == 0) {
            if (item.isNoScan()) {
                photoEt.setVisibility(View.VISIBLE);
                photoTv.setVisibility(View.GONE);
                photoIv.setVisibility(View.GONE);
            }
        }
//        photoEt.setTransformationMethod(new AllCapTransformationMethod(true));
        photoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickListener(position, item.getLableName());
            }
        });
        if (item.getIndex() == 0) {
            if (TextUtils.isEmpty(item.getEditValue())) {
                if (item.isNoScan()) {
                    photoEt.setHint("请输入" + item.getLableName());
                    photoEt.setText("");
                } else {
                    photoTv.setHint("请扫描" + item.getLableName());
                    photoTv.setText("");

                }
            } else {
                if (item.isNoScan()) {
                    photoEt.setText(item.getEditValue());
                } else {
                    photoTv.setText(item.getEditValue());

                }
            }


        } else {
            if (TextUtils.isEmpty(item.getEditValue())) {
                photoTv.setHint("请扫描" + item.getLableName());
                photoTv.setText("");
            } else {
                photoTv.setText(item.getEditValue());
            }
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


    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position, String labelName);
    }
}
