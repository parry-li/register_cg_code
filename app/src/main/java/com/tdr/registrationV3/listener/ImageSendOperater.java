package com.tdr.registrationV3.listener;

public class ImageSendOperater {
    private ImageSendLister mListener;

//一定要设置这个监听方法

    public void setListener(ImageSendLister listener){

        mListener = listener;

    }

//要有一个方法触发listener中的方法，此处即是doSomething（）

    public void sendResult(Boolean isSuccess,int position,String photoId){

        if(mListener!=null){

            mListener.imageSendResult(isSuccess,position,photoId);

        }

    }

}
