package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserService {

    // Load password from environment variable
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws java.sql.SQLException {

        try (Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost/db",
                        "root", PASSWORD); java.sql.PreparedStatement st = conn.prepareStatement("SELECT id, name, email FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.executeQuery();
        }
    }

    // SMELL: Unused method
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserService.class.getName());

    public void notUsed() {
        logger.info("I am never called");
    }

    // EVEN WORSE: another SQL injection
    public void deleteUser(String username) throws java.sql.SQLException {
        try (Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost/db",
                        System.getenv("DB_USER"), PASSWORD); java.sql.PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.execute();
        }
    }

}
