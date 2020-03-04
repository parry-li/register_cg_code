package com.tdr.registrationv3.listener;

public class CustomSendOperater {
    private CustomSendLister mListener;

//一定要设置这个监听方法

    public void setListener(CustomSendLister listener){

        mListener = listener;

    }

//要有一个方法触发listener中的方法，此处即是doSomething（）

    public void sendResult(Boolean isSuccess,int position,String photoId){

        if(mListener!=null){

            mListener.sendResult(isSuccess,position,photoId);

        }

    }

}
