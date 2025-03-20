package org.KnowledgeHub.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
        private static Connection connection;

    public DatabaseConnection() {
    }

    public static void setConnection(Connection connection) {
        DatabaseConnection.connection = connection;
    }

    public static Connection getConnection() {
            if (connection == null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return connection;
        }
    }


