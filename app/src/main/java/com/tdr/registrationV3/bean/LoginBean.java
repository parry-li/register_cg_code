package com.tdr.registrationV3.bean;

import java.util.List;

public class LoginBean {


    /**
     * menuList : [{"id":20,"menuName":"车辆业务","url":"/vehiclesBusiness","icon":null,"menuSonVOList":[{"id":27,"menuName":"车辆管理","menuFatherId":20,"url":"/vehiclesBusiness/vehicleManage","icon":null,"menuGrandsonVOList":[]},{"id":28,"menuName":"车牌补办","menuFatherId":20,"url":"/vehiclesBusiness/licensePlate","icon":null,"menuGrandsonVOList":[]},{"id":29,"menuName":"车辆过户","menuFatherId":20,"url":"/vehiclesBusiness/transfer","icon":null,"menuGrandsonVOList":[{"id":64,"menuName":"详情","menuFatherId":29,"privilegeCode":"/ddc-electriccar/electriccarsTransfer/getById"},{"id":62,"menuName":"列表","menuFatherId":29,"privilegeCode":"/ddc-electriccar/electriccarsTransfer/list"},{"id":63,"menuName":"过户","menuFatherId":29,"privilegeCode":"/ddc-electriccar/electriccarsTransfer/add"}]},{"id":30,"menuName":"车辆报废","menuFatherId":20,"url":"/vehiclesBusiness/standardVehicle","icon":null,"menuGrandsonVOList":[]}]},{"id":25,"menuName":"账户管理","url":"/accountManage","icon":null,"menuSonVOList":[{"id":45,"menuName":"民警账号管理","menuFatherId":25,"url":"/accountManage/policeUserManage","icon":null,"menuGrandsonVOList":[{"id":57,"menuName":"列表","menuFatherId":45,"privilegeCode":"/ddc-service/police/list"},{"id":61,"menuName":"详情","menuFatherId":45,"privilegeCode":"/ddc-service/police/getById"}]}]}]
     * privilegeAreaList : []
     * userId : 410
     * userType : 2
     * utype : Police
     * subsystemId : 13
     * login : jyyjs2
     * token : login_token_ab8e6cb8-95d0-4e15-a7f2-c96539ff079e
     * admin : 0
     * unitNo : 410148000000
     * unitType : 4
     * unitName : 郑州市公安局建设路派出所
     */

    private int userId;
    private int userType;
    private String utype;
    private int subsystemId;
    private String login;
    private String token;
    private int admin;
    private String unitNo;
    private int unitType;
    private String unitName;
    private List<MenuListBean> menuList;
    private List<?> privilegeAreaList;

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

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<MenuListBean> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuListBean> menuList) {
        this.menuList = menuList;
    }

    public List<?> getPrivilegeAreaList() {
        return privilegeAreaList;
    }

    public void setPrivilegeAreaList(List<?> privilegeAreaList) {
        this.privilegeAreaList = privilegeAreaList;
    }

    public static class MenuListBean {
        /**
         * id : 20
         * menuName : 车辆业务
         * url : /vehiclesBusiness
         * icon : null
         * menuSonVOList : [{"id":27,"menuName":"车辆管理","menuFatherId":20,"url":"/vehiclesBusiness/vehicleManage","icon":null,"menuGrandsonVOList":[]},{"id":28,"menuName":"车牌补办","menuFatherId":20,"url":"/vehiclesBusiness/licensePlate","icon":null,"menuGrandsonVOList":[]},{"id":29,"menuName":"车辆过户","menuFatherId":20,"url":"/vehiclesBusiness/transfer","icon":null,"menuGrandsonVOList":[{"id":64,"menuName":"详情","menuFatherId":29,"privilegeCode":"/ddc-electriccar/electriccarsTransfer/getById"},{"id":62,"menuName":"列表","menuFatherId":29,"privilegeCode":"/ddc-electriccar/electriccarsTransfer/list"},{"id":63,"menuName":"过户","menuFatherId":29,"privilegeCode":"/ddc-electriccar/electriccarsTransfer/add"}]},{"id":30,"menuName":"车辆报废","menuFatherId":20,"url":"/vehiclesBusiness/standardVehicle","icon":null,"menuGrandsonVOList":[]}]
         */

        private int id;
        private String menuName;
        private String url;
        private Object icon;
        private List<MenuSonVOListBean> menuSonVOList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public List<MenuSonVOListBean> getMenuSonVOList() {
            return menuSonVOList;
        }

        public void setMenuSonVOList(List<MenuSonVOListBean> menuSonVOList) {
            this.menuSonVOList = menuSonVOList;
        }

        public static class MenuSonVOListBean {
            /**
             * id : 27
             * menuName : 车辆管理
             * menuFatherId : 20
             * url : /vehiclesBusiness/vehicleManage
             * icon : null
             * menuGrandsonVOList : []
             */

            private int id;
            private String menuName;
            private int menuFatherId;
            private String url;
            private Object icon;
            private List<?> menuGrandsonVOList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMenuName() {
                return menuName;
            }

            public void setMenuName(String menuName) {
                this.menuName = menuName;
            }

            public int getMenuFatherId() {
                return menuFatherId;
            }

            public void setMenuFatherId(int menuFatherId) {
                this.menuFatherId = menuFatherId;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public List<?> getMenuGrandsonVOList() {
                return menuGrandsonVOList;
            }

            public void setMenuGrandsonVOList(List<?> menuGrandsonVOList) {
                this.menuGrandsonVOList = menuGrandsonVOList;
            }
        }
    }
}
