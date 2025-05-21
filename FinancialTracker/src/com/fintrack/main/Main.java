package com.fintrack.main;

import com.fintrack.service.ExpenseService;
import com.fintrack.service.GoalService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseService expenseService = new ExpenseService();
        GoalService goalService = new GoalService();

        while (true) {
            System.out.println("\n=== Financial Tracker Menu ===");
            System.out.println("1. Add Expense");
            System.out.println("2. Set Savings Goal");
            System.out.println("3. View Monthly Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> expenseService.addExpense(scanner);
                case 2 -> goalService.setGoal(scanner);
                case 3 -> expenseService.viewReport(scanner);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
