package com.tdr.registrationV3.bean;


import java.util.List;

public class CityBean {


    /**
     * cityCode : 4101
     * unitName : 郑州市
     * fullSpell : Zhengzhou
     * abbrSpell : ZZ
     * subsystemList : [{"id":1,"subsystemName":"1223"},{"id":4,"subsystemName":"新增测试子系统1"},{"id":6,"subsystemName":"子系统1"}]
     */

    private String cityCode;
    private String unitName;
    private String fullSpell;
    private String abbrSpell;
    private List<SubsystemListBean> subsystemList;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getFullSpell() {
        return fullSpell;
    }

    public void setFullSpell(String fullSpell) {
        this.fullSpell = fullSpell;
    }

    public String getAbbrSpell() {
        return abbrSpell;
    }

    public void setAbbrSpell(String abbrSpell) {
        this.abbrSpell = abbrSpell;
    }

    public List<SubsystemListBean> getSubsystemList() {
        return subsystemList;
    }

    public void setSubsystemList(List<SubsystemListBean> subsystemList) {
        this.subsystemList = subsystemList;
    }

    public static class SubsystemListBean {
        /**
         * id : 1
         * subsystemName : 1223
         */

        private int id;
        private String subsystemName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSubsystemName() {
            return subsystemName;
        }

        public void setSubsystemName(String subsystemName) {
            this.subsystemName = subsystemName;
        }
    }
}
