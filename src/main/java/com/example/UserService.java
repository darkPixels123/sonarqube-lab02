package com.example; // Corrected package name

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static final String DB_USER = System.getenv("DB_USER");

    public void findUser(String username) throws SQLException {
        String query = "SELECT id, name, email FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", DB_USER, PASSWORD); PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, username);
            st.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        // STRIDE Mitigation: In a real app, add an Authorization check here!
        String query = "DELETE FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", DB_USER, PASSWORD); PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, username);
            st.execute();
        }
    }
}
