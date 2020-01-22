package com.tdr.registration.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registration.R;
import com.tdr.registration.bean.ItemModel;
import com.tdr.registration.bean.PhotoConfigBean;

import java.util.List;

/**
 *
 */

public class ChangePhotoAdapter extends BaseQuickAdapter<PhotoConfigBean.PhotoTypeInfoListBean, BaseViewHolder> {

    private Context context;

    public ChangePhotoAdapter(List<PhotoConfigBean.PhotoTypeInfoListBean> data) {
        super(R.layout.item_change_photo, data);

    }

    @Override
    protected void convert(final BaseViewHolder helper, PhotoConfigBean.PhotoTypeInfoListBean item) {
      ImageView tvMust = helper.getView(R.id.chang_photo_tv_must);
        ImageView imgIv  =    helper.getView(R.id.chang_photo_img);
        helper.setText(R.id.chang_photo_tv, item.getPhotoName());
        if(item.isMust()){
            tvMust.setVisibility(View.VISIBLE);
        }else {
            tvMust.setVisibility(View.GONE);
        }

    }


}
