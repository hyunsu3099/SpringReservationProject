package com.springreservation.web.model;

public enum Role {

    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER"),
    NONMEMBER("ROLE_NONMEMBER");

    private String description;

    Role(String description) {
        this.description = description;
    }
}
