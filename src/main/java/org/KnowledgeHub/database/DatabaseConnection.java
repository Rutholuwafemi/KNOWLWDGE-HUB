package org.KnowledgeHub.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/KnowledgeHub";
    private static final String USER = "postgres";
    private static final String PASSWORD = "heartland@2021";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    // Test connection
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println(" Database Connection Successful!");
        } else {
            System.out.println(" Failed to Connect to Database.");
        }
    }
}
