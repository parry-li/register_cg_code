package com.tdr.registrationV3.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parry.pickerview.builder.TimePickerBuilder;
import com.parry.pickerview.listener.CustomListener;
import com.parry.pickerview.listener.OnTimeSelectListener;
import com.parry.pickerview.view.TimePickerView;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.utils.TimeUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @author parry
 * @time 2017/6/7/007 14:20
 * @des ${TODO}
 */

public class CustomTimeDialog {

    private TimePickerView pvTime;
    private TextView tvTitle;


    public CustomTimeDialog(Context context) {

        initPickView(context, true, "请选择时间");
    }

    /**
     * @param context
     * @param isShowHour 是否显示时分秒
     */
    public CustomTimeDialog(Context context, boolean isShowHour) {

        initPickView(context, isShowHour, "请选择时间");
    }

    /**
     * @param context
     * @param isShowHour 是否显示时分秒
     */
    public CustomTimeDialog(Context context, boolean isShowHour, String title) {

        initPickView(context, isShowHour, title);
    }

    /**
     * @param context
     *
     */
    public CustomTimeDialog(Context context, String title) {

        initPickView(context, true, title);
    }

    private void initPickView(Context context, final boolean isShowHour, final String title) {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        int year = TimeUtil.getYear();
        int month = TimeUtil.getMonth() - 1;
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
                onItemClickListener.onCustomDialogClickListener(dateToString(date, isShowHour));
            }
        }).setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(final View v) {

                        //自定义布局中的控件初始化及事件处理
                       tvTitle = (TextView) v.findViewById(R.id.tv_title);
                        final TextView tvConfirm = (TextView) v.findViewById(R.id.tv_confirm);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        if (!TextUtils.isEmpty(title)) {
                            tvTitle.setText(title);
                        }
                        tvConfirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvTime.returnData();
                                pvTime.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvTime.dismiss();
                            }
                        });


                    }


                })
                .setLabel("-", "-", "", ":", ":", "")//默认设置为年月日时分秒
                .setType(new boolean[]{true, true, true, isShowHour, isShowHour, isShowHour})
                .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(context.getResources().getColor(R.color.module_main))
                .build();
    }

    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, boolean isShowHour) {
        String formatType;
        if (isShowHour) {
            formatType = "yyyy-MM-dd HH:mm:ss";
        } else {
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

    public void setTitle(String title){
        tvTitle.setText("请选择"+title);
    }

    OnItemClickListener onItemClickListener;


    public void setOnCustomClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onCustomDialogClickListener(String value);
    }


}