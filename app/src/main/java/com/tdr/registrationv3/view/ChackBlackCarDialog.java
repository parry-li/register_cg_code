package com.tdr.registrationv3.view;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


import com.tdr.registrationv3.R;
import com.tdr.registrationv3.adapter.BlackCarAdapter;
import com.tdr.registrationv3.bean.BlcakCarBean;
import com.tdr.registrationv3.utils.LogUtil;
import com.tdr.registrationv3.utils.UIUtils;

import java.util.List;


public class ChackBlackCarDialog {


    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private Activity context;
    private LinearLayoutManager hLinearLayoutManager;

    public ChackBlackCarDialog(Activity context) {
        this.context = context;
    }


    public void showCustomWindowDialog(List<BlcakCarBean> data) {


        final Dialog dialog = new Dialog(context, R.style.TANCStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        View convertView = LayoutInflater.from(context)
                .inflate(R.layout.dialog_chack_black_num, null);
        dialog.setContentView(convertView);


        TextView dialogAffirm = (TextView) convertView.findViewById(R.id.black_car_confirm);
        TextView dialogCancel = (TextView) convertView.findViewById(R.id.black_car_cancel);
        final TextView dialogNum = (TextView) convertView.findViewById(R.id.black_car_num);


        hLinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView dialogRv = convertView.findViewById(R.id.black_car_rv);
        dialogRv.setLayoutManager(hLinearLayoutManager);
        dialogRv.setHorizontalScrollBarEnabled(true);
        BlackCarAdapter blackNumAdapter = new BlackCarAdapter(data, context);
        dialogRv.setAdapter(blackNumAdapter);

        final int allSize = data.size();
        dialogNum.setText( "1/" + allSize);
        dialogRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (recyclerView != null && recyclerView.getChildCount() > 0) {
                    try {
                        int currentPosition = ((RecyclerView.LayoutParams) recyclerView.getChildAt(0).getLayoutParams()).getViewAdapterPosition();
                        LogUtil.i("=====currentPosition", "" + currentPosition);
                        dialogNum.setText((currentPosition+1) + "/" + allSize);
                    } catch (Exception e) {
                    }
                }

            }
        });


        // 添加PagerSnapHelper


        PagerSnapHelper snapHelper = new PagerSnapHelper();

        snapHelper.attachToRecyclerView(dialogRv);


//        dialogRv.addItemDecoration(new LinePagerIndicatorDecoration());


        dialogAffirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (onItemClickListener != null) {
                    onItemClickListener.onCustomDialogClickListener();
                }
            }
        });

        dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (onCancelClickListener != null) {
                    onCancelClickListener.onCancelDialogClickListener();
                }
            }
        });

        WindowManager windowManager = context.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = (display.getWidth() - UIUtils.dp2px(40)); //设置宽度
        dialog.getWindow().setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

    }


    OnItemClickListener onItemClickListener;
    OnItemCancelClickListener onCancelClickListener;

    public void setOnCustomDialogClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnCancelDialogClickListener(OnItemCancelClickListener onCancelClickListener) {
        this.onCancelClickListener = onCancelClickListener;
    }

    public interface OnItemClickListener {
        void onCustomDialogClickListener();
    }

    public interface OnItemCancelClickListener {
        void onCancelDialogClickListener();
    }
}