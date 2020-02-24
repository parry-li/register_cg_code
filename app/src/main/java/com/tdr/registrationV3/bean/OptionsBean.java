package com.tdr.registrationV3.bean;

import com.contrarywind.interfaces.IPickerViewData;

public class OptionsBean implements IPickerViewData {
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

    @Override
    public String getPickerViewText() {
        return name;
    }
}
