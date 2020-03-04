package com.tdr.registrationv3.adapter;


import android.view.View;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.UnitBean;


import java.util.List;

/**
 *
 */

public class UnitAdapter extends BaseQuickAdapter<UnitBean.ChildrenListBeanX, BaseViewHolder> {





    public UnitAdapter(List<UnitBean.ChildrenListBeanX> data) {
        super(R.layout.item_unit, data);


    }

    @Override
    protected void convert(final BaseViewHolder helper, final UnitBean.ChildrenListBeanX item) {
        helper.setText(R.id.unit_name, item.getUnitName());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickListener(item);
            }
        });

    }


    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener( UnitBean.ChildrenListBeanX item);
    }
}
