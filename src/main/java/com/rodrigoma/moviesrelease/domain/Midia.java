package com.rodrigoma.moviesrelease.domain;

import java.util.List;

public abstract class Midia {

    private String date;
    private String url;
    private String value;
    private List<PreOrder> preorders;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<PreOrder> getPreorders() {
        return preorders;
    }

    public void setPreorders(List<PreOrder> preorders) {
        this.preorders = preorders;
    }

    public abstract String getColor();

}