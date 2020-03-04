package com.tdr.registrationv3.constants;

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
    /*查询车辆*/
    public static final String electriccars_editInfo = main_host_service + "api/ddc-electriccar/electriccars/editInfo";
    /*信息变更*/
    public static final String electriccars_edit = main_host_service + "api/ddc-electriccar/electriccars/edit";
    /*获取保险变更*/
    public static final String policy_edit = main_host_service + "api/ddc-electriccar/policy/edit";
    /*获取保险新保*/
    public static final String policy_getNewInsuranceConfigs = main_host_service + "api/ddc-electriccar/policy/getNewInsuranceConfigs";
    /*获取保险续保*/
    public static final String policy_getRenewInsuranceConfigs = main_host_service + "api/ddc-electriccar/policy/getRenewInsuranceConfigs";
    /*保险变更*/
    public static final String policy_insured = main_host_service + "api/ddc-electriccar/policy/insured";
    /*保险变更*/
    public static final String user_updatePwd = main_host_service + "api/ddc-user/user/updatePwd";
    /*待投保查询*/
    public static final String policy_failurePage = main_host_service + "api/ddc-electriccar/policy/failurePage";
    /*重新投保*/
    public static final String policy_reinsure = main_host_service + "api/ddc-electriccar/policy/reinsure";
    /*个人统计*/
    public static final String installSituation_query2User = main_host_service + "api/ddc-statistical-report/installSituation/query2User";
    /*备案统计*/
    public static final String installSituation_query2Unit = main_host_service + "api/ddc-statistical-report/installSituation/query2Unit";
    /*XI辖区列表*/
    public static final String unit_unitTreeByUnitNo = main_host_service + "api/ddc-service/unit/unitTreeByUnitNo";
    /*车辆信息*/
    public static final String electriccars_info = main_host_service + "api/ddc-electriccar/electriccars/info";
    /*黑车校验*/
    public static final String electriccars_checkBlackCar = main_host_service + "api/ddc-electriccar/electriccars/checkBlackCar";
    /*校验标签*/
    public static final String electriccars_checkOnlyOneLabel = main_host_service + "api/ddc-electriccar/electriccars/checkOnlyOneLabel";

}
