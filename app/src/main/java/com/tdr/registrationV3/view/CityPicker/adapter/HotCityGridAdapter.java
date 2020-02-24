package com.tdr.registrationV3.view.CityPicker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.tdr.registrationV3.R;
import com.tdr.registrationV3.bean.HomeTagBean;

import java.util.List;

/**
 * author zaaach on 2016/1/26.
 */
public class HotCityGridAdapter extends BaseAdapter {
    private Context mContext;
//    private List<String> mCities;
    private  List<HomeTagBean.DataBean.HotcityBean> hotcityBeans;

    public HotCityGridAdapter(Context context, List<HomeTagBean.DataBean.HotcityBean> hotcityBeans) {
        this.mContext = context;
        this.hotcityBeans = hotcityBeans;
//        mCities = new ArrayList<>();
//
//
//
//        mCities.add("北京");
//        mCities.add("上海");
//        mCities.add("广州");
//        mCities.add("深圳");
//        mCities.add("杭州");
//        mCities.add("南京");
//        mCities.add("天津");
//        mCities.add("武汉");
//        mCities.add("重庆");
    }

    @Override
    public int getCount() {
        return hotcityBeans == null ? 0 : hotcityBeans.size();
    }

    @Override
    public String getItem(int position) {
        return hotcityBeans == null ? null : hotcityBeans.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        HotCityViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.cp_item_hot_city_gridview, parent, false);
            holder = new HotCityViewHolder();
            holder.name = (TextView) view.findViewById(R.id.tv_hot_city_name);
            view.setTag(holder);
        }else{
            holder = (HotCityViewHolder) view.getTag();
        }
        holder.name.setText(hotcityBeans.get(position).getName());
        return view;
    }

    public static class HotCityViewHolder{
        TextView name;
    }
}
