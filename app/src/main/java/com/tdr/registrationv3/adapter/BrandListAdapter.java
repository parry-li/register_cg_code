package com.tdr.registrationv3.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tdr.registrationv3.R;
import com.tdr.registrationv3.bean.CodeTableBean;

import java.util.ArrayList;
import java.util.List;

public class BrandListAdapter extends BaseAdapter {
    private static  int VIEW_TYPE_COUNT = 2;

    private Context mConext;
    private List<CodeTableBean> sortModels;
    private List<CodeTableBean> hotModels;
    private LayoutInflater mInflater;


    public BrandListAdapter(Context mConext, List<CodeTableBean> sortModels) {
        this.mConext = mConext;
        this.sortModels = sortModels;
        this.hotModels = sortModels;
        this.mInflater = LayoutInflater.from(mConext);
        sortModels.add(0, new CodeTableBean("-100", "全部"));
        sortModels.add(1, new CodeTableBean("-100", "全部"));

    }




    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void setNewData(List<CodeTableBean> list) {
        this.sortModels = list;
        if (sortModels.size() > 0) {
            sortModels.add(list.get(0));
        }
        notifyDataSetChanged();
    }


    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return position < VIEW_TYPE_COUNT - 1 ? position : VIEW_TYPE_COUNT - 1;
    }

    @Override
    public int getCount() {
        return sortModels.size();
    }

    @Override
    public Object getItem(int position) {
        return sortModels == null ? null : sortModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public static class BrandViewHolder {
        TextView allName;
        TextView allType;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        BrandViewHolder holder;
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                try {
                    convertView = mInflater.inflate(R.layout.item_code_hot_rv, null);
                    RecyclerView gridView = (RecyclerView) convertView.findViewById(R.id.hot_rv);
                    int hotSubSize;
                    if (hotModels.size() > 50) {
                        hotSubSize = 12;
                    } else  if (hotModels.size() < 50&&hotModels.size()>3) {
                        hotSubSize =3;
                    }else {
                        hotSubSize = hotModels.size();
                    }
                    List<CodeTableBean> sortModels = new ArrayList<>();
                    try {
                        sortModels = hotModels.subList(2, hotSubSize+2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    CodeTableHotAdapter hotAdapter = new CodeTableHotAdapter(sortModels);
                    gridView.setLayoutManager(new GridLayoutManager(mConext, 3));
                    gridView.setAdapter(hotAdapter);
                    hotAdapter.setOnItemClickListener(new CodeTableHotAdapter.OnItemConfirmClickListener() {
                        @Override
                        public void onItemClickListener(CodeTableBean tableBean) {

                            if (confirmClickListener != null) {
                                confirmClickListener.onItemClickListener(tableBean);
                            }
                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 1:
                if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.item_code_all, parent, false);
                    holder = new BrandViewHolder();
                    holder.allType = (TextView) convertView.findViewById(R.id.all_type);
                    holder.allName = (TextView) convertView.findViewById(R.id.all_name);
                    convertView.setTag(holder);
                } else {
                    holder = (BrandViewHolder) convertView.getTag();
                }
                if (position >= 1) {
                    final String brandName = sortModels.get(position).getName();


                    if (sortModels.get(position).getCode().equals("-100")) {
                        holder.allType.setVisibility(View.VISIBLE);
                        holder.allName.setVisibility(View.GONE);
                    } else {
                        holder.allName.setText(brandName);
                        holder.allType.setVisibility(View.GONE);
                        holder.allName.setVisibility(View.VISIBLE);
                    }
                    holder.allName.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(position>1){
                                if (confirmClickListener != null) {
                                    confirmClickListener.onItemClickListener(sortModels.get(position));
                                }
                            }

                        }
                    });
                }
                break;

        }
        return convertView;
    }

    OnItemConfirmClickListener confirmClickListener;

    public void setOnItemClickListener(OnItemConfirmClickListener confirmClickListener) {
        this.confirmClickListener = confirmClickListener;
    }

    public interface OnItemConfirmClickListener {
        void onItemClickListener(CodeTableBean tableBean);
    }


}
