package com.rodrigoma.moviesrelease.domain;

public enum Stores {
    AMAZON("orange"),
    CLASSICLINE("red"),
    FAMDVD("gray"),
    OBRASPRIMAS("yellow"),
    THEORIGINALS("blue"),
    VERSATIL("gold"),
    TODOS("green");

    private final String color;

    private Stores(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static String getColorBy(String name) {
        if (Stores.AMAZON.toString().equals(name)) {
            return AMAZON.color;
        } else if (Stores.CLASSICLINE.toString().equals(name)) {
            return CLASSICLINE.color;
        } else if (Stores.FAMDVD.toString().equals(name)) {
            return FAMDVD.color;
        } else if (Stores.OBRASPRIMAS.toString().equals(name)) {
            return OBRASPRIMAS.color;
        } else if (Stores.THEORIGINALS.toString().equals(name)) {
            return THEORIGINALS.color;
        } else if (Stores.VERSATIL.toString().equals(name)) {
            return VERSATIL.color;
        }

        return TODOS.color;
    }
}