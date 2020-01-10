package com.tdr.registration.presenter;



public interface BaseView<T> {
    void loadingSuccessForData(T mData);
    void loadingFail(String msg);


}
