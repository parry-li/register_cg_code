package com.tdr.registration.service;



public interface BaseView<T> {
    void loadingSuccessForData(T mData);
    void loadingFail(String msg);


}
