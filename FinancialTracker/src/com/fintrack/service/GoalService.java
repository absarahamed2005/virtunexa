package com.fintrack.service;

import java.sql.*;
import java.util.Scanner;

public class GoalService {
    public void setGoal(Scanner scanner) {
        System.out.print("Enter month (YYYY-MM): ");
        String month = scanner.nextLine();
        System.out.print("Enter goal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        try (Connection conn = com.fintrack.db.DBConnection.getConnection()) {
            String sql = "REPLACE INTO goals (month, goal_amount) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, month);
            stmt.setDouble(2, amount);
            stmt.executeUpdate();
            System.out.println("Goal set for " + month);
        } catch (Exception e) {
            System.out.println("Error setting goal: " + e.getMessage());
        }
    }
}
