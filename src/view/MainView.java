package view;

import controller.StudentController;
import controller.Inputter;
import common.Messenger;

public class MainView {
    private StudentController studentController;

    public MainView() {
        this.studentController = new StudentController();
    }

    public void displayMenu() {
        System.out.println("\n===============================================");
        System.out.println("           STUDENT MANAGEMENT SYSTEM");
        System.out.println("===============================================");
        System.out.println("1. Create Student");
        System.out.println("2. Find and Sort Students");
        System.out.println("3. Display All Students");
        System.out.println("4. Exit");
        System.out.println("===============================================");
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    studentController.createStudent();
                    break;
                case 2:
                    studentController.findAndSort();
                    break;
                case 3:
                    studentController.displayAllStudents();
                    break;
                case 4:
                    System.out.println(Messenger.MSG_PROGRAM_EXIT);
                    return;
                default:
                    System.out.println(Messenger.ERR_INVALID_INPUT);
            }
        }
    }

    private int getMenuChoice() {
        int choice;
        while (true) {
            try {
                String input = Inputter.inputRequired("Please select an option (1-4): ");
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Please enter a number between 1 and 4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}