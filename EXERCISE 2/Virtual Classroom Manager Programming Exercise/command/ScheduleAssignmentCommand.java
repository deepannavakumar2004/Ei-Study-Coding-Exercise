package com.edtech.command;

import com.edtech.model.Assignment;
import com.edtech.service.AssignmentService;

public class ScheduleAssignmentCommand implements Command {
    private AssignmentService assignmentService;
    private String className;
    private String details;

    public ScheduleAssignmentCommand(AssignmentService assignmentService, String className, String details) {
        this.assignmentService = assignmentService;
        this.className = className;
        this.details = details;
    }

    @Override
    public void execute() {
        Assignment assignment = new Assignment(className, details); 
        assignmentService.scheduleAssignment(className, assignment);
        System.out.println("Assignment for " + className + " has been scheduled.");
    }
}
