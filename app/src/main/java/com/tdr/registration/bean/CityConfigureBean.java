package com.tdr.registration.bean;

public class CityConfigureBean {


    /**
     * subsystemId : 1
     * content : null
     * subsystemName : null
     * name : URL
     * configureName : 子系统URL
     * configureAttribute : 3
     * plateform : 5
     * isSubsystem : 1
     */

    private int subsystemId;
    private Object content;
    private Object subsystemName;
    private String name;
    private String configureName;
    private int configureAttribute;
    private String plateform;
    private int isSubsystem;

    public int getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(int subsystemId) {
        this.subsystemId = subsystemId;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getSubsystemName() {
        return subsystemName;
    }

    public void setSubsystemName(Object subsystemName) {
        this.subsystemName = subsystemName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfigureName() {
        return configureName;
    }

    public void setConfigureName(String configureName) {
        this.configureName = configureName;
    }

    public int getConfigureAttribute() {
        return configureAttribute;
    }

    public void setConfigureAttribute(int configureAttribute) {
        this.configureAttribute = configureAttribute;
    }

    public String getPlateform() {
        return plateform;
    }

    public void setPlateform(String plateform) {
        this.plateform = plateform;
    }

    public int getIsSubsystem() {
        return isSubsystem;
    }

    public void setIsSubsystem(int isSubsystem) {
        this.isSubsystem = isSubsystem;
    }
}
