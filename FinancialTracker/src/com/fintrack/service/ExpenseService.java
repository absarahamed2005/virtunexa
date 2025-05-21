package com.fintrack.service;

import java.sql.*;
import java.util.Scanner;

public class ExpenseService {
    public void addExpense(Scanner scanner) {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        try (Connection conn = com.fintrack.db.DBConnection.getConnection()) {
            String sql = "INSERT INTO expenses (amount, category, description, date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, amount);
            stmt.setString(2, category);
            stmt.setString(3, description);
            stmt.setString(4, date);
            stmt.executeUpdate();
            System.out.println("Expense added.");
        } catch (Exception e) {
            System.out.println("Error adding expense: " + e.getMessage());
        }
    }

    public void viewReport(Scanner scanner) {
        System.out.print("Enter month (YYYY-MM): ");
        String month = scanner.nextLine();

        try (Connection conn = com.fintrack.db.DBConnection.getConnection()) {
            String sql = "SELECT * FROM expenses WHERE date LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, month + "%");
            ResultSet rs = stmt.executeQuery();

            double total = 0;
            System.out.println("Expenses for " + month + ":");
            while (rs.next()) {
                double amt = rs.getDouble("amount");
                String cat = rs.getString("category");
                String desc = rs.getString("description");
                String date = rs.getString("date");
                System.out.println(date + " | " + cat + " | " + desc + " | $" + amt);
                total += amt;
            }
            System.out.println("Total: $" + total);
        } catch (Exception e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}
