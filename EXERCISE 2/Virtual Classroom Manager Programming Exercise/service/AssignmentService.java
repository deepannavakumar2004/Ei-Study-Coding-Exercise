package com.edtech.service;

import com.edtech.model.Assignment;
import com.edtech.model.Classroom;
import com.edtech.model.Student;

import java.util.HashMap;
import java.util.Map;

public class AssignmentService {
    private ClassroomService classroomService;
    private Map<String, Map<String, String>> submissions; // className -> (studentId -> assignmentDetails)

    public AssignmentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
        this.submissions = new HashMap<>();
    }

    public boolean submitAssignment(String studentId, String className, String assignmentDetails) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom does not exist.");
        }

        if (!classroom.hasStudent(studentId)) {
            throw new IllegalArgumentException("Student not enrolled in the classroom.");
        }

        // Store submission
        submissions.putIfAbsent(className, new HashMap<>());
        submissions.get(className).put(studentId, assignmentDetails);
        return true;
    }

    public void scheduleAssignment(String className, Assignment assignment) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom does not exist.");
        }
        classroom.scheduleAssignment(assignment);
    }

    public void showAssignmentsWithSubmissions(String className) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom == null) {
            System.out.println("Classroom does not exist.");
            return;
        }

        System.out.println("Assignments for " + className + ":");
        for (Assignment assignment : classroom.getAssignments()) {
            System.out.println("Assignment: " + assignment.getDetails());
            System.out.println("Submissions:");
            for (Student student : classroom.getStudents()) {
                String submission = submissions.getOrDefault(className, new HashMap<>()).get(student.getId());
                if (submission != null) {
                    System.out.println("Student " + student.getId() + ": Submitted");
                } else {
                    System.out.println("Student " + student.getId() + ": Not Submitted");
                }
            }
        }
    }
}
