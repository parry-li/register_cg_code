package com.tdr.registration;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class AppConstants {

    /* 测试服务器*/


//    public static final String main_host_service = "http://183.129.130.119:13140/";
    public static final String main_host_service = " http://192.168.30.9:8089/";

    public static boolean isAllowLog = true;




    /*=====================================================*/

    public static final String Authentication_Login = "api/dc/Authentication/Login";
    public static final String Pet_Violate = "api/dc/Pet/Violate";
    public static final String Pet_PetsQuery = "api/dc/Pet/PetsQuery";
    public static final String Picture_Get = "api/dc/Picture/Get";
    public static final String Authentication_ChangePwd = "api/dc/SysConfig/ChangePwd";




    public static final String token = "token";
    public static final String name = "name";
    public static final String qm = "qm";


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


}
