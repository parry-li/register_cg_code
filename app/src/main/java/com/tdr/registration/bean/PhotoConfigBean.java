package com.tdr.registration.bean;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.List;

public class PhotoConfigBean {

    /**
     * id : 13
     * isEnableAlbum : 2
     * photoTypeInfoList : [{"isRequire":true,"isValid":true,"photoIndex":1,"photoName":"车辆前侧身照","photoType":1},{"isRequire":true,"isValid":true,"photoIndex":2,"photoName":"车辆证件照","photoType":2}]
     */

    private int id;
    private int isEnableAlbum;
    private List<PhotoTypeInfoListBean> photoTypeInfoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsEnableAlbum() {
        return isEnableAlbum;
    }

    public void setIsEnableAlbum(int isEnableAlbum) {
        this.isEnableAlbum = isEnableAlbum;
    }

    public List<PhotoTypeInfoListBean> getPhotoTypeInfoList() {
        return photoTypeInfoList;
    }

    public void setPhotoTypeInfoList(List<PhotoTypeInfoListBean> photoTypeInfoList) {
        this.photoTypeInfoList = photoTypeInfoList;
    }

    public static class PhotoTypeInfoListBean {
        /**
         * isRequire : true
         * isValid : true
         * photoIndex : 1
         * photoName : 车辆前侧身照
         * photoType : 1
         */

        private boolean isRequire;
        private boolean isValid;
        private int photoIndex;
        private String photoName;
        private int photoType;
        private boolean isMust;
        private String photoId;
        private Drawable drawable;


        public Drawable getDrawable() {
            return drawable;
        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }

        public String getPhotoId() {
            return photoId;
        }

        public void setPhotoId(String photoId) {
            this.photoId = photoId;
        }

        public boolean isMust() {
            return isMust;
        }

        public void setMust(boolean must) {
            isMust = must;
        }

        public boolean isIsRequire() {
            return isRequire;
        }

        public void setIsRequire(boolean isRequire) {
            this.isRequire = isRequire;
        }

        public boolean isIsValid() {
            return isValid;
        }

        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }

        public int getPhotoIndex() {
            return photoIndex;
        }

        public void setPhotoIndex(int photoIndex) {
            this.photoIndex = photoIndex;
        }

        public String getPhotoName() {
            return photoName;
        }

        public void setPhotoName(String photoName) {
            this.photoName = photoName;
        }

        public int getPhotoType() {
            return photoType;
        }

        public void setPhotoType(int photoType) {
            this.photoType = photoType;
        }
    }
}
