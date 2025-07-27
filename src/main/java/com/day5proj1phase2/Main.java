package com.day5proj1phase2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.day5proj1phase2.dao.BugDAO;
import com.day5proj1phase2.models.Bug;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BugDAO dao = new BugDAO();

        while (true) {
            try {
                System.out.println("1. Insert a bug");
                System.out.println("2. View all bugs");
                System.out.println("3. Delete bug by ID");
                System.out.println("4. Update bug status by ID");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number (1-5).");
                    sc.nextLine();
                    continue;
                }

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter status (Open/In Progress/Closed): ");
                        String status = sc.nextLine();
                        dao.insertBug(new Bug(title, desc, status));
                        break;

                    case 2:
                        List<Bug> list = dao.getAllBugs();
                        if (list.isEmpty()) {
                            System.out.println("No bugs found!");
                        } else {
                            for (Bug b : list) {
                                System.out.println("\nID: " + b.getId());
                                System.out.println("Title: " + b.getTitle());
                                System.out.println("Status: " + b.getStatus());
                                System.out.println("Description: " + b.getDescription());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter bug ID to delete: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid ID! Must be a number.");
                            sc.nextLine();
                            break;
                        }
                        int delId = sc.nextInt();
                        dao.deleteBugById(delId);
                        break;

                    case 4:
                        System.out.print("Enter bug ID to update: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid ID! Must be a number.");
                            sc.nextLine();
                            break;
                        }
                        int updId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new status: ");
                        String newStatus = sc.nextLine();
                        dao.updateBugStatus(updId, newStatus);
                        break;

                    case 5:
                        System.out.println("Exiting...!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Enter between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type! Please enter a valid number.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
