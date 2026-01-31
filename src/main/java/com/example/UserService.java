package com.example; // Corrected package name

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static final String DB_USER = System.getenv("DB_USER");

    public void findUser(String username) throws SQLException {
        // Use try-with-resources for better reliability
        String sql = "SELECT id, name, email FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", DB_USER, PASSWORD); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, username);
            st.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        // STRIDE Mitigation: In a real app, verify user permissions here
        String sql = "DELETE FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", DB_USER, PASSWORD); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, username);
            st.execute();
        }
    }
    // REMOVED: Unused logger and notUsed() method to clear Sonar smells
}
