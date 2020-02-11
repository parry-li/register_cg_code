package com.tdr.registration.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tdr.registration.R;
import com.tdr.registration.bean.CheckBean;
import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.bean.ItemModel;
import com.tdr.registration.bean.VehicleConfigBean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class InsuranceAdapter extends BaseQuickAdapter<InsuranceBean, BaseViewHolder> {

    private Context context;

       private RecyclerView recycleView;
    public InsuranceAdapter(Context context, List<InsuranceBean> data,RecyclerView recycleView) {
        super(R.layout.item_insurance, data);
        this.context = context;
        this.recycleView = recycleView;

    }

    @Override
    protected void convert(final BaseViewHolder helper, final InsuranceBean item) {
        helper.setText(R.id.insurance_name, item.getName());
        helper.setText(R.id.insurance_label, item.getSubtitle());
        RecyclerView insuranceRv = helper.getView(R.id.insurance_Rv);
        CheckBox insuranceCb = helper.getView(R.id.insurance_cb);
        insuranceRv.setLayoutManager(new GridLayoutManager(context, 3));


        final InsuranceTypeAdapter changTypeAdapter = new InsuranceTypeAdapter(item.getPackages());
        insuranceRv.setAdapter(changTypeAdapter);
        changTypeAdapter.setRecycleView(insuranceRv);
        changTypeAdapter.setOnItemClickListener(new InsuranceTypeAdapter.OnItemChangeClickListener() {
            @Override
            public void onItemChangeClickListener(int position) {
                List<CheckBean> list = changTypeAdapter.getCheckBox();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isCheck()) {
                        getData().get(helper.getAdapterPosition()).getPackages().get(i).setCheck(true);
                    } else {
                        getData().get(helper.getAdapterPosition()).getPackages().get(i).setCheck(false);
                    }
                }

                notifyChange();

            }
        });
        insuranceCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b){
                    changTypeAdapter.initCheckBox();
                    int mSize = getData().get(helper.getAdapterPosition()).getPackages().size();
                    for (int i = 0; i < mSize; i++) {
                        getData().get(helper.getAdapterPosition()).getPackages().get(i).setCheck(false);
                    }
                }

            }
        });

        boolean isPackagesCheck = false;
        for (InsuranceBean.PackagesBean packagesBean : getData().get(helper.getAdapterPosition()).getPackages()) {

            if (packagesBean.isCheck()) {
                isPackagesCheck = true;
                break;
            }
        }



        /*必选*/
        if (item.getIsChoose() == 1) {
            insuranceCb.setChecked(true);
            insuranceCb.setEnabled(false);
            helper.setText(R.id.insurance_name, item.getName() + "  (必选)");
        } else {
            if (isPackagesCheck) {
                insuranceCb.setChecked(true);
            } else {
                insuranceCb.setChecked(false);
            }

            helper.setText(R.id.insurance_name, item.getName());
        }
    }

    private void notifyChange(){
        if (recycleView.isComputingLayout()) {
            recycleView.post(new Runnable() {
                @Override
                public void run() {
                    notifyDataSetChanged();
                }
            });
        } else {
            notifyDataSetChanged();
        }
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(String rolePower, int position);
    }
}
