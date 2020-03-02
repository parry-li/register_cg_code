package com.tdr.registrationV3.utils;

import com.google.gson.Gson;
import com.parry.utils.code.SPUtils;
import com.tdr.registrationV3.bean.PhotoConfigBean;
import com.tdr.registrationV3.bean.RegisterConfigBean;
import com.tdr.registrationV3.bean.VehicleConfigBean;
import com.tdr.registrationV3.constants.BaseConstants;

public class ConfigUtil {

  /* [
    {
        "subsystemId": 13,
            "content": "{\"billType\":3,\"id\":66,\"isBill\":true}",
            "subsystemName": null,
            "name": "BillConfig",
            "configureName": "BillConfig",
            "configureAttribute": 4,
            "plateform": "5",
            "isSubsystem": 1
    },
    {
        "subsystemId": 13,
            "content": "{\"id\":67,\"isCityCenter\":true,\"isRoutTrack\":2,\"isTrackRepair\":2,\"lat\":\"113.66541\",\"lon\":\"34.757977\"}",
            "subsystemName": null,
            "name": "MapConfig",
            "configureName": "MapConfig",
            "configureAttribute": 4,
            "plateform": "5",
            "isSubsystem": 1
    },
    {
        "subsystemId": 13,
            "content": "{\"engineNoRegular\":{\"isRequire\":true,\"lenMax\":4,\"lenMin\":1},\"id\":68,\"shelvesNoRegular\":{\"isRequire\":true,\"lenMax\":6,\"lenMin\":2},\"vehicleLicenseInfoList\":[{\"index\":1,\"isValid\":true,\"typeId\":1,\"vehicleNbLableConfigList\":[{\"eqType\":[\"8023\",\"870F\"],\"index\":1,\"isRequired\":true,\"isValid\":true,\"lableName\":\"车辆标签\"},{\"eqType\":[\"8023\",\"8001\",\"8021\"],\"index\":2,\"isRequired\":true,\"isValid\":true,\"lableName\":\"NB标签\"}],\"vehicleNoLen\":6,\"vehicleNoReg\":\"^\\\\d{6}$\",\"vehicleNoRegularMsg\":\"123456\",\"vehicleNoRegularType\":1,\"vehicleTypeName\":\"电动车\"},{\"index\":3,\"isValid\":true,\"typeId\":3,\"vehicleNbLableConfigList\":[{\"eqType\":[\"8023\",\"870F\"],\"index\":1,\"isRequired\":true,\"isValid\":true,\"lableName\":\"车辆标签\"}],\"vehicleNoLen\":3,\"vehicleNoLenChineseMsg\":\"杭|温\",\"vehicleNoReg\":\"^(杭|温)[0-9A-Za-z]{3}$\",\"vehicleNoRegularMsg\":\"杭123\",\"vehicleNoRegularType\":3,\"vehicleTypeName\":\"摩托车\"}]}",
            "subsystemName": null,
            "name": "VehicleConfig",
            "configureName": "VehicleConfig",
            "configureAttribute": 4,
            "plateform": "5",
            "isSubsystem": 1
    },
    {
        "subsystemId": 13,
            "content": "{\"id\":69,\"isEnableAlbum\":2,\"photoTypeInfoList\":[{\"isRequire\":true,\"isValid\":true,\"photoIndex\":1,\"photoName\":\"前车照\",\"photoType\":1},{\"isRequire\":true,\"isValid\":true,\"photoIndex\":2,\"photoName\":\"证件照\",\"photoType\":2}]}",
            "subsystemName": null,
            "name": "PhotoConfig",
            "configureName": "PhotoConfig",
            "configureAttribute": 4,
            "plateform": "5",
            "isSubsystem": 1
    },
    {
        "subsystemId": 13,
            "content": "{\"detectNB\":2,\"id\":70,\"isBindRFLable\":2}",
            "subsystemName": null,
            "name": "NbLabelConfig",
            "configureName": "NbLabelConfig",
            "configureAttribute": 4,
            "plateform": "5",
            "isSubsystem": 1
    },
    {
        "subsystemId": 13,
            "content": "{\"blackCheck\":2,\"cardIdMax\":{\"dayNum\":1,\"isValid\":true,\"vehNum\":20},\"eqTypeModule\":4,\"id\":71}",
            "subsystemName": null,
            "name": "RegisterConfigBean",
            "configureName": "RegisterConfigBean",
            "configureAttribute": 4,
            "plateform": "5",
            "isSubsystem": 1
    },
    {
        "subsystemId": 13,
            "content": "{\"allowEditLeftDay\":0,\"allowInsureEditLeftDay\":0,\"id\":72}",
            "subsystemName": null,
            "name": "ManagerConfig",
            "configureName": "ManagerConfig",
            "configureAttribute": 4,
            "plateform": "5",
            "isSubsystem": 1
    },
    {
        "subsystemId": 13,
            "content": "{\"id\":73,\"isEnableBuzzer\":1}",
            "subsystemName": null,
            "name": "AuditConfig",
            "configureName": "AuditConfig",
            "configureAttribute": 4,
            "plateform": "5",
            "isSubsystem": 1
    }
]*/

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

    public static RegisterConfigBean getRegisterConfig() {
        try {
            String RegisterConfigJson = SPUtils.getInstance().getString(BaseConstants.RegisterConfig);
            RegisterConfigBean configBean = new Gson().fromJson(RegisterConfigJson, RegisterConfigBean.class);
            return configBean;
        } catch (Exception e) {
            ToastUtil.showWX(e.getMessage());
        }
        return null;
    }
}
