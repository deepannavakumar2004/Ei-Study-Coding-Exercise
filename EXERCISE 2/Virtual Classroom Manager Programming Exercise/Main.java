package com.edtech;

import com.edtech.service.AssignmentService;
import com.edtech.service.ClassroomService;
import com.edtech.service.StudentService;

public class Main {
    public static void main(String[] args) {
        ClassroomService classroomService = new ClassroomService();
        StudentService studentService = new StudentService(classroomService);
        AssignmentService assignmentService = new AssignmentService(classroomService);

        // Create and run the menu
        Menu menu = new Menu(classroomService, studentService, assignmentService);
        menu.promptForCommand();
    }
}
