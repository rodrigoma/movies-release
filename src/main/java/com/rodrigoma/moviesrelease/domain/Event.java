package com.rodrigoma.moviesrelease.domain;

public class Event {

    private static final String RELEASE = "[L] ";
    private static final String PRE_ORDER = "[PV] ";

    private String title;
    private String url;
    private String start;
    private String color;
    private String textColor = "black";

    public String getTitle() {
        return title;
    }

    public Event setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Event setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getStart() {
        return start;
    }

    public Event setStart(String start) {
        this.start = start;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Event setColor(String color) {
        this.color = color;
        return this;
    }

    public String getTextColor() {
        return textColor;
    }

    public Event setTextColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public static Event preorder(String title, String valor, String url, String date, String color) {
        return new Event()
                .setTitle(PRE_ORDER + title.toUpperCase() + " - " + valor)
                .setUrl(url)
                .setStart(date)
                .setColor(color);
    }

    public static Event release(String title, String valor, String url, String date, String color) {
        return new Event()
                .setTitle(RELEASE + title.toUpperCase() + " - " + valor)
                .setUrl(url)
                .setStart(date)
                .setColor(color);
    }

    @Override
    public String toString() {
        return "{" +
                "title: \"" + title.toUpperCase() + '\"' +
                ", url: \"" + url + '\"' +
                ", start: \"" + start + '\"' +
                ", color: \"" + color + '\"' +
                ", textColor: \"" + textColor + '\"' +
                '}';
    }
}