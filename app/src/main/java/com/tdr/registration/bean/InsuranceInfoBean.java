package com.tdr.registration.bean;

public class InsuranceInfoBean {
    private int configId;
    private int packageId;

    public InsuranceInfoBean() {
    }

    public InsuranceInfoBean(int configId, int packageId) {
        this.configId = configId;
        this.packageId = packageId;
    }

    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }
}
