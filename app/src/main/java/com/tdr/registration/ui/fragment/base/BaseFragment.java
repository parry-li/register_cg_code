package com.tdr.registration.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.tdr.registration.view.CustomWindowDialog;
import com.tdr.registration.view.ZProgressHUD;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class BaseFragment extends Fragment {
    private ZProgressHUD zProgressHUD;
    private CustomWindowDialog customBaseDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zProgressHUD = new ZProgressHUD(this.getActivity());
        zProgressHUD.setMessage("加载中");
        customBaseDialog = new CustomWindowDialog(this.getActivity());
        customBaseDialog.setOnCustomDialogClickListener(new CustomWindowDialog.OnItemClickListener() {
            @Override
            public void onCustomDialogClickListener() {
//                finish();
            }
        });

    }

    public RequestBody getRequestBody(Map<String, Object> stringMap) {
        String strEntity = new Gson().toJson(stringMap);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), strEntity);
        return body;
    }

    public void showCustomWindowDialog() {
        showCustomWindowDialog("温馨提示", "确定退出页面？", false);
    }

    public void showCustomWindowDialog(String content) {
        showCustomWindowDialog("温馨提示", content, false);
    }

    public void showCustomWindowDialog(String content, boolean isHidden) {
        showCustomWindowDialog("温馨提示", content, isHidden);
    }

    public void showCustomWindowDialog(String title, String content) {
        showCustomWindowDialog(title, content, false);
    }

    public void showCustomWindowDialog(String title, String content, boolean isHideCancel) {
        showCustomWindowDialog(title, content, isHideCancel, false);
    }

    public void showCustomWindowDialog(String title, String content, boolean isHideCancel, boolean isHideAffirm) {
        customBaseDialog.showCustomWindowDialog(title, content, isHideCancel, isHideAffirm);
    }
}
