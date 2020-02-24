package com.tdr.registrationV3.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.ItemModel;

import java.util.List;

/**
 *
 */

public class HomeAdapter extends BaseQuickAdapter<ItemModel, BaseViewHolder> {

    private Context context;

    public HomeAdapter(List<ItemModel> data) {
        super(R.layout.item_fragment_home, data);

    }

    @Override
    protected void convert(final BaseViewHolder helper, final ItemModel item) {
        helper.setText(R.id.item_name, item.getItemName());
        helper.setImageResource(R.id.item_iv, item.getItemBitResc());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickListener(item.getRolePower(),helper.getAdapterPosition());
            }
        });
    }

   OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(String rolePower, int position);
    }
}
