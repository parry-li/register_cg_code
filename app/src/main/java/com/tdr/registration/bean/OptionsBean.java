package com.tdr.registration.bean;

public class OptionsBean {
    private String name;
    private Object value;

    public OptionsBean() {
    }


    public OptionsBean(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
