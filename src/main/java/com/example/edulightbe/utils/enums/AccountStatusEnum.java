package com.example.edulightbe.utils.enums;

public enum AccountStatusEnum {
    INACTIVE("inactive"),
    ACTIVE("active"),
    BAN("ban");
    private final String value;

    public String getValue() {
        return value;
    }

    AccountStatusEnum(String value) {
        this.value = value;
    }
}
