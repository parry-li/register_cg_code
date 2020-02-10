package com.tdr.registration.bean;

import java.util.List;

public class RegisterPutBean {

    private int vehicleType;
    private String registerPlate;
    private String registerBrand;
    private String registerBrandCode;
    private String registerFrame;
    private String registerElectrical;
    private String registerColor1Name;
    private String registerColor1Id;
    private String registerColor2Name;
    private String registerColor2Id;
    private String registerTime;
    private String registerPrice;
    private String peopleName;
    private String peopleCardType;
    private String peopleCardNum;
    private String peoplePhone1;
    private String peoplePhone2;
    private String peopleAddr;
    private String peopleRemark;
    private List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> lableList;
    private List<PhotoConfigBean.PhotoTypeInfoListBean> photoList;

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegisterBrandCode() {
        return registerBrandCode;
    }

    public void setRegisterBrandCode(String registerBrandCode) {
        this.registerBrandCode = registerBrandCode;
    }

    public String getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(String registerPrice) {
        this.registerPrice = registerPrice;
    }

    public String getRegisterPlate() {
        return registerPlate;
    }

    public void setRegisterPlate(String registerPlate) {
        this.registerPlate = registerPlate;
    }

    public String getRegisterBrand() {
        return registerBrand;
    }

    public void setRegisterBrand(String registerBrand) {
        this.registerBrand = registerBrand;
    }

    public String getRegisterFrame() {
        return registerFrame;
    }

    public void setRegisterFrame(String registerFrame) {
        this.registerFrame = registerFrame;
    }

    public String getRegisterElectrical() {
        return registerElectrical;
    }

    public void setRegisterElectrical(String registerElectrical) {
        this.registerElectrical = registerElectrical;
    }

    public String getRegisterColor1Name() {
        return registerColor1Name;
    }

    public void setRegisterColor1Name(String registerColor1Name) {
        this.registerColor1Name = registerColor1Name;
    }

    public String getRegisterColor1Id() {
        return registerColor1Id;
    }

    public void setRegisterColor1Id(String registerColor1Id) {
        this.registerColor1Id = registerColor1Id;
    }

    public String getRegisterColor2Name() {
        return registerColor2Name;
    }

    public void setRegisterColor2Name(String registerColor2Name) {
        this.registerColor2Name = registerColor2Name;
    }

    public String getRegisterColor2Id() {
        return registerColor2Id;
    }

    public void setRegisterColor2Id(String registerColor2Id) {
        this.registerColor2Id = registerColor2Id;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleCardType() {
        return peopleCardType;
    }

    public void setPeopleCardType(String peopleCardType) {
        this.peopleCardType = peopleCardType;
    }

    public String getPeopleCardNum() {
        return peopleCardNum;
    }

    public void setPeopleCardNum(String peopleCardNum) {
        this.peopleCardNum = peopleCardNum;
    }

    public String getPeoplePhone1() {
        return peoplePhone1;
    }

    public void setPeoplePhone1(String peoplePhone1) {
        this.peoplePhone1 = peoplePhone1;
    }

    public String getPeoplePhone2() {
        return peoplePhone2;
    }

    public void setPeoplePhone2(String peoplePhone2) {
        this.peoplePhone2 = peoplePhone2;
    }

    public String getPeopleAddr() {
        return peopleAddr;
    }

    public void setPeopleAddr(String peopleAddr) {
        this.peopleAddr = peopleAddr;
    }

    public String getPeopleRemark() {
        return peopleRemark;
    }

    public void setPeopleRemark(String peopleRemark) {
        this.peopleRemark = peopleRemark;
    }

    public List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> getLableList() {
        return lableList;
    }

    public void setLableList(List<VehicleConfigBean.VehicleLicenseInfoListBean.VehicleNbLableConfigListBean> lableList) {
        this.lableList = lableList;
    }

    public List<PhotoConfigBean.PhotoTypeInfoListBean> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PhotoConfigBean.PhotoTypeInfoListBean> photoList) {
        this.photoList = photoList;
    }
}
