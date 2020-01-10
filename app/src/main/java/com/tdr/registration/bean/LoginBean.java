package com.tdr.registration.bean;

public class LoginBean {

    /**
     * Code : 0
     * Msg : 登录成功
     * Data : {"Token":"6efef556e0d44111ab2beaf69fd5a4d0","Expiry":"2019-07-24 19:21:38","UserName":"admin"}
     */

    private int Code;
    private String Msg;
    private DataBean Data;

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

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * Token : 6efef556e0d44111ab2beaf69fd5a4d0
         * Expiry : 2019-07-24 19:21:38
         * UserName : admin
         */

        private String Token;
        private String Expiry;
        private String UserName;

        public String getToken() {
            return Token;
        }

        public void setToken(String Token) {
            this.Token = Token;
        }

        public String getExpiry() {
            return Expiry;
        }

        public void setExpiry(String Expiry) {
            this.Expiry = Expiry;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }
    }
}
