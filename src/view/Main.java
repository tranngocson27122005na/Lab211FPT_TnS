
package view;

import controller.StudentController;
import controller.Inputter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Please choose 1-5: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    controller.createStudent();
                    break;

                case "2":
                    controller.findAndSort();
                    break;

                case "3":
                    controller.updateOrDelete(); // Bạn cần viết thêm hàm này trong StudentController
                    break;

                case "4":
                    controller.report(); // Bạn cần viết thêm hàm report() trong StudentController
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
            }
        }
    }
}
