package com.tdr.registrationV3.ui.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tdr.registrationV3.R;
import com.tdr.registrationV3.adapter.FragmentPageAdapter;
import com.tdr.registrationV3.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registrationV3.ui.fragment.HomeFragment;
import com.tdr.registrationV3.ui.fragment.MeFragment;
import com.tdr.registrationV3.utils.UIUtils;
import com.tdr.registrationV3.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends NoLoadingBaseActivity {


    @BindView(R.id.main_vp)
    NoScrollViewPager mainVp;
    @BindView(R.id.main_bottom_home_tv)
    TextView mainBottomHomeTv;
    @BindView(R.id.main_bottom_home)
    LinearLayout mainBottomHome;
    @BindView(R.id.main_bottom_me_tv)
    TextView mainBottomMeTv;
    @BindView(R.id.main_bottom_me)
    LinearLayout mainBottomMe;
    @BindView(R.id.main_bottom)
    LinearLayout mainBottom;
    @BindView(R.id.main_bottom_home_iv)
    ImageView mainBottomHomeIv;
    @BindView(R.id.main_bottom_me_iv)
    ImageView mainBottomMeIv;

    @Override
    protected void initTitle() {

        isShowBackDialog =false;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new MeFragment());

        resetBottom(0);
        mainBottomHomeTv.setTextColor(UIUtils.getColor(R.color.module_main));
        mainVp.setNoScroll(true);
        mainVp.setAdapter(new FragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
        mainVp.setCurrentItem(0);
    }

    private void resetBottom(int type) {
        if (type == 0) {
            mainBottomMeTv.setTextColor(UIUtils.getColor(R.color.module_button_unselect));
            mainBottomHomeTv.setTextColor(UIUtils.getColor(R.color.module_main));
            mainBottomHomeIv.setImageResource(R.mipmap.home_main_select);
            mainBottomMeIv.setImageResource(R.mipmap.home_me_unselect);
        } else {
            mainBottomMeTv.setTextColor(UIUtils.getColor(R.color.module_main));
            mainBottomHomeTv.setTextColor(UIUtils.getColor(R.color.module_button_unselect));
            mainBottomHomeIv.setImageResource(R.mipmap.home_main_unselect);
            mainBottomMeIv.setImageResource(R.mipmap.home_me_select);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void submitRequestData() {

    }


    @OnClick({R.id.main_bottom_home, R.id.main_bottom_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_bottom_home:
                mainVp.setCurrentItem(0);
                resetBottom(0);
                break;
            case R.id.main_bottom_me:
                mainVp.setCurrentItem(1);
                resetBottom(1);
                break;
        }
    }


}
