package com.tdr.registrationV3.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.VehicleConfigBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */

public class ChangTypeAdapter extends BaseQuickAdapter<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean, BaseViewHolder> {


    public Map<Integer, Boolean> isCheck = new HashMap<Integer, Boolean>();

    public ChangTypeAdapter(List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> data) {
        super(R.layout.item_change_type, data);

    }

    @Override
    protected void convert(final BaseViewHolder helper, final VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean item) {

        final int position = helper.getLayoutPosition();
//        helper.setText(R.id.check_label,item.getName());
        final CheckBox checkBox = helper.getView(R.id.check_label);
        helper.setText(R.id.check_tv, item.getLableName());

        // 设置checkbox状态
        if (isCheck.get(position) == null) {
            isCheck.put(position, false);
        }
        checkBox.setChecked(isCheck.get(position));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isCheck.put(position, b);
                onItemChangeClickListener.onItemChangeClickListener();
            }
        });

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean b = !isCheck.get(position);
                isCheck.put(position, b);
                checkBox.setChecked(b);
            }
        });

    }

    // 全选按钮获取状态
    public Map<Integer, Boolean> getMap() {
        // 返回状态
        return isCheck;
    }

    OnItemChangeClickListener onItemChangeClickListener;

    public void setOnItemClickListener(OnItemChangeClickListener onItemChangeClickListener) {
        this.onItemChangeClickListener = onItemChangeClickListener;
    }

    public interface OnItemChangeClickListener {
        void onItemChangeClickListener();
    }


}
