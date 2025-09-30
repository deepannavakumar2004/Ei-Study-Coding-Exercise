package com.edtech.model;

import com.edtech.model.Student;
import com.edtech.model.Assignment;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String name;
    private List<Student> students;
    private List<Assignment> assignments; 

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public boolean hasStudent(String studentId) {
        return students.stream().anyMatch(student -> student.getId().equals(studentId));
    }

    public boolean removeStudent(String studentId) {
        return students.removeIf(student -> student.getId().equals(studentId));
    }
}
