package com.tdr.registration.bean;

import java.util.List;

public class VehicleConfigBean {

    /**
     * engineNoRegular : {"isRequire":true,"lenMax":8,"lenMin":6}
     * id : 12
     * shelvesNoRegular : {"isRequire":true,"lenMax":8,"lenMin":6}
     * vehicleLicenseInfoList : [{"index":1,"isValid":false,"typeId":1,"vehicleNbLableConfigList":[{"eqType":["8102","8103"],"index":1,"isRequired":false,"isValid":true,"lableName":"标签1"},{"eqType":["8102","8103"],"index":2,"isRequired":true,"isValid":true,"lableName":"标签2"}],"vehicleNoLen":7,"vehicleNoLenChineseMsg":"车牌号长度提示信息","vehicleNoReg":"(车牌号长度提示信息)(温州|||)(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7}$","vehicleNoRegularMsg":"车牌提示信息","vehicleNoRegularType":3,"vehicleTypeName":"电动车"},{"index":2,"isValid":false,"typeId":2,"vehicleNbLableConfigList":[{"eqType":["8102","8103"],"index":1,"isRequired":true,"isValid":true,"lableName":"标签1"},{"eqType":["8102","8103"],"index":2,"isRequired":true,"isValid":true,"lableName":"标签2"}],"vehicleNoLen":7,"vehicleNoLenChineseMsg":"车牌号长度提示信息","vehicleNoReg":"(车牌号长度提示信息)(温州|||)(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7}$","vehicleNoRegularMsg":"车牌提示信息","vehicleNoRegularType":3,"vehicleTypeName":"助力车"},{"index":3,"isValid":true,"typeId":3,"vehicleNbLableConfigList":[{"eqType":["8701","870F"],"index":1,"isRequired":true,"isValid":true,"lableName":"2313123"}],"vehicleNoLen":2,"vehicleNoReg":"^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{2}$","vehicleNoRegularMsg":"111","vehicleNoRegularType":2,"vehicleTypeName":"摩托车"}]
     */

    private EngineNoRegularBean engineNoRegular;
    private int id;
    private ShelvesNoRegularBean shelvesNoRegular;
    private List<VehicleLicenseInfoListBean> vehicleLicenseInfoList;

    public EngineNoRegularBean getEngineNoRegular() {
        return engineNoRegular;
    }

    public void setEngineNoRegular(EngineNoRegularBean engineNoRegular) {
        this.engineNoRegular = engineNoRegular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShelvesNoRegularBean getShelvesNoRegular() {
        return shelvesNoRegular;
    }

    public void setShelvesNoRegular(ShelvesNoRegularBean shelvesNoRegular) {
        this.shelvesNoRegular = shelvesNoRegular;
    }

    public List<VehicleLicenseInfoListBean> getVehicleLicenseInfoList() {
        return vehicleLicenseInfoList;
    }

    public void setVehicleLicenseInfoList(List<VehicleLicenseInfoListBean> vehicleLicenseInfoList) {
        this.vehicleLicenseInfoList = vehicleLicenseInfoList;
    }

    public static class EngineNoRegularBean {
        /**
         * isRequire : true
         * lenMax : 8
         * lenMin : 6
         */

        private boolean isRequire;
        private int lenMax;
        private int lenMin;

        public boolean isIsRequire() {
            return isRequire;
        }

        public void setIsRequire(boolean isRequire) {
            this.isRequire = isRequire;
        }

        public int getLenMax() {
            return lenMax;
        }

        public void setLenMax(int lenMax) {
            this.lenMax = lenMax;
        }

        public int getLenMin() {
            return lenMin;
        }

        public void setLenMin(int lenMin) {
            this.lenMin = lenMin;
        }
    }

    public static class ShelvesNoRegularBean {
        /**
         * isRequire : true
         * lenMax : 8
         * lenMin : 6
         */

        private boolean isRequire;
        private int lenMax;
        private int lenMin;

        public boolean isIsRequire() {
            return isRequire;
        }

        public void setIsRequire(boolean isRequire) {
            this.isRequire = isRequire;
        }

        public int getLenMax() {
            return lenMax;
        }

        public void setLenMax(int lenMax) {
            this.lenMax = lenMax;
        }

        public int getLenMin() {
            return lenMin;
        }

        public void setLenMin(int lenMin) {
            this.lenMin = lenMin;
        }
    }

    public static class VehicleLicenseInfoListBean {
        /*
        *
        * {
  "engineNoRegular": {
    "isRequire": true,
    "lenMax": 8,
    "lenMin": 6
  },
  "id": 12,
  "shelvesNoRegular": {
    "isRequire": true,
    "lenMax": 8,
    "lenMin": 6
  },
  "vehicleLicenseInfoLis": [
    {
      "index": 1,
      "isValid": false,
      "typeId": 1,
      "vehicleNbLableConfigLis": [
        {
          "eqType": [
            "8102",
            "8103"
          ],
          "index": 1,
          "isRequired": false,
          "isValid": true,
          "lableName": "标签1"
        },
        {
          "eqType": [
            "8102",
            "8103"
          ],
          "index": 2,
          "isRequired": true,
          "isValid": true,
          "lableName": "标签2"
        }
      ],
      "vehicleNoLen": 7,
      "vehicleNoLenChineseMsg": "车牌号长度提示信息",
      "vehicleNoReg": "(车牌号长度提示信息)(温州|||)(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7}$",
      "vehicleNoRegularMsg": "车牌提示信息",
      "vehicleNoRegularType": 3,
      "vehicleTypeName": "电动车"
    },
    {
      "index": 2,
      "isValid": false,
      "typeId": 2,
      "vehicleNbLableConfigLis": [
        {
          "eqType": [
            "8102",
            "8103"
          ],
          "index": 1,
          "isRequired": true,
          "isValid": true,
          "lableName": "标签1"
        },
        {
          "eqType": [
            "8102",
            "8103"
          ],
          "index": 2,
          "isRequired": true,
          "isValid": true,
          "lableName": "标签2"
        }
      ],
      "vehicleNoLen": 7,
      "vehicleNoLenChineseMsg": "车牌号长度提示信息",
      "vehicleNoReg": "(车牌号长度提示信息)(温州|||)(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7}$",
      "vehicleNoRegularMsg": "车牌提示信息",
      "vehicleNoRegularType": 3,
      "vehicleTypeName": "助力车"
    },
    {
      "index": 3,
      "isValid": true,
      "typeId": 3,
      "vehicleNbLableConfigLis": [
        {
          "eqType": [
            "8701",
            "870F"
          ],
          "index": 1,
          "isRequired": true,
          "isValid": true,
          "lableName": "2313123"
        }
      ],
      "vehicleNoLen": 2,
      "vehicleNoReg": "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{2}$",
      "vehicleNoRegularMsg": "111",
      "vehicleNoRegularType": 2,
      "vehicleTypeName": "摩托车"
    }
  ]
}
        *
        * */
        /**
         * index : 1
         * isValid : false
         * typeId : 1
         * vehicleNbLableConfigList : [{"eqType":["8102","8103"],"index":1,"isRequired":false,"isValid":true,"lableName":"标签1"},{"eqType":["8102","8103"],"index":2,"isRequired":true,"isValid":true,"lableName":"标签2"}]
         * vehicleNoLen : 7
         * vehicleNoLenChineseMsg : 车牌号长度提示信息
         * vehicleNoReg : (车牌号长度提示信息)(温州|||)(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7}$
         * vehicleNoRegularMsg : 车牌提示信息
         * vehicleNoRegularType : 3
         * vehicleTypeName : 电动车
         */

        private int index;
        private boolean isValid;
        private boolean vehicleNoScan;
        private int typeId;
        private int vehicleNoLen;
        private String vehicleNoLenChineseMsg;
        private String vehicleNoReg;
        private String vehicleNoRegularMsg;
        private int vehicleNoRegularType;
        private String vehicleTypeName;
        private List<VehicleNbLableConfigListBean> vehicleNbLableConfigList;

        public boolean isVehicleNoScan() {
            return vehicleNoScan;
        }

        public void setVehicleNoScan(boolean vehicleNoScan) {
            this.vehicleNoScan = vehicleNoScan;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public boolean isIsValid() {
            return isValid;
        }

        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public int getVehicleNoLen() {
            return vehicleNoLen;
        }

        public void setVehicleNoLen(int vehicleNoLen) {
            this.vehicleNoLen = vehicleNoLen;
        }

        public String getVehicleNoLenChineseMsg() {
            return vehicleNoLenChineseMsg;
        }

        public void setVehicleNoLenChineseMsg(String vehicleNoLenChineseMsg) {
            this.vehicleNoLenChineseMsg = vehicleNoLenChineseMsg;
        }

        public String getVehicleNoReg() {
            return vehicleNoReg;
        }

        public void setVehicleNoReg(String vehicleNoReg) {
            this.vehicleNoReg = vehicleNoReg;
        }

        public String getVehicleNoRegularMsg() {
            return vehicleNoRegularMsg;
        }

        public void setVehicleNoRegularMsg(String vehicleNoRegularMsg) {
            this.vehicleNoRegularMsg = vehicleNoRegularMsg;
        }

        public int getVehicleNoRegularType() {
            return vehicleNoRegularType;
        }

        public void setVehicleNoRegularType(int vehicleNoRegularType) {
            this.vehicleNoRegularType = vehicleNoRegularType;
        }

        public String getVehicleTypeName() {
            return vehicleTypeName;
        }

        public void setVehicleTypeName(String vehicleTypeName) {
            this.vehicleTypeName = vehicleTypeName;
        }

        public List<VehicleNbLableConfigListBean> getVehicleNbLableConfigList() {
            return vehicleNbLableConfigList;
        }

        public void setVehicleNbLableConfigList(List<VehicleNbLableConfigListBean> vehicleNbLableConfigList) {
            this.vehicleNbLableConfigList = vehicleNbLableConfigList;
        }

        public static class VehicleNbLableConfigListBean {
            /**
             * eqType : ["8102","8103"]
             * index : 1
             * isRequired : false
             * isValid : true
             * lableName : 标签1
             */

            private int index;
            private boolean isRequired;
            private boolean isValid;
            private String lableName;
            private List<String> eqType;
            /*以下参数额外添加*/
            private String editValue;
            private boolean isNoScan;


            public boolean isNoScan() {
                return isNoScan;
            }

            public void setNoScan(boolean noScan) {
                isNoScan = noScan;
            }

            public String getEditValue() {
                return editValue;
            }

            public void setEditValue(String editValue) {
                this.editValue = editValue;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public boolean isIsRequired() {
                return isRequired;
            }

            public void setIsRequired(boolean isRequired) {
                this.isRequired = isRequired;
            }

            public boolean isIsValid() {
                return isValid;
            }

            public void setIsValid(boolean isValid) {
                this.isValid = isValid;
            }

            public String getLableName() {
                return lableName;
            }

            public void setLableName(String lableName) {
                this.lableName = lableName;
            }

            public List<String> getEqType() {
                return eqType;
            }

            public void setEqType(List<String> eqType) {
                this.eqType = eqType;
            }
        }
    }
}
