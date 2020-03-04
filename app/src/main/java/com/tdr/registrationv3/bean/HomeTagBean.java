package com.tdr.registrationv3.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25/025.
 */

public class HomeTagBean {

    /**
     * id : 'Math_random':'0.14385863173775115'
     * message :
     * status : Y
     * logger : null
     * data : {"hotcity":[{"hcid":"0e8d3da3-d869-4613-a98c-1e4e2d016146","lat":"28.002838","lng":"120.690636","name":"温州市","status":"1","time":"2018-03-15 16:32"},{"hcid":"340f11a3-3853-45d7-beac-e575a2efcc76","lat":"28.33639","lng":"120.66881","name":"永嘉县","status":"1","time":"2018-03-15 16:32"}],"industry":[{"iid":"cadbbfcf-df27-4de3-b25f-bc5405ff297c","name":"教育","status":"1","time":"2018-03-15 17:00"},{"iid":"ccf0b660-c16b-4b5d-8e94-6bd6b7f4f8e8","name":"IT","status":"1","time":"2018-03-15 17:00"},{"iid":"fe5ff37c-b176-49c1-a47a-8967ef51ba62","name":"医疗","status":"1","time":"2018-03-15 17:00"}],"position":[{"iid":"ccf0b660-c16b-4b5d-8e94-6bd6b7f4f8e8","name":"软件开发工程师","pid":"d561d83d-fe2e-4128-b5da-2a10ec894588","status":"1","time":"2018-03-15 17:26"}],"tag":[{"name":"人品好","role":"1","status":"1","tid":"e750f080-bc1f-462c-92a9-488022a10131","time":"2018-03-15 17:38"},{"name":"会聊天","role":"1","status":"1","tid":"53b16860-546d-4e6f-ad83-8831e03c539f","time":"2018-03-15 17:39"},{"name":"服务好","role":"1","status":"1","tid":"b1f3209d-f7f6-4f56-ae1c-03681c98720c","time":"2018-03-15 17:39"},{"name":"幽默","role":"1","status":"1","tid":"cb6b0c56-fb24-4828-9f8e-5aef9d3495f2","time":"2018-03-15 17:39"},{"name":"阿斯达213","role":"0","status":"1","tid":"41f6df9b-29a3-473e-94b5-53ab93b1836f","time":"2018-04-20 10:40"}]}
     * serialVersionUID : null
     * responseTime : 1524632995061
     */

    private String id;
    private String message;
    private String status;
    private Object logger;
    private DataBean data;
    private Object serialVersionUID;
    private String responseTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getLogger() {
        return logger;
    }

    public void setLogger(Object logger) {
        this.logger = logger;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(Object serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public static class DataBean {
        private List<HotcityBean> hotcity;
        private List<IndustryBean> industry;
        private List<PositionBean> position;
        private List<TagBean> tag;

        public List<HotcityBean> getHotcity() {
            return hotcity;
        }

        public void setHotcity(List<HotcityBean> hotcity) {
            this.hotcity = hotcity;
        }

        public List<IndustryBean> getIndustry() {
            return industry;
        }

        public void setIndustry(List<IndustryBean> industry) {
            this.industry = industry;
        }

        public List<PositionBean> getPosition() {
            return position;
        }

        public void setPosition(List<PositionBean> position) {
            this.position = position;
        }

        public List<TagBean> getTag() {
            return tag;
        }

        public void setTag(List<TagBean> tag) {
            this.tag = tag;
        }

        public static class HotcityBean {
            /**
             * hcid : 0e8d3da3-d869-4613-a98c-1e4e2d016146
             * lat : 28.002838
             * lng : 120.690636
             * name : 温州市
             * status : 1
             * time : 2018-03-15 16:32
             */

            private String hcid;
            private String lat;
            private String lng;
            private String name;
            private String status;
            private String time;

            public String getHcid() {
                return hcid;
            }

            public void setHcid(String hcid) {
                this.hcid = hcid;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class IndustryBean {
            /**
             * iid : cadbbfcf-df27-4de3-b25f-bc5405ff297c
             * name : 教育
             * status : 1
             * time : 2018-03-15 17:00
             */

            private String iid;
            private String name;
            private String status;
            private String time;

            public String getIid() {
                return iid;
            }

            public void setIid(String iid) {
                this.iid = iid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class PositionBean {
            /**
             * iid : ccf0b660-c16b-4b5d-8e94-6bd6b7f4f8e8
             * name : 软件开发工程师
             * pid : d561d83d-fe2e-4128-b5da-2a10ec894588
             * status : 1
             * time : 2018-03-15 17:26
             */

            private String iid;
            private String name;
            private String pid;
            private String status;
            private String time;

            public String getIid() {
                return iid;
            }

            public void setIid(String iid) {
                this.iid = iid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class TagBean {
            /**
             * name : 人品好
             * role : 1
             * status : 1
             * tid : e750f080-bc1f-462c-92a9-488022a10131
             * time : 2018-03-15 17:38
             */

            private String name;
            private String role;
            private String status;
            private String tid;
            private String time;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }
    }
}
