package com.edtech.command;

import com.edtech.service.AssignmentService;
import com.edtech.utils.LoggerUtil;

public class SubmitAssignmentCommand implements Command {
    private AssignmentService assignmentService;
    private String studentId;
    private String className;
    private String assignmentDetails;

    public SubmitAssignmentCommand(AssignmentService assignmentService, String studentId, String className, String assignmentDetails) {
        this.assignmentService = assignmentService;
        this.studentId = studentId;
        this.className = className;
        this.assignmentDetails = assignmentDetails;
    }

    @Override
    public void execute() {
        try {
            boolean success = assignmentService.submitAssignment(studentId, className, assignmentDetails);
            if (success) {
                System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
                LoggerUtil.log("Assignment submitted by Student " + studentId + " for " + className + ".");
            } else {
                System.out.println("Failed to submit assignment. Please check the details.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while submitting the assignment: " + e.getMessage());
            LoggerUtil.log("Error: " + e.getMessage());
        }
    }
}
