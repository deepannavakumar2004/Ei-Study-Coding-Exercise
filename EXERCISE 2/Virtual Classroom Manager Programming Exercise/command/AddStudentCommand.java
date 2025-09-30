package com.edtech.command;

import com.edtech.service.StudentService;

public class AddStudentCommand implements Command {
    private StudentService studentService;
    private String studentId;
    private String className;

    public AddStudentCommand(StudentService studentService, String studentId, String className) {
        this.studentService = studentService;
        this.studentId = studentId;
        this.className = className;
    }

    @Override
    public void execute() {
        studentService.addStudent(studentId, className);
        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
    }
}
