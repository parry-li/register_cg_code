package com.tdr.registration.view;

import android.app.Activity;

import android.content.Context;
import android.graphics.Color;

import android.view.View;


import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.tdr.registration.App;

import java.util.List;


/**
 * @author parry
 * @time 2017/6/7/007 14:20
 * @des ${TODO}
 */

public class CustomOptionsDialog {



    private OptionsPickerView pvOptions;

    public CustomOptionsDialog(Context context, List<String> list) {

        initPickView(context,list);
    }

    private void initPickView(Context context, final List<String> list) {
        pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                onItemClickListener.onCustomDialogClickListener(options1, list.get(options1));
            }
        })
                .setSubmitText("确定")//确定按钮文字
                .setCancelText("取消")//取消按钮文字
                .setTitleText("")//标题
                .setSubCalSize(18)//确定和取消文字大小
                .setTitleSize(20)//标题文字大小
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                .setCancelColor(Color.BLACK)//取消按钮文字颜色
                .setTitleBgColor(Color.LTGRAY)//标题背景颜色 Night mode
                .setBgColor(0xFFF1F1F5)//滚轮背景颜色 Night mode
                .setContentTextSize(18)//滚轮文字大小
                .setLabels("", "", "")//设置选择的三级单位
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setCyclic(false, false, false)//循环与否
                .setSelectOptions(0, 0, 0)  //设置默认选中项
                .setOutSideCancelable(true)//点击外部dismiss default true
                .isDialog(false)//是否显示为对话框样式
                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                .build();

        pvOptions.setPicker(list);//添加数据源
    }


    public void showDialog() {
        if (pvOptions != null && !pvOptions.isShowing()) {
            pvOptions.show();
        }

    }


    OnItemClickListener onItemClickListener;


    public void setOnCustomClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onCustomDialogClickListener(int position, String value);
    }


}