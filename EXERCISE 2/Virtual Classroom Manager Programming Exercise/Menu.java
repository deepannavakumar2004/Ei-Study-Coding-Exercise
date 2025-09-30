package com.edtech;

import com.edtech.command.AddClassroomCommand;
import com.edtech.command.AddStudentCommand;
import com.edtech.command.ScheduleAssignmentCommand;
import com.edtech.command.SubmitAssignmentCommand;
import com.edtech.service.AssignmentService;
import com.edtech.service.ClassroomService;
import com.edtech.service.StudentService;

import java.util.Scanner;

public class Menu {
    private ClassroomService classroomService;
    private StudentService studentService;
    private AssignmentService assignmentService;
    private Scanner scanner;

    public Menu(ClassroomService classroomService, StudentService studentService, AssignmentService assignmentService) {
        this.classroomService = classroomService;
        this.studentService = studentService;
        this.assignmentService = assignmentService;
        this.scanner = new Scanner(System.in);
    }

    // Display the menu
    public void displayMenu() {
        System.out.println("Welcome to the Virtual Classroom Manager");
        System.out.println("Available commands:");
        System.out.println("1. add_classroom [className]");
        System.out.println("2. add_student [studentId] [className]");
        System.out.println("3. schedule_assignment [className] [details]");
        System.out.println("4. submit_assignment [studentId] [className] [assignmentDetails]");
        System.out.println("5. show_classes");
        System.out.println("6. show_students [className]");
        System.out.println("7. show_assignments [className]");
        System.out.println("8. remove_classroom [className]");
        System.out.println("9. exit");
    }

    // Handle the user's input
    public void handleInput(String input) {
        String[] commandParts = input.trim().split("\\s+", 4);

        switch (commandParts[0]) {
            case "1": // add_classroom
                System.out.println("Enter className:");
                String className = scanner.nextLine();
                new AddClassroomCommand(classroomService, className).execute();
                break;

            case "2": // add_student
                System.out.println("Enter studentId and className:");
                String studentId = scanner.next();
                className = scanner.next();
                new AddStudentCommand(studentService, studentId, className).execute();
                break;

            case "3": // schedule_assignment
                System.out.println("Enter className and details:");
                className = scanner.next();
                String details = scanner.nextLine().trim();
                new ScheduleAssignmentCommand(assignmentService, className, details).execute();
                break;

            case "4": // submit_assignment
                System.out.println("Enter studentId, className, and assignmentDetails:");
                studentId = scanner.next();
                className = scanner.next();
                String assignmentDetails = scanner.nextLine().trim();
                new SubmitAssignmentCommand(assignmentService, studentId, className, assignmentDetails).execute();
                break;

            case "5": // show_classes
                classroomService.showAllClassrooms();
                break;

            case "6": // show_students
                System.out.println("Enter className:");
                className = scanner.next();
                classroomService.showStudentsInClassroom(className);
                break;

            case "7": // show_assignments
                System.out.println("Enter className:");
                className = scanner.next();
                assignmentService.showAssignmentsWithSubmissions(className); // Updated method call
                break;            

            case "8": // remove_classroom
                System.out.println("Enter className to remove:");
                className = scanner.next();
                if (classroomService.getClassroom(className) != null) {
                classroomService.removeClassroom(className);
                System.out.println("Classroom " + className + " removed.");
                } 
                else {
                System.out.println("Classroom " + className + " does not exist.");
                }
                break;

            case "9": // exit
                System.out.println("Exiting the application.");
                return;

            default:
                System.out.println("Unknown command. Please try again.");
                break;
        }
        // After processing the command, show the menu again and get input
        promptForCommand();
    }

    // Prompt for command input and handle it
    public void promptForCommand() {
        displayMenu();  // Show the menu
        System.out.println("Enter your command:");
        String input = scanner.nextLine();  // Read user input
        handleInput(input);  // Process the user input
    }

    // Start the menu process
    public void start() {
        promptForCommand();
    }
}
