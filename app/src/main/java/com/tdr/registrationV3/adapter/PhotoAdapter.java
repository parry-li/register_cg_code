package com.tdr.registrationV3.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.PhotoConfigBean;
import com.tdr.registrationV3.utils.GlideUtil;

import java.util.List;

/**
 *
 */

public class PhotoAdapter extends BaseQuickAdapter<PhotoConfigBean.PhotoTypeInfoListBean, BaseViewHolder> {

    public ImageView imgIv;

    private Context context;

    public PhotoAdapter(Context context, List<PhotoConfigBean.PhotoTypeInfoListBean> data) {
        super(R.layout.item_change_photo, data);
        this.context = context;

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
        } else {
            if (!TextUtils.isEmpty(item.getChagePhotoId())) {
                GlideUtil.setImg(context, item.getChagePhotoId(), imgIv);
            } else {
                imgIv.setBackgroundResource(R.mipmap.change_photo);
            }
        }


    }


}
