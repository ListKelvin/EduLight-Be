package com.example.edulightbe.utils.enums;

public enum AccountRoleEnum {
    INSTRUCTOR("instructor"),
    LEARNER("learner"),
    ADMIN("admin");

    private final String value;

    public String getValue() {
        return value;
    }

    AccountRoleEnum(String value) {
        this.value = value;
    }
}
