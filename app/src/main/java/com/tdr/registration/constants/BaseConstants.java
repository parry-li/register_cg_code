package com.tdr.registration.constants;

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
    //    public static final int STATE_SUCCESS = 4;

    public static final int STATE_SUCCESS12 = 4;
    /*蓝牙id  目前在用*/
    public final static String ServiceUUID = "0000ffe0-0000-1000-8000-00805f9b34fb";

    /*备案登记权限码*/
    public final static String[] funJurisdiction = {
            "1", //车辆报废0
            "2",//车牌补办1
            "3", //车辆过户2
            "4",//车辆布控3
            "5",//车辆发还4
            "6",//服务延期5
            "7",//车辆预登记6
            "8",//备案统计7
            "9", //预登记查询8
            "10",//预登记统计9
            "11",//蓄电池备案10
            "12",//蓄电池查询11
            "13"//车辆查询12
    };


    public static final String token = "token";
    public static final String data = "register_data";
    public static final String BillConfig = "BillConfig";
    public static final String MapConfig = "MapConfig";
    public static final String VehicleConfig = "VehicleConfig";
    public static final String PhotoConfig = "PhotoConfig";
    public static final String NbLabelConfig = "NbLabelConfig";
    public static final String RegisterConfig = "RegisterConfig";
    public static final String ManagerConfig = "ManagerConfig";
    public static final String AuditConfig = "AuditConfig";

    public static final String KEY_PICKED_CITY_NAME = "picked_city_name";
    public static final String KEY_PICKED_CITY_VALUE = "picked_city_value";

    public static final String Login_city_name = "Login_city_name";
    public static final String Login_city_systemID = "Login_city_systemID";
    public static final String Login_name = "Login_name";
    public static final String code_table = "code_table";


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
