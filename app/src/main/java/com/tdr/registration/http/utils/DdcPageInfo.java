package com.tdr.registration.http.utils;


import lombok.Data;

/**
 * Created by parry
 */

@Data
public class DdcPageInfo {

    private Integer total;

    private Integer pageNum = 1;

    private Integer pageSize = 20;

    private long count;



}
