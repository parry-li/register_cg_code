package com.tdr.registrationv3.view;


import android.app.Activity;

import android.text.TextUtils;

import android.view.View;

import android.widget.ImageView;

import android.widget.TextView;


import com.parry.pickerview.builder.OptionsPickerBuilder;
import com.parry.pickerview.listener.CustomListener;
import com.parry.pickerview.listener.OnOptionsSelectListener;
import com.parry.pickerview.view.OptionsPickerView;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.utils.UIUtils;


import java.util.List;


/**
 * @author parry
 * @time 2017/6/7/007 14:20
 * @des ${TODO}
 */

public class CustomOptionsDialog<T> {


    private OptionsPickerView pvOptions;
    private TextView tvTitle;

    public CustomOptionsDialog(Activity activity) {

        initPickView(activity, null);
    }

    private Activity activity;

    public CustomOptionsDialog(Activity activity, String title) {

        initPickView(activity, title);
    }

    private void initPickView(Activity activity, final String title) {
        pvOptions = new OptionsPickerBuilder(activity, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                onItemClickListener.onCustomDialogClickListener(options1, option2, options3);
            }
        })
                .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        //自定义布局中的控件初始化及事件处理
                        tvTitle = (TextView) v.findViewById(R.id.tv_title);
                        final TextView tvConfirm = (TextView) v.findViewById(R.id.tv_confirm);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
//                        View contentView = (View) v.findViewById(R.id.content_view);
//                        if (hight != -1000) {
//                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
//                            contentView.setLayoutParams(params);
//                        }

                        if (!TextUtils.isEmpty(title)) {
                            tvTitle.setText(title);
                        }
                        tvConfirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(UIUtils.isFastClick()){
                                    pvOptions.returnData();
                                    pvOptions.dismiss();
                                }

                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvOptions.dismiss();
                            }
                        });

                    }
                })
                .setOutSideCancelable(false)//点击外部dismiss default true
                .build();

    }

    public void setTitle(String title) {
        tvTitle.setText("请选择" + title);
    }

    public void setSelectOptions(int option1) {
        pvOptions.setSelectOptions(option1);
    }


    public void setSelectOptions(int option1, int option2) {
        pvOptions.setSelectOptions(option1, option2);
    }

    public void setSelectOptions(int option1, int option2, int option3) {
        pvOptions.setSelectOptions(option1, option2, option3);
    }

    public void setPickerData(List<T> options1Items) {
        if (pvOptions != null) {

            pvOptions.setPicker(options1Items);
        }

    }

    public void setPickerData(List<T> options1Items, List<List<T>> options2Items) {
        if (pvOptions != null) {
            pvOptions.setPicker(options1Items, options2Items);
        }

    }

    public void setPickerData(List<T> options1Items, List<List<T>> options2Items,
                              List<List<List<T>>> options3Items) {
        if (pvOptions != null) {

            pvOptions.setPicker(options1Items, options2Items, options3Items);
        }

    }


    public void setNpPickerData(List<T> options1Items, List<T> options2Items,
                                List<T> options3Items) {
        if (pvOptions != null) {

            pvOptions.setNPicker(options1Items, options2Items, options3Items);
        }

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
        void onCustomDialogClickListener(int options1, int options2, int options3);
    }


//    /**
//     * 横屏可通过 widthPixels - widthPixels2 > 0 来判断底部导航栏是否存在
//     *
//     * @param windowManager
//     * @return true表示有虚拟导航栏 false没有虚拟导航栏
//     */
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
//    public boolean isNavigationBarShow(WindowManager windowManager) {
//
//        Display defaultDisplay = windowManager.getDefaultDisplay();
//        //获取屏幕高度
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        defaultDisplay.getRealMetrics(outMetrics);
//        int heightPixels = outMetrics.heightPixels;
//        //宽度
//        int widthPixels = outMetrics.widthPixels;
//
//
//        //获取内容高度
//        DisplayMetrics outMetrics2 = new DisplayMetrics();
//        defaultDisplay.getMetrics(outMetrics2);
//        int heightPixels2 = outMetrics2.heightPixels;
//        //宽度
//        int widthPixels2 = outMetrics2.widthPixels;
//
//        return heightPixels - heightPixels2 > 0 || widthPixels - widthPixels2 > 0;
//    }
//
//
//    public int getBarHight(Context context) {
//        try {
//            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
//            Object object = clazz.newInstance();
//            String heightStr = clazz.getField("navigation_bar_height").get(object).toString();
//            int height = Integer.parseInt(heightStr);
//            //dp--->px
//            int statusHeight = context.getResources().getDimensionPixelSize(height);
//            return statusHeight;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return -1000;
//    }
}