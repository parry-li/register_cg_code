package com.tdr.registrationv3.bean;


import java.util.List;

public class UnitBean {


    /**
     * unitNo : 4101
     * manageUnitNo : 41
     * unitName : 郑州市
     * unitType : 2
     * lng : 113.66541
     * lat : 34.757977
      */

    private String unitNo;
    private String manageUnitNo;
    private String unitName;
    private int unitType;
    private double lng;
    private double lat;
    private List<ChildrenListBeanX> childrenList;

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getManageUnitNo() {
        return manageUnitNo;
    }

    public void setManageUnitNo(String manageUnitNo) {
        this.manageUnitNo = manageUnitNo;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public List<ChildrenListBeanX> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<ChildrenListBeanX> childrenList) {
        this.childrenList = childrenList;
    }

    public static class ChildrenListBeanX  {
        /**
         * unitNo : 410102
         * manageUnitNo : 4101
         * unitName : 中原区
         * unitType : 3
         * lng : null
         * lat : null
         */

        private String unitNo;
        private String manageUnitNo;
        private String unitName;
        private int unitType;
        private Object lng;
        private Object lat;
        private List<ChildrenListBean> childrenList;

        public String getUnitNo() {
            return unitNo;
        }

        public void setUnitNo(String unitNo) {
            this.unitNo = unitNo;
        }

        public String getManageUnitNo() {
            return manageUnitNo;
        }

        public void setManageUnitNo(String manageUnitNo) {
            this.manageUnitNo = manageUnitNo;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public int getUnitType() {
            return unitType;
        }

        public void setUnitType(int unitType) {
            this.unitType = unitType;
        }

        public Object getLng() {
            return lng;
        }

        public void setLng(Object lng) {
            this.lng = lng;
        }

        public Object getLat() {
            return lat;
        }

        public void setLat(Object lat) {
            this.lat = lat;
        }

        public List<ChildrenListBean> getChildrenList() {
            return childrenList;
        }

        public void setChildrenList(List<ChildrenListBean> childrenList) {
            this.childrenList = childrenList;
        }



        public static class ChildrenListBean {
            /**
             * unitNo : 410148000000
             * manageUnitNo : 410102
             * unitName : 郑州市公安局建设路派出所
             * unitType : 4
             * lng : null
             * lat : null
             * childrenList : null
             */

            private String unitNo;
            private String manageUnitNo;
            private String unitName;
            private int unitType;
            private Object lng;
            private Object lat;
            private Object childrenList;

            public String getUnitNo() {
                return unitNo;
            }

            public void setUnitNo(String unitNo) {
                this.unitNo = unitNo;
            }

            public String getManageUnitNo() {
                return manageUnitNo;
            }

            public void setManageUnitNo(String manageUnitNo) {
                this.manageUnitNo = manageUnitNo;
            }

            public String getUnitName() {
                return unitName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public int getUnitType() {
                return unitType;
            }

            public void setUnitType(int unitType) {
                this.unitType = unitType;
            }

            public Object getLng() {
                return lng;
            }

            public void setLng(Object lng) {
                this.lng = lng;
            }

            public Object getLat() {
                return lat;
            }

            public void setLat(Object lat) {
                this.lat = lat;
            }

            public Object getChildrenList() {
                return childrenList;
            }

            public void setChildrenList(Object childrenList) {
                this.childrenList = childrenList;
            }


        }
    }
}
