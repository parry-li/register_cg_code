package com.tdr.registrationV3.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.BlcakCarBean;
import com.tdr.registrationV3.bean.PhotoConfigBean;

import com.tdr.registrationV3.view.CustomImageDialog;


import java.util.ArrayList;
import java.util.List;


public class BlackCarAdapter extends BaseQuickAdapter<BlcakCarBean, BaseViewHolder> {
    private Activity activity;
    //    private List<ChackBlackCarNum.DataBean> data;
    private List<BlcakCarBean> data;

    public BlackCarAdapter(List<BlcakCarBean> data, Activity activity) {
        super(R.layout.item_black_car, data);
        this.activity = activity;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final BlcakCarBean item) {
        helper.setText(R.id.car_m_name, item.getOwnerName());
        helper.setText(R.id.car_m_color, item.getColorName());
        helper.setText(R.id.car_m_pp, item.getVehicleBrandName());
        helper.setText(R.id.car_m_cj, item.getShelvesNumber());
        helper.setText(R.id.car_m_dj, item.getEngineNumber());
        helper.setText(R.id.black_car_plate, item.getPlateNumber());
        final List<PhotoConfigBean.PhotoTypeInfoListBean> phtotList = new ArrayList<>();
        for (BlcakCarBean.PhotoListsBean photoBean : item.getPhotoLists()) {
            PhotoConfigBean.PhotoTypeInfoListBean newBean = new PhotoConfigBean.PhotoTypeInfoListBean();
            newBean.setChagePhotoId(photoBean.getPhoto());
            newBean.setPhotoName(photoBean.getPhotoName());
            newBean.setIsValid(false);
            phtotList.add(newBean);
        }
        RecyclerView carRv = helper.getView(R.id.car_m_rv);
        PhotoAdapter photoAdapter = new PhotoAdapter(activity, phtotList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 3);
        carRv.setLayoutManager(gridLayoutManager);
        carRv.setAdapter(photoAdapter);
        photoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CustomImageDialog.showCustomWindowDialog(activity,phtotList.get(position).getChagePhotoId());
//                Bundle bundle = new Bundle();
//                bundle.putString(BaseConstants.data, phtotList.get(position).getChagePhotoId());
//                ActivityUtil.goActivity(activity, ImageActivity.class, bundle);
            }
        });


    }


    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);
    }

}
