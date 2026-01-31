package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws Exception {

        try (Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost/db",
                        "root", password); java.sql.PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.executeQuery();
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        System.out.println("I am never called");
    }

    // EVEN WORSE: another SQL injection
    public void deleteUser(String username) throws Exception {
        try (Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost/db",
                        "root", password); java.sql.PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.execute();
        }
    }

}
