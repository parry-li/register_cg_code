package com.tdr.registration.bean;

import java.util.List;

public class LoginBean {


    /**
     * roleMenuVOList : [{"roleId":1,"roleType":1,"type":1,"menuIdList":[7]},{"roleId":3,"roleType":1,"type":2,"menuIdList":[7]}]
     * userId : 12
     * userType : 1
     * utype : Police
     * subsystemId : 18
     * login : 13137129315
     * token : login_token_3cceb587-f55c-422f-948a-03c6f1629644
     */

    private int userId;
    private int userType;
    private String utype;
    private int subsystemId;
    private String login;
    private String token;
    private List<RoleMenuVOListBean> roleMenuVOList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public int getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(int subsystemId) {
        this.subsystemId = subsystemId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<RoleMenuVOListBean> getRoleMenuVOList() {
        return roleMenuVOList;
    }

    public void setRoleMenuVOList(List<RoleMenuVOListBean> roleMenuVOList) {
        this.roleMenuVOList = roleMenuVOList;
    }

    public static class RoleMenuVOListBean {
        /**
         * roleId : 1
         * roleType : 1
         * type : 1
         * menuIdList : [7]
         */

        private int roleId;
        private int roleType;
        private int type;
        private List<Integer> menuIdList;

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public int getRoleType() {
            return roleType;
        }

        public void setRoleType(int roleType) {
            this.roleType = roleType;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<Integer> getMenuIdList() {
            return menuIdList;
        }

        public void setMenuIdList(List<Integer> menuIdList) {
            this.menuIdList = menuIdList;
        }
    }
}
