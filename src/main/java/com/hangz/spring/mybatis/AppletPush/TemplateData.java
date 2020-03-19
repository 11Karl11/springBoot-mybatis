package com.hangz.spring.mybatis.AppletPush;

/**
 * @author karl xie
 * Created on 2020-03-19 16:43
 */
public class TemplateData {
    private String value;//

    public TemplateData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}