package com.tdr.registration.utils;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registration.bean.PhotoConfigBean;
import com.tdr.registration.bean.VehicleConfigBean;
import com.tdr.registration.constants.BaseConstants;

public class ConfigUtil {

    public static VehicleConfigBean getVehicleConfig() {
        try {
            String VehicleConfigJson = SPUtils.getInstance().getString(BaseConstants.VehicleConfig);
            VehicleConfigBean configBean = new Gson().fromJson(VehicleConfigJson, VehicleConfigBean.class);
            return configBean;
        } catch (Exception e) {
            ToastUtil.showWX(e.getMessage());
        }
        return null;
    }

    public static PhotoConfigBean getPhotoConfig() {
        try {
            String PhotoConfigJson = SPUtils.getInstance().getString(BaseConstants.PhotoConfig);
            PhotoConfigBean configBean = new Gson().fromJson(PhotoConfigJson, PhotoConfigBean.class);
            return configBean;
        } catch (Exception e) {
            ToastUtil.showWX(e.getMessage());
        }
        return null;
    }
}
