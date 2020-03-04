package com.tdr.registrationV3.constants;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class BaseConstants {


    /*布局*/
    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_SUCCESS = 4;

    public static final int BUX_SEND_CODE= 2001;
    public static final int STATE_SUCCESS12 = 4;
    /*蓝牙id  目前在用*/
    public final static String ServiceUUID = "0000ffe0-0000-1000-8000-00805f9b34fb";

    /*备案登记权限码*/
    public final static String[] funJurisdiction = {
            "1", //车辆报废0
            "2",//车牌补办1
            "3", //车辆过户2
            "6",//服务延期3
            "7",//服务购买4
            "8"//备案统计5

    };

    public static String APP_NAME = "com.tdr.register.";
    public static final String ERROR_MSG =APP_NAME+ "Exception";
    public static final String token = APP_NAME + "token";
    public static final String data = APP_NAME + "register_data";
    public static final String data2 = APP_NAME + "register_data2";
    public static final String rolePower = APP_NAME + "role_power";
    public static final String BillConfig = APP_NAME + "BillConfig";
    public static final String MapConfig = APP_NAME + "MapConfig";
    public static final String VehicleConfig = APP_NAME + "VehicleConfig";
    public static final String PhotoConfig = APP_NAME + "PhotoConfig";
    public static final String NbLabelConfig = APP_NAME + "NbLabelConfig";
    public static final String RegisterConfig = APP_NAME + "RegisterConfigBean";
    public static final String ManagerConfig = APP_NAME + "ManagerConfig";
    public static final String AuditConfig = APP_NAME + "AuditConfig";

    public static final String KEY_NAME = APP_NAME + "picked_name";
    public static final String KEY_VALUE = APP_NAME + "picked_value";
    public static final String KEY_VALUE2 = APP_NAME + "picked_value2";

    public static final String City_name = APP_NAME + "City_name";
    public static final String City_systemID = APP_NAME + "City_systemID";// int类型
    public static final String Login_unitName = APP_NAME + "Login_unitName";
    public static final String City_cityCode = APP_NAME + "City_cityCode";
    public static final String Login_unitNo = APP_NAME + "Login_unitNo";
    public static final String Login_unitType = APP_NAME + "Login_unitType";// int类型
    public static final String Login_name = APP_NAME + "Login_name";
    public static final String code_table = APP_NAME + "code_table";


    public static final String register_plate = "register_plate";
    public static final String register_brand = "register_brand";
    public static final String register_color1_id = "register_color1_id";
    public static final String register_color1_name = "register_color1_name";
    public static final String register_color2_name = "register_color2_name";
    public static final String register_color2_id = "register_color2_id";
    public static final String register_time = "register_time";
    public static final String register_frame = "register_frame";
    public static final String register_electrical = "register_electrical";


}
