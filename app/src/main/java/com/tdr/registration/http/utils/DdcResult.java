package com.tdr.registration.http.utils;


import lombok.Data;


@Data
public class DdcResult<T> {


    // 返回是否成功
    private Boolean success = false;
    // 返回信息
    private String msg = "操作成功";
    /**
     * 返回消息类型,用于复杂返回信息,0代表普通返回信息,1代表特殊返回信息
     */
    private Integer code = 0;

    private T data;

    private DdcPageInfo page;

}
