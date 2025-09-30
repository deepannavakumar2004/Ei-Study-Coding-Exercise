package com.edtech.model;

public class Assignment {
    private String className;
    private String details;

    public Assignment(String className, String details) {
        this.className = className;
        this.details = details;
    }

    public String getClassName() {
        return className;
    }

    public String getDetails() {
        return details;
    }
}
