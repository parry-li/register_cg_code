package com.tdr.registrationV3.ui.fragment.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tdr.registrationV3.R;
import com.tdr.registrationV3.constants.BaseConstants;
import com.tdr.registrationV3.service.BasePresenter;
import com.tdr.registrationV3.ui.activity.CodeTableActivity;
import com.tdr.registrationV3.ui.activity.car.RegisterMainActivity;
import com.tdr.registrationV3.ui.fragment.base.NoLoadingBaseFragment;
import com.tdr.registrationV3.utils.ActivityUtil;
import com.tdr.registrationV3.utils.RegularUtil;
import com.tdr.registrationV3.utils.ToastUtil;
import com.tdr.registrationV3.utils.UIUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterPeopleFragment extends NoLoadingBaseFragment {
    private static final int CODE_TABLE_CARD = 2001;
    @BindView(R.id.com_title_back)
    RelativeLayout comTitleBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.com_title_setting_iv)
    ImageView comTitleSettingIv;
    @BindView(R.id.com_title_setting_tv)
    TextView comTitleSettingTv;
    @BindView(R.id.people_name)
    EditText peopleName;
    @BindView(R.id.people_card)
    TextView peopleCard;
    @BindView(R.id.people_card_allow)
    ImageView peopleCardAllow;
    @BindView(R.id.people_card_num)
    EditText peopleCardNum;
    @BindView(R.id.people_phone1)
    EditText peoplePhone1;
    @BindView(R.id.people_phone2)
    EditText peoplePhone2;
    @BindView(R.id.people_adr)
    EditText peopleAdr;
    @BindView(R.id.people_remark)
    EditText peopleRemark;
    @BindView(R.id.button_next)
    TextView buttonNext;

    private String cardCode = "1";


    @Override
    protected BasePresenter setPresenter() {
        return null;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register_people;
    }

    @Override
    protected void initView() {
        textTitle.setText("备案登记");
        comTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).setVpCurrentItem(0);
            }
        });

        UIUtils.setEditTextUpperCase(peopleCardNum);
    }

    @OnClick({R.id.people_card, R.id.people_card_allow, R.id.button_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.people_card:
            case R.id.people_card_allow:
                Bundle bundle = new Bundle();
                bundle.putInt(BaseConstants.code_table, 6);
                startActivityForResult(ActivityUtil.goActivityForResultForFragment(RegisterPeopleFragment.this.getActivity(),
                        CodeTableActivity.class, bundle), CODE_TABLE_CARD);
                break;
            case R.id.button_next:
                putData();
                break;
        }
    }

    private void putData() {
        String peopleNameStr = peopleName.getText().toString().trim();
        if (TextUtils.isEmpty(peopleNameStr)) {
            ToastUtil.showWX("请输入姓名");
            return;
        }
        String peopleCardNumStr = peopleCardNum.getText().toString().trim().toUpperCase();
        if (TextUtils.isEmpty(peopleCardNumStr)) {
            ToastUtil.showWX("请输入证件号");
            return;
        }
        if ("1".equals(cardCode)) {
            if (!RegularUtil.isIDCard18(peopleCardNumStr)) {
                ToastUtil.showWX("输入的证件号有误");
                return;
            }
        }
        String peoplePhone1Str = peoplePhone1.getText().toString().trim();
        if (TextUtils.isEmpty(peoplePhone1Str)) {
            ToastUtil.showWX("请输入联系手机");
            return;
        }
        if (!RegularUtil.isMobileExact(peoplePhone1Str)) {
            ToastUtil.showWX("输入的手机号码有误");
            return;
        }
        String peopleAdrStr = peopleAdr.getText().toString().trim();
        if (TextUtils.isEmpty(peopleAdrStr)) {
            ToastUtil.showWX("请输入地址");
            return;
        }
        String peoplePhone2Str = peoplePhone2.getText().toString().trim();
        String peopleRemarkStr = peopleRemark.getText().toString().trim();
        String peopleCardStr = peopleCard.getText().toString().trim();

        if (!TextUtils.isEmpty(peoplePhone2Str)) {
            if (!RegularUtil.isMobileExact(peoplePhone2Str)) {
                ToastUtil.showWX("输入的备用号码有误");
                return;
            }
        }


        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).registerPutBean.setPeopleName(peopleNameStr);
        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).registerPutBean.setPeopleCardNum(peopleCardNumStr);
        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).registerPutBean.setPeopleCardType(cardCode);
        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).registerPutBean.setPeoplePhone1(peoplePhone1Str);
        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).registerPutBean.setPeoplePhone2(peoplePhone2Str);
        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).registerPutBean.setPeopleAddr(peopleAdrStr);
        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).registerPutBean.setPeopleRemark(peopleRemarkStr);
        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).registerPutBean.setCardName(peopleCardStr);


        ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).setVpCurrentItem(2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_TABLE_CARD &&
                resultCode == ((RegisterMainActivity) RegisterPeopleFragment.this.getActivity()).RESULT_OK) {
            String name = data.getStringExtra(BaseConstants.KEY_NAME);
            cardCode = data.getStringExtra(BaseConstants.KEY_VALUE);
            peopleCard.setText(name);

        }
    }


    @Override
    protected void submitRequestData() {

    }
}
