package com.tdr.registrationV3.ui.activity.image;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.photoview.PhotoView;
import com.tdr.registrationV3.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registrationV3.utils.GlideUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageActivity extends NoLoadingBaseActivity {


    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.iv_photo)
    PhotoView ivPhoto;

    @Override
    protected void initTitle() {
        comTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            finish();
            return;
        }

        String photoId = bundle.getString(BaseConstants.data);
        GlideUtil.setImgOriginal(this, photoId, ivPhoto);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image;
    }

    @Override
    protected void submitRequestData() {

    }

}

