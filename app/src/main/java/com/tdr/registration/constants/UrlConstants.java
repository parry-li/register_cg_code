package com.tdr.registration.constants;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class UrlConstants {



    /* 测试服务器*/


    //    public static final String main_host_service = "http://183.129.130.119:13140/";
//    public static final String main_host_service = "http://10.1.30.113:8443/";
    public static final String main_host_service = "http://122.228.188.210:28443/";





    /*=====================================================*/

    public static final String cityConfigure_getCityList = main_host_service + "api/ddc-user/cityConfigure/getCityList";
    public static final String user_login = main_host_service + "api/ddc-user/user/login";
    public static final String cityConfigure_getCityConfigureBySubsystemId = main_host_service + "api/ddc-user/cityConfigure/getCityConfigureBySubsystemId";
    public static final String electriccarsChange_check = main_host_service + "api/ddc-electriccar/electriccarsChange/check";
    /*车牌补办登记*/
    public static final String electriccarsChange_register = main_host_service + "api/ddc-electriccar/electriccarsChange/register";
    /*照片上传*/
    public static final String zimgCommon_uploadMultFile = main_host_service + "api/ddc-service/zimgCommon/uploadMultFile";
    /*车辆过户*/
    public static final String electriccarsTransfer_add = main_host_service + "api/ddc-electriccar/electriccarsTransfer/add";
    /*字典数据*/
    public static final String codeTable_contentList = main_host_service + "api/ddc-service/codeTable/contentList";
    /*报废*/
    public static final String electriccarsScrap_add = main_host_service + "api/ddc-electriccar/electriccarsScrap/add";
    /*校验车牌*/
    public static final String electriccars_checkOnlyOnePlateNumber = main_host_service + "api/ddc-electriccar/electriccars/checkOnlyOnePlateNumber";
    /*获取保险*/
    public static final String configure_getInsuranceConfigs = main_host_service + "api/ddc-insurance/insurance/configure/getInsuranceConfigs";
    /*备案登记*/
    public static final String electriccars_registration = main_host_service + "api/ddc-electriccar/electriccars/registration";
    /*备案登记*/
    public static final String electriccars_editInfo = main_host_service + "api/ddc-electriccar/electriccars/editInfo";
    /*信息变更*/
    public static final String electriccars_edit = main_host_service + "api/ddc-electriccar/electriccars/edit";


}
