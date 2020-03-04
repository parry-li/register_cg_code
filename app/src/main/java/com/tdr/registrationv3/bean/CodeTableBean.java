package com.tdr.registrationv3.bean;

public class CodeTableBean {
    public CodeTableBean(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * id : 4119
     * code : 11117
     * name : 测试2323232332
     * type : 1
     * remark :
     * sort : 0
     * createTime : 2020-01-03 16:07:58
     * updateTime : 2020-01-03 17:00:20
     * isDelete : 0
     */

    private int id;
    private String code;
    private String name;
    private int type;
    private String remark;
    private int sort;
    private String createTime;
    private String updateTime;
    private int isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
