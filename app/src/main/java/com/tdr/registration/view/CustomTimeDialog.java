package com.tdr.registration.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.tdr.registration.utils.TimeUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * @author parry
 * @time 2017/6/7/007 14:20
 * @des ${TODO}
 */

public class CustomTimeDialog {

    private TimePickerView pvTime;


    public CustomTimeDialog(Context context) {

        initPickView(context,true);
    }

    /**
     * @param context
     * @param isShowHour 是否显示时分秒
     */
    public CustomTimeDialog(Context context,boolean isShowHour) {

        initPickView(context,isShowHour);
    }

    private void initPickView(Context context, final boolean isShowHour) {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        int year = TimeUtil.getYear();
        int month = TimeUtil.getMonth()-1;
        int day = TimeUtil.getDay();
        int hour = TimeUtil.getHour();
        int minute = TimeUtil.getMinute();
        int second = TimeUtil.getSecond();
        //正确设置方式 原因：注意事项有说明
        startDate.set(2000, 0, 1);
//        endDate.set(year, month, day,hour,minute,second);

        pvTime = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                onItemClickListener.onCustomDialogClickListener(dateToString(date,isShowHour));
            }
        })
                .setType(new boolean[]{true, true, true, isShowHour, isShowHour, isShowHour})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setTitleSize(20)//标题文字大小
                .setTitleText("")//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
                .setTitleColor(Color.LTGRAY)//标题文字颜色
                .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                .setCancelColor(Color.BLACK)//取消按钮文字颜色
                .setTitleBgColor(Color.LTGRAY)//标题背景颜色 Night mode
                .setBgColor(0xFFF1F1F5)//滚轮背景颜色 Night mode
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("-", "-", "", ":", ":", "")//默认设置为年月日时分秒
                .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();
    }

    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data,boolean isShowHour) {
        String formatType;
        if(isShowHour){
            formatType = "yyyy-MM-dd HH:mm:ss";
        }else {
            formatType = "yyyy-MM-dd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
        return simpleDateFormat.format(data);
    }

    public void showDialog() {
        if (pvTime != null && !pvTime.isShowing()) {
            pvTime.show();
        }

    }


    OnItemClickListener onItemClickListener;


    public void setOnCustomClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onCustomDialogClickListener(String value);
    }


}