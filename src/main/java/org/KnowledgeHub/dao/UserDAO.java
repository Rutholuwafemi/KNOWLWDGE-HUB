package org.KnowledgeHub.dao;

import org.KnowledgeHub.database.DatabaseConnection;
import org.KnowledgeHub.model.User;
import org.KnowledgeHub.model.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Add a new user
    public void addUser(User user) {
        String sql = "INSERT INTO users (username, password, role_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getRole().getId());
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("Error adding user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all users
    public void viewUsers() {
        String sql = "SELECT u.id, u.username, r.name AS role FROM users u JOIN roles r ON u.role_id = r.id";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String role = rs.getString("role");
                System.out.println("ID: " + id + ", Username: " + username + ", Role: " + role);
            }

        } catch (SQLException e) {
            System.out.println(" Error fetching users: " + e.getMessage());
        }
    }

    // Remove a user
    public void removeUser(int userId) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User removed successfully!");
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Simulate logging out by clearing user session (just a placeholder for now)
    public void logoutUser() {
        // In real-world, clear session or user info (here, we'll just simulate)
        System.out.println("Logged out successfully!");
    }
}
