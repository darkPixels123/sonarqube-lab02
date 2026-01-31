package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserService {

    private final String jdbcUrl;
    private final String dbUser;
    private final String dbPassword;

    public UserService() {
        this(
                System.getenv("DB_JDBC_URL"),
                System.getenv("DB_USER"),
                System.getenv("DB_PASSWORD"));
    }

    public UserService(String jdbcUrl, String dbUser, String dbPassword) {
        this.jdbcUrl = requireNonBlank(jdbcUrl, "DB_JDBC_URL");
        this.dbUser = requireNonBlank(dbUser, "DB_USER");
        this.dbPassword = requireNonBlank(dbPassword, "DB_PASSWORD");
    }

    private static String requireNonBlank(String value, String name) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(name + " must be set");
        }
        return value;
    }

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
    }

    public boolean userExists(String username) throws SQLException {
        Objects.requireNonNull(username, "username");

        String query = "SELECT 1 FROM users WHERE name = ? LIMIT 1";
        try (Connection conn = openConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public int deleteUser(String username) throws SQLException {
        Objects.requireNonNull(username, "username");

        String query = "DELETE FROM users WHERE name = ?";
        try (Connection conn = openConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            return ps.executeUpdate();
        }
    }
}
