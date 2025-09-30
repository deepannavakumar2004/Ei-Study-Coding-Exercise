package com.edtech.command;

import com.edtech.service.ClassroomService;

public class AddClassroomCommand implements Command {
    private ClassroomService classroomService;
    private String className;

    public AddClassroomCommand(ClassroomService classroomService, String className) {
        this.classroomService = classroomService;
        this.className = className;
    }

    @Override
    public void execute() {
        classroomService.addClassroom(className);
        System.out.println("Classroom " + className + " has been created.");
    }
}
