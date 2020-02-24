package com.tdr.registrationV3.bean;

import java.util.List;

public class QueryBean {

    /**
     * Code : 0
     * Msg :
     * Data : [{"PetOwner":{"OWNER_ID":"6be0ea5b-7db2-4005-a693-1ae247d178b9","IDENTITY_TYPE":5,"IDENTITY_CARD":"354564","CHINESE_NAME":"朱瑞","BIRTH":"2019-07-18 00:00:00","SEX":1,"PHONE":"15959595656","AREA_CODE":"370829","ADDRESS":"去听","EMERGECY_NAME":"去鸡鸡","EMERGECY_PHONE":"15067881072","OPERATE_TIME":"2019-07-23 19:58:08"},"VaccineRecords":null,"Avatar":"","Pictures":["","",""],"VaccPictures":["",""],"RenewalPictures":null,"PETSHOP_ID":null,"PET_ID":"c294aecb-a9a6-4140-8a1b-1450c5222c20","FILE_NO":"2019072300003","OWNER_ID":"6be0ea5b-7db2-4005-a693-1ae247d178b9","PET_NAME":"他随机","PET_BREED":6,"PET_COLOR":5,"PET_SEX":1,"PET_BIRTH":"2019-06-20 00:00:00","PET_QUALE":1,"IMMUNO":"投诉故事","CHIPS_TYPE":null,"CHIPS_CODE":null,"DEVICE_TYPE":null,"DEVICE_CODE":2,"APPLY_TIME":"2019-07-23 19:58:08","PERMIT_DATE":null,"STATUS":1,"EXAMINE_STATE":0,"RENEWAL_STATE":null,"IMMUNO_STATE":null}]
     */

    private int Code;
    private String Msg;
    private List<DataBean> Data;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * PetOwner : {"OWNER_ID":"6be0ea5b-7db2-4005-a693-1ae247d178b9","IDENTITY_TYPE":5,"IDENTITY_CARD":"354564","CHINESE_NAME":"朱瑞","BIRTH":"2019-07-18 00:00:00","SEX":1,"PHONE":"15959595656","AREA_CODE":"370829","ADDRESS":"去听","EMERGECY_NAME":"去鸡鸡","EMERGECY_PHONE":"15067881072","OPERATE_TIME":"2019-07-23 19:58:08"}
         * VaccineRecords : null
         * Avatar :
         * Pictures : ["","",""]
         * VaccPictures : ["",""]
         * RenewalPictures : null
         * PETSHOP_ID : null
         * PET_ID : c294aecb-a9a6-4140-8a1b-1450c5222c20
         * FILE_NO : 2019072300003
         * OWNER_ID : 6be0ea5b-7db2-4005-a693-1ae247d178b9
         * PET_NAME : 他随机
         * PET_BREED : 6
         * PET_COLOR : 5
         * PET_SEX : 1
         * PET_BIRTH : 2019-06-20 00:00:00
         * PET_QUALE : 1
         * IMMUNO : 投诉故事
         * CHIPS_TYPE : null
         * CHIPS_CODE : null
         * DEVICE_TYPE : null
         * DEVICE_CODE : 2
         * APPLY_TIME : 2019-07-23 19:58:08
         * PERMIT_DATE : null
         * STATUS : 1
         * EXAMINE_STATE : 0
         * RENEWAL_STATE : null
         * IMMUNO_STATE : null
         */

        private PetOwnerBean PetOwner;
        private List<VaccineRecordBean> VaccineRecords;
        private String Avatar;
        private Object RenewalPictures;
        private Object PETSHOP_ID;
        private String PET_ID;
        private String FILE_NO;
        private String OWNER_ID;
        private String PET_NAME;
        private int PET_BREED;
        private int PET_COLOR;
        private int PET_SEX;
        private String PET_BIRTH;
        private int PET_QUALE;
        private String IMMUNO;
        private Object CHIPS_TYPE;
        private Object CHIPS_CODE;
        private Object DEVICE_TYPE;
        private int DEVICE_CODE;
        private String APPLY_TIME;
        private Object PERMIT_DATE;
        private int STATUS;
        private int EXAMINE_STATE;
        private Object RENEWAL_STATE;
        private Object IMMUNO_STATE;
        private List<String> Pictures;
        private List<String> VaccPictures;

        public PetOwnerBean getPetOwner() {
            return PetOwner;
        }

        public void setPetOwner(PetOwnerBean PetOwner) {
            this.PetOwner = PetOwner;
        }

        public List<VaccineRecordBean> getVaccineRecords() {
            return VaccineRecords;
        }

        public void setVaccineRecords(List<VaccineRecordBean> vaccineRecords) {
            VaccineRecords = vaccineRecords;
        }

        public String getAvatar() {
            return Avatar;
        }

        public void setAvatar(String Avatar) {
            this.Avatar = Avatar;
        }

        public Object getRenewalPictures() {
            return RenewalPictures;
        }

        public void setRenewalPictures(Object RenewalPictures) {
            this.RenewalPictures = RenewalPictures;
        }

        public Object getPETSHOP_ID() {
            return PETSHOP_ID;
        }

        public void setPETSHOP_ID(Object PETSHOP_ID) {
            this.PETSHOP_ID = PETSHOP_ID;
        }

        public String getPET_ID() {
            return PET_ID;
        }

        public void setPET_ID(String PET_ID) {
            this.PET_ID = PET_ID;
        }

        public String getFILE_NO() {
            return FILE_NO;
        }

        public void setFILE_NO(String FILE_NO) {
            this.FILE_NO = FILE_NO;
        }

        public String getOWNER_ID() {
            return OWNER_ID;
        }

        public void setOWNER_ID(String OWNER_ID) {
            this.OWNER_ID = OWNER_ID;
        }

        public String getPET_NAME() {
            return PET_NAME;
        }

        public void setPET_NAME(String PET_NAME) {
            this.PET_NAME = PET_NAME;
        }

        public int getPET_BREED() {
            return PET_BREED;
        }

        public void setPET_BREED(int PET_BREED) {
            this.PET_BREED = PET_BREED;
        }

        public int getPET_COLOR() {
            return PET_COLOR;
        }

        public void setPET_COLOR(int PET_COLOR) {
            this.PET_COLOR = PET_COLOR;
        }

        public int getPET_SEX() {
            return PET_SEX;
        }

        public void setPET_SEX(int PET_SEX) {
            this.PET_SEX = PET_SEX;
        }

        public String getPET_BIRTH() {
            return PET_BIRTH;
        }

        public void setPET_BIRTH(String PET_BIRTH) {
            this.PET_BIRTH = PET_BIRTH;
        }

        public int getPET_QUALE() {
            return PET_QUALE;
        }

        public void setPET_QUALE(int PET_QUALE) {
            this.PET_QUALE = PET_QUALE;
        }

        public String getIMMUNO() {
            return IMMUNO;
        }

        public void setIMMUNO(String IMMUNO) {
            this.IMMUNO = IMMUNO;
        }

        public Object getCHIPS_TYPE() {
            return CHIPS_TYPE;
        }

        public void setCHIPS_TYPE(Object CHIPS_TYPE) {
            this.CHIPS_TYPE = CHIPS_TYPE;
        }

        public Object getCHIPS_CODE() {
            return CHIPS_CODE;
        }

        public void setCHIPS_CODE(Object CHIPS_CODE) {
            this.CHIPS_CODE = CHIPS_CODE;
        }

        public Object getDEVICE_TYPE() {
            return DEVICE_TYPE;
        }

        public void setDEVICE_TYPE(Object DEVICE_TYPE) {
            this.DEVICE_TYPE = DEVICE_TYPE;
        }

        public int getDEVICE_CODE() {
            return DEVICE_CODE;
        }

        public void setDEVICE_CODE(int DEVICE_CODE) {
            this.DEVICE_CODE = DEVICE_CODE;
        }

        public String getAPPLY_TIME() {
            return APPLY_TIME;
        }

        public void setAPPLY_TIME(String APPLY_TIME) {
            this.APPLY_TIME = APPLY_TIME;
        }

        public Object getPERMIT_DATE() {
            return PERMIT_DATE;
        }

        public void setPERMIT_DATE(Object PERMIT_DATE) {
            this.PERMIT_DATE = PERMIT_DATE;
        }

        public int getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(int STATUS) {
            this.STATUS = STATUS;
        }

        public int getEXAMINE_STATE() {
            return EXAMINE_STATE;
        }

        public void setEXAMINE_STATE(int EXAMINE_STATE) {
            this.EXAMINE_STATE = EXAMINE_STATE;
        }

        public Object getRENEWAL_STATE() {
            if(RENEWAL_STATE == null){
                return "0";
            }

            return  ((int)(double) (Double.valueOf(RENEWAL_STATE.toString())))+"";

        }

        public void setRENEWAL_STATE(Object RENEWAL_STATE) {
            this.RENEWAL_STATE = RENEWAL_STATE;
        }

        public Object getIMMUNO_STATE() {
            if(IMMUNO_STATE == null){
                return "0";
            }

            return  ((int)(double) (Double.valueOf(IMMUNO_STATE.toString())))+"";

        }

        public void setIMMUNO_STATE(Object IMMUNO_STATE) {
            this.IMMUNO_STATE = IMMUNO_STATE;
        }

        public List<String> getPictures() {
            return Pictures;
        }

        public void setPictures(List<String> Pictures) {
            this.Pictures = Pictures;
        }

        public List<String> getVaccPictures() {
            return VaccPictures;
        }

        public void setVaccPictures(List<String> VaccPictures) {
            this.VaccPictures = VaccPictures;
        }

        public static class PetOwnerBean {
            /**
             * OWNER_ID : 6be0ea5b-7db2-4005-a693-1ae247d178b9
             * IDENTITY_TYPE : 5
             * IDENTITY_CARD : 354564
             * CHINESE_NAME : 朱瑞
             * BIRTH : 2019-07-18 00:00:00
             * SEX : 1
             * PHONE : 15959595656
             * AREA_CODE : 370829
             * ADDRESS : 去听
             * EMERGECY_NAME : 去鸡鸡
             * EMERGECY_PHONE : 15067881072
             * OPERATE_TIME : 2019-07-23 19:58:08
             */

            private String OWNER_ID;
            private int IDENTITY_TYPE;
            private String IDENTITY_CARD;
            private String CHINESE_NAME;
            private String BIRTH;
            private int SEX;
            private String PHONE;
            private String AREA_CODE;
            private String ADDRESS;
            private String EMERGECY_NAME;
            private String EMERGECY_PHONE;
            private String OPERATE_TIME;

            public String getOWNER_ID() {
                return OWNER_ID;
            }

            public void setOWNER_ID(String OWNER_ID) {
                this.OWNER_ID = OWNER_ID;
            }

            public int getIDENTITY_TYPE() {
                return IDENTITY_TYPE;
            }

            public void setIDENTITY_TYPE(int IDENTITY_TYPE) {
                this.IDENTITY_TYPE = IDENTITY_TYPE;
            }

            public String getIDENTITY_CARD() {
                return IDENTITY_CARD;
            }

            public void setIDENTITY_CARD(String IDENTITY_CARD) {
                this.IDENTITY_CARD = IDENTITY_CARD;
            }

            public String getCHINESE_NAME() {
                return CHINESE_NAME;
            }

            public void setCHINESE_NAME(String CHINESE_NAME) {
                this.CHINESE_NAME = CHINESE_NAME;
            }

            public String getBIRTH() {
                return BIRTH;
            }

            public void setBIRTH(String BIRTH) {
                this.BIRTH = BIRTH;
            }

            public int getSEX() {
                return SEX;
            }

            public void setSEX(int SEX) {
                this.SEX = SEX;
            }

            public String getPHONE() {
                return PHONE;
            }

            public void setPHONE(String PHONE) {
                this.PHONE = PHONE;
            }

            public String getAREA_CODE() {
                return AREA_CODE;
            }

            public void setAREA_CODE(String AREA_CODE) {
                this.AREA_CODE = AREA_CODE;
            }

            public String getADDRESS() {
                return ADDRESS;
            }

            public void setADDRESS(String ADDRESS) {
                this.ADDRESS = ADDRESS;
            }

            public String getEMERGECY_NAME() {
                return EMERGECY_NAME;
            }

            public void setEMERGECY_NAME(String EMERGECY_NAME) {
                this.EMERGECY_NAME = EMERGECY_NAME;
            }

            public String getEMERGECY_PHONE() {
                return EMERGECY_PHONE;
            }

            public void setEMERGECY_PHONE(String EMERGECY_PHONE) {
                this.EMERGECY_PHONE = EMERGECY_PHONE;
            }

            public String getOPERATE_TIME() {
                return OPERATE_TIME;
            }

            public void setOPERATE_TIME(String OPERATE_TIME) {
                this.OPERATE_TIME = OPERATE_TIME;
            }
        }
        public static class VaccineRecordBean {

            private String CORD_ID;
            private String FILE_NO;
            private int VACCINE_TYPE;
            private String INJECT_TIME;
            private String INJECT_PLACE;
            private String INJECT_MAN;
            private String VALID_DATE;
            private String PETSHOP_ID;

            public String getCORD_ID() {
                return CORD_ID;
            }

            public void setCORD_ID(String CORD_ID) {
                this.CORD_ID = CORD_ID;
            }

            public String getFILE_NO() {
                return FILE_NO;
            }

            public void setFILE_NO(String FILE_NO) {
                this.FILE_NO = FILE_NO;
            }

            public int getVACCINE_TYPE() {
                return VACCINE_TYPE;
            }

            public void setVACCINE_TYPE(int VACCINE_TYPE) {
                this.VACCINE_TYPE = VACCINE_TYPE;
            }

            public String getINJECT_TIME() {
                return INJECT_TIME;
            }

            public void setINJECT_TIME(String INJECT_TIME) {
                this.INJECT_TIME = INJECT_TIME;
            }

            public String getINJECT_PLACE() {
                return INJECT_PLACE;
            }

            public void setINJECT_PLACE(String INJECT_PLACE) {
                this.INJECT_PLACE = INJECT_PLACE;
            }

            public String getINJECT_MAN() {
                return INJECT_MAN;
            }

            public void setINJECT_MAN(String INJECT_MAN) {
                this.INJECT_MAN = INJECT_MAN;
            }

            public String getVALID_DATE() {
                return VALID_DATE;
            }

            public void setVALID_DATE(String VALID_DATE) {
                this.VALID_DATE = VALID_DATE;
            }

            public String getPETSHOP_ID() {
                return PETSHOP_ID;
            }

            public void setPETSHOP_ID(String PETSHOP_ID) {
                this.PETSHOP_ID = PETSHOP_ID;
            }
        }
    }
}
