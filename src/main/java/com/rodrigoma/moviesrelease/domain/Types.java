package com.rodrigoma.moviesrelease.domain;

public enum Types {
    BD("#0095d5"),
    DVD("#bfb6a5"),
    BOTH("#ef9b55")
    ;

    private final String color;

    private Types(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static String getColorBy(String name) {
        if (Types.DVD.toString().equals(name)) {
            return DVD.color;
        } else if (Types.BD.toString().equals(name)) {
            return BD.color;
        }

        return BOTH.color;
    }
}