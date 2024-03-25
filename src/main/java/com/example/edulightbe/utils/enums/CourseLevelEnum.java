package com.example.edulightbe.utils.enums;

public enum CourseLevelEnum {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced"),
    EXPERT("Expert");
    private final String value;

    public String getValue() {
        return value;
    }

    CourseLevelEnum(String value) {
        this.value = value;
    }
}
