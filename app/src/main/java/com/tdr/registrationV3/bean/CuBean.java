package com.tdr.registrationV3.bean;

import com.tdr.registrationV3.http.utils.DdcResult;

import java.util.List;

public class CuBean extends DdcResult {

    /**
     * Error : 0
     * Data : [{"OWNERNAME":"yjs","LAST_VACC_TIME_display":"2019.02.14","AGE":"152天","PetOwner":{"ID":"74ed673e768647688979a1858b16a665","NAME":"yjs","IDNO":"330326198808133619","BIRTH":"0001-01-01 00:00:00","GENDER":0,"ADDRESS":"svsvs","PHONE":"15067881072","WORKON":"cxya","INTIME":"2019-07-14 19:58:43"},"ID":"a89a1ebd215c48878b5f35163468fcc9","DEVICEID":"2","PETCLASS":"猫","BIRTH":"2019-02-14 19:58:00","NICKNAME":"bcy","LAST_VACC_TIME":"2019-02-14 19:59:00","PHOTO":"8c973a495262aa0e7f17fa730470107d","OWNERID":"74ed673e768647688979a1858b16a665","INTIME":"2019-07-14 19:58:43","RS":1,"RM":null,"CREATOR":"0568062ccc1149b8bc667c02e5113d8e"}]
     * Count : 1
     */

    private int Error;
    private int Count;
    private List<DataBean> Data;

    public int getError() {
        return Error;
    }

    public void setError(int Error) {
        this.Error = Error;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * OWNERNAME : yjs
         * LAST_VACC_TIME_display : 2019.02.14
         * AGE : 152天
         * PetOwner : {"ID":"74ed673e768647688979a1858b16a665","NAME":"yjs","IDNO":"330326198808133619","BIRTH":"0001-01-01 00:00:00","GENDER":0,"ADDRESS":"svsvs","PHONE":"15067881072","WORKON":"cxya","INTIME":"2019-07-14 19:58:43"}
         * ID : a89a1ebd215c48878b5f35163468fcc9
         * DEVICEID : 2
         * PETCLASS : 猫
         * BIRTH : 2019-02-14 19:58:00
         * NICKNAME : bcy
         * LAST_VACC_TIME : 2019-02-14 19:59:00
         * PHOTO : 8c973a495262aa0e7f17fa730470107d
         * OWNERID : 74ed673e768647688979a1858b16a665
         * INTIME : 2019-07-14 19:58:43
         * RS : 1
         * RM : null
         * CREATOR : 0568062ccc1149b8bc667c02e5113d8e
         */

        private String OWNERNAME;
        private String LAST_VACC_TIME_display;
        private String AGE;
        private PetOwnerBean PetOwner;
        private String ID;
        private String DEVICEID;
        private String PETCLASS;
        private String BIRTH;
        private String NICKNAME;
        private String LAST_VACC_TIME;
        private String PHOTO;
        private String OWNERID;
        private String INTIME;
        private int RS;
        private Object RM;
        private String CREATOR;
        private String COLOR;
        private String GENDER;
        private String NATURE;
        private String IMNO;


        public String getCOLOR() {
            return COLOR;
        }

        public void setCOLOR(String COLOR) {
            this.COLOR = COLOR;
        }

        public String getGENDER() {
            return GENDER;
        }

        public void setGENDER(String GENDER) {
            this.GENDER = GENDER;
        }

        public String getNATURE() {
            return NATURE;
        }

        public void setNATURE(String NATURE) {
            this.NATURE = NATURE;
        }

        public String getIMNO() {
            return IMNO;
        }

        public void setIMNO(String IMNO) {
            this.IMNO = IMNO;
        }

        public String getOWNERNAME() {
            return OWNERNAME;
        }

        public void setOWNERNAME(String OWNERNAME) {
            this.OWNERNAME = OWNERNAME;
        }

        public String getLAST_VACC_TIME_display() {
            return LAST_VACC_TIME_display;
        }

        public void setLAST_VACC_TIME_display(String LAST_VACC_TIME_display) {
            this.LAST_VACC_TIME_display = LAST_VACC_TIME_display;
        }

        public String getAGE() {
            return AGE;
        }

        public void setAGE(String AGE) {
            this.AGE = AGE;
        }

        public PetOwnerBean getPetOwner() {
            return PetOwner;
        }

        public void setPetOwner(PetOwnerBean PetOwner) {
            this.PetOwner = PetOwner;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getDEVICEID() {
            return DEVICEID;
        }

        public void setDEVICEID(String DEVICEID) {
            this.DEVICEID = DEVICEID;
        }

        public String getPETCLASS() {
            return PETCLASS;
        }

        public void setPETCLASS(String PETCLASS) {
            this.PETCLASS = PETCLASS;
        }

        public String getBIRTH() {
            return BIRTH;
        }

        public void setBIRTH(String BIRTH) {
            this.BIRTH = BIRTH;
        }

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getLAST_VACC_TIME() {
            return LAST_VACC_TIME;
        }

        public void setLAST_VACC_TIME(String LAST_VACC_TIME) {
            this.LAST_VACC_TIME = LAST_VACC_TIME;
        }

        public String getPHOTO() {
            return PHOTO;
        }

        public void setPHOTO(String PHOTO) {
            this.PHOTO = PHOTO;
        }

        public String getOWNERID() {
            return OWNERID;
        }

        public void setOWNERID(String OWNERID) {
            this.OWNERID = OWNERID;
        }

        public String getINTIME() {
            return INTIME;
        }

        public void setINTIME(String INTIME) {
            this.INTIME = INTIME;
        }

        public int getRS() {
            return RS;
        }

        public void setRS(int RS) {
            this.RS = RS;
        }

        public Object getRM() {
            return RM;
        }

        public void setRM(Object RM) {
            this.RM = RM;
        }

        public String getCREATOR() {
            return CREATOR;
        }

        public void setCREATOR(String CREATOR) {
            this.CREATOR = CREATOR;
        }

        public static class PetOwnerBean {
            /**
             * ID : 74ed673e768647688979a1858b16a665
             * NAME : yjs
             * IDNO : 330326198808133619
             * BIRTH : 0001-01-01 00:00:00
             * GENDER : 0
             * ADDRESS : svsvs
             * PHONE : 15067881072
             * WORKON : cxya
             * INTIME : 2019-07-14 19:58:43
             */

            private String ID;
            private String NAME;
            private String IDNO;
            private String BIRTH;
            private int GENDER;
            private String ADDRESS;
            private String PHONE;
            private String WORKON;
            private String INTIME;
            private String CONTACT;
            private String CT_PHONE;

            public String getCONTACT() {
                return CONTACT;
            }

            public void setCONTACT(String CONTACT) {
                this.CONTACT = CONTACT;
            }

            public String getCT_PHONE() {
                return CT_PHONE;
            }

            public void setCT_PHONE(String CT_PHONE) {
                this.CT_PHONE = CT_PHONE;
            }

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }

            public String getIDNO() {
                return IDNO;
            }

            public void setIDNO(String IDNO) {
                this.IDNO = IDNO;
            }

            public String getBIRTH() {
                return BIRTH;
            }

            public void setBIRTH(String BIRTH) {
                this.BIRTH = BIRTH;
            }

            public int getGENDER() {
                return GENDER;
            }

            public void setGENDER(int GENDER) {
                this.GENDER = GENDER;
            }

            public String getADDRESS() {
                return ADDRESS;
            }

            public void setADDRESS(String ADDRESS) {
                this.ADDRESS = ADDRESS;
            }

            public String getPHONE() {
                return PHONE;
            }

            public void setPHONE(String PHONE) {
                this.PHONE = PHONE;
            }

            public String getWORKON() {
                return WORKON;
            }

            public void setWORKON(String WORKON) {
                this.WORKON = WORKON;
            }

            public String getINTIME() {
                return INTIME;
            }

            public void setINTIME(String INTIME) {
                this.INTIME = INTIME;
            }
        }
    }
}
