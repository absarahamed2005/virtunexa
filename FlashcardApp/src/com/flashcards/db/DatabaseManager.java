package com.flashcards.db;

import com.flashcards.model.Flashcard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:flashcards.db";

    public DatabaseManager() {
        createTable();
    }

    private void createTable() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS flashcards (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "question TEXT NOT NULL," +
                         "answer TEXT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertFlashcard(Flashcard card) {
        String sql = "INSERT INTO flashcards(question, answer) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, card.getQuestion());
            pstmt.setString(2, card.getAnswer());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flashcard> getAllFlashcards() {
        List<Flashcard> list = new ArrayList<>();
        String sql = "SELECT * FROM flashcards";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Flashcard(rs.getInt("id"), rs.getString("question"), rs.getString("answer")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}