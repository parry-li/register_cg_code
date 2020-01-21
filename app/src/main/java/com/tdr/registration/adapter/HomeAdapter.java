package com.tdr.registration.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registration.R;
import com.tdr.registration.bean.ItemModel;

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
    protected void convert(final BaseViewHolder helper, ItemModel item) {
        helper.setText(R.id.item_name, item.getItemName());
        helper.setImageResource(R.id.item_iv, item.getItemBitResc());

    }


}
