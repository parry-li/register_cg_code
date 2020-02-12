package com.tdr.registration.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registration.R;
import com.tdr.registration.bean.PhotoConfigBean;

import java.util.List;

/**
 *
 */

public class PhotoAdapter extends BaseQuickAdapter<PhotoConfigBean.PhotoTypeInfoListBean, BaseViewHolder> {

    public ImageView imgIv;

    public PhotoAdapter(List<PhotoConfigBean.PhotoTypeInfoListBean> data) {
        super(R.layout.item_change_photo, data);

    }

    @Override
    protected void convert(final BaseViewHolder helper, PhotoConfigBean.PhotoTypeInfoListBean item) {
        TextView tvMust = helper.getView(R.id.chang_photo_tv_must);
        imgIv = helper.getView(R.id.chang_photo_img);
        ImageView imgYes = helper.getView(R.id.chang_photo_yes);
        helper.setText(R.id.chang_photo_tv, item.getPhotoName());
        if (item.isIsRequire()) {
            tvMust.setVisibility(View.VISIBLE);
        } else {
            tvMust.setVisibility(View.GONE);
        }

        if (TextUtils.isEmpty(item.getPhotoId())) {
            imgYes.setVisibility(View.GONE);
        } else {
            imgYes.setVisibility(View.VISIBLE);
        }

        if (item.getDrawable() != null) {
            imgIv.setBackgroundDrawable(item.getDrawable());
        }

    }


}
