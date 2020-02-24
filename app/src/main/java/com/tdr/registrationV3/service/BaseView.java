package com.tdr.registrationV3.service;



public interface BaseView<T> {
    void loadingSuccessForData(T mData);
    void loadingFail(String msg);


}
