package com.edtech.model;

public class Student {
    private String id;
    private String className;

    public Student(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }
}
