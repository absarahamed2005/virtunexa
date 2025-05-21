package com.fintrack.db;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:financial_tracker.db");
    }
}
