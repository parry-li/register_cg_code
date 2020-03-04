package com.tdr.registrationv3.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.parry.pickerview.builder.OptionsPickerBuilder;
import com.parry.pickerview.listener.CustomListener;
import com.parry.pickerview.listener.OnOptionsSelectListener;
import com.parry.pickerview.view.OptionsPickerView;
import com.tdr.registrationv3.R;


import java.util.List;


/**
 * @author parry
 * @time 2017/6/7/007 14:20
 * @des ${TODO}
 */

public class CustomOptionsDialog<T> {


    private OptionsPickerView pvOptions;
    private TextView tvTitle;

    public CustomOptionsDialog(Context context) {

        initPickView(context, null);
    }

    public CustomOptionsDialog(Context context, String title) {

        initPickView(context, title);
    }

    private void initPickView(Context context, final String title) {
        pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
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
                        if (!TextUtils.isEmpty(title)) {
                            tvTitle.setText(title);
                        }
                        tvConfirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvOptions.returnData();
                                pvOptions.dismiss();
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
                .build();

    }
    public void setTitle(String title){
        tvTitle.setText("请选择"+title);
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


}