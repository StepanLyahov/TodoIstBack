package com.lyahov.stepa.MyTodoIstBack.business.entity.enums;

public enum Permission {
    READ("read"),
    WRITE("write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
