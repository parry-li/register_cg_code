package com.tdr.registrationv3.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.CodeTableBean;
import java.util.List;


/**
 *
 */

public class CodeTableHotAdapter extends BaseQuickAdapter<CodeTableBean, BaseViewHolder> {


    public CodeTableHotAdapter(List<CodeTableBean> data) {
        super(R.layout.item_code_hot, data);

    }


    @Override
    protected void convert(final BaseViewHolder helper, final CodeTableBean item) {

        helper.setText(R.id.hot_name, item.getName());


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
