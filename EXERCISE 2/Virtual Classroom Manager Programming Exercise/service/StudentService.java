package com.edtech.service;

import com.edtech.model.Student;
import com.edtech.model.Classroom;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private ClassroomService classroomService;
    private Map<String, Student> students; 

    public StudentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
        this.students = new HashMap<>();
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom != null) {
            Student student = new Student(studentId, className);
            students.put(studentId, student);
            classroom.addStudent(student); 
        } else {
            throw new IllegalArgumentException("Classroom does not exist.");
        }
    }
}
