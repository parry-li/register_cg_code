package com.tdr.registrationV3.bean;

import java.util.List;

public class BlcakCarBean {


    /**
     * id : 1579395071326
     * plateNumber : 1234
     * vehicleBrandName : null
     * vehicleBrand : 11123
     * colorId : 3
     * colorName : null
     * colorSecondId : 3
     * colorSecondName : null
     * engineNumber : 123
     * shelvesNumber : 123
     * vehicleType : 1
     * ownerName : 13
     * photoList : [{"index":1,"photo":"bcf89084042f337439d39d754f146939","photoType":1},{"index":2,"photo":"29690c1e3ddc6569b28df2a662072f5a","photoType":2}]
     * photoLists : [{"index":1,"photoType":1,"photo":"bcf89084042f337439d39d754f146939","photoName":null},{"index":2,"photoType":2,"photo":"29690c1e3ddc6569b28df2a662072f5a","photoName":null}]
     */

    private long id;
    private String plateNumber;
    private String vehicleBrandName;
    private String vehicleBrand;
    private String colorId;
    private String colorName;
    private String colorSecondId;
    private String colorSecondName;
    private String engineNumber;
    private String shelvesNumber;
    private int vehicleType;
    private String ownerName;
    private String photoList;
    private List<PhotoListsBean> photoLists;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public void setVehicleBrandName(String vehicleBrandName) {
        this.vehicleBrandName = vehicleBrandName;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorSecondId() {
        return colorSecondId;
    }

    public void setColorSecondId(String colorSecondId) {
        this.colorSecondId = colorSecondId;
    }

    public String getColorSecondName() {
        return colorSecondName;
    }

    public void setColorSecondName(String colorSecondName) {
        this.colorSecondName = colorSecondName;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getShelvesNumber() {
        return shelvesNumber;
    }

    public void setShelvesNumber(String shelvesNumber) {
        this.shelvesNumber = shelvesNumber;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhotoList() {
        return photoList;
    }

    public void setPhotoList(String photoList) {
        this.photoList = photoList;
    }

    public List<PhotoListsBean> getPhotoLists() {
        return photoLists;
    }

    public void setPhotoLists(List<PhotoListsBean> photoLists) {
        this.photoLists = photoLists;
    }

    public static class PhotoListsBean {
        /**
         * index : 1
         * photoType : 1
         * photo : bcf89084042f337439d39d754f146939
         * photoName : null
         */

        private int index;
        private int photoType;
        private String photo;
        private String photoName;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getPhotoType() {
            return photoType;
        }

        public void setPhotoType(int photoType) {
            this.photoType = photoType;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getPhotoName() {
            return photoName;
        }

        public void setPhotoName(String photoName) {
            this.photoName = photoName;
        }
    }
}
