package com.tdr.registration.adapter;


import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registration.R;
import com.tdr.registration.bean.CodeTableBean;

import java.util.List;


/**
 *
 */

public class CodeTableAllAdapter extends BaseQuickAdapter<CodeTableBean, BaseViewHolder> {


    public CodeTableAllAdapter(List<CodeTableBean> data) {
        super(R.layout.item_code_all, data);

    }

    @Override
    protected void convert(final BaseViewHolder helper, final CodeTableBean item) {

        helper.setText(R.id.all_name, item.getName());
       TextView allType = helper.getView(R.id.all_type);
        allType.setVisibility(View.GONE);

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmClickListener.onItemClickListener(item);
            }
        });


    }


    OnItemConfirmClickListener confirmClickListener;

    public void setOnItemClickListener(OnItemConfirmClickListener confirmClickListener) {
        this.confirmClickListener = confirmClickListener;
    }

    public interface OnItemConfirmClickListener {
        void onItemClickListener(CodeTableBean tableBean);
    }

}
