package com.fw.manage.common.enums;

public enum AppEnum {
    HELLO(1, "world1"),
    WORLD(2, "world2"),
    ;
    private int app;
    private String type;

    AppEnum(int app, String type) {
        this.app = app;
        this.type = type;
    }


    public int getApp() {
        return app;
    }

    public String getType() {
        return type;
    }
}
