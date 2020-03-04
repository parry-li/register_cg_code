package com.tdr.registrationv3.service;



public interface BaseView<T> {
    void loadingSuccessForData(T mData);
    void loadingFail(String msg);
}
