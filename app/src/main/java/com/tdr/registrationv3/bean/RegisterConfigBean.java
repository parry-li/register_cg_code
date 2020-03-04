package com.tdr.registrationv3.bean;

public class RegisterConfigBean {


    /**
     * blackCheck : 2
     * cardIdMax : {"dayNum":1,"isValid":true,"vehNum":20}
     * eqTypeModule : 4
     * id : 71
     */

    private int blackCheck;
    private CardIdMaxBean cardIdMax;
    private int eqTypeModule;
    private int id;

    public int getBlackCheck() {
        return blackCheck;
    }

    public void setBlackCheck(int blackCheck) {
        this.blackCheck = blackCheck;
    }

    public CardIdMaxBean getCardIdMax() {
        return cardIdMax;
    }

    public void setCardIdMax(CardIdMaxBean cardIdMax) {
        this.cardIdMax = cardIdMax;
    }

    public int getEqTypeModule() {
        return eqTypeModule;
    }

    public void setEqTypeModule(int eqTypeModule) {
        this.eqTypeModule = eqTypeModule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class CardIdMaxBean {
        /**
         * dayNum : 1
         * isValid : true
         * vehNum : 20
         */

        private int dayNum;
        private boolean isValid;
        private int vehNum;

        public int getDayNum() {
            return dayNum;
        }

        public void setDayNum(int dayNum) {
            this.dayNum = dayNum;
        }

        public boolean isIsValid() {
            return isValid;
        }

        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }

        public int getVehNum() {
            return vehNum;
        }

        public void setVehNum(int vehNum) {
            this.vehNum = vehNum;
        }
    }
}
