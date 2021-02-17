package com.epam.task.fourth.enums;

public enum CandyEnum {
    CANDIES("candies"),
    NAME("name"),
    ENERGY("energy"),
    CARAMEL("caramel"),
    CHOCOLATE("chocolate");

    private String value;

    CandyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
