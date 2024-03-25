package com.example.edulightbe.utils.enums;

public enum CourseCategoryEnum {
    WEB_DEVELOPMENT("web development"),
    MOBILE_DEVELOPMENT("mobile development"),
    GAME_DEVELOPMENT("game development"),
    DATA_SCIENCE("data science"),
    PROGRAMING_LANGUAGE("programing language"),
    SOFTWARE_TESTING("software testing"),
    DEVOPS("devops");

    private final String value;

    public String getValue() {
        return value;
    }

    CourseCategoryEnum(String value) {
        this.value = value;
    }
}
