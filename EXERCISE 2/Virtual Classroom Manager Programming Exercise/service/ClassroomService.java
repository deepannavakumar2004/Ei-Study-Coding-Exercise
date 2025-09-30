package com.edtech.service;

import com.edtech.model.Classroom;

import java.util.HashMap;
import java.util.Map;

public class ClassroomService {
    private Map<String, Classroom> classrooms;

    public ClassroomService() {
        this.classrooms = new HashMap<>();
    }

    public void addClassroom(String className) {
        classrooms.put(className, new Classroom(className));
    }

    public Classroom getClassroom(String className) {
        return classrooms.get(className);
    }

    public void removeClassroom(String className) {
        classrooms.remove(className);
    }

    public void showAllClassrooms() {
    System.out.println("All Classrooms:");
    if (classrooms.isEmpty()) {
        System.out.println("No classrooms available.");
    } else {
        classrooms.keySet().forEach(System.out::println);
    }
    }

    public void showStudentsInClassroom(String className) {
    Classroom classroom = classrooms.get(className);
    if (classroom != null) {
        System.out.println("Students in " + className + ":");
        if (classroom.getStudents().isEmpty()) {
            System.out.println("No students enrolled in this classroom.");
        } else {
            classroom.getStudents().forEach(student -> System.out.println(student.getId()));
        }
    } else {
        System.out.println("Classroom " + className + " does not exist.");
    }
    }

    public void showAssignmentsInClassroom(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            System.out.println("Assignments for " + className + ":");
        if (classroom.getAssignments().isEmpty()) {
            System.out.println("No assignments scheduled for this classroom.");
        } 
        else {
            classroom.getAssignments().forEach(assignment -> System.out.println(assignment.getDetails()));
        }
        } 
        else {
        System.out.println("Classroom " + className + " does not exist.");
    }
}
}
