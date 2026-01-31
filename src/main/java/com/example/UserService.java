package main.java.com.example; // Corrected package name

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public void findUser(String username) throws SQLException {
        String sql = "SELECT id, name, email FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", PASSWORD); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, username);
            st.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        // SECURITY FIX: In a real app, add an 'isAdmin' check here
        String sql = "DELETE FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", PASSWORD); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, username);
            st.execute();
        }
    }
}
