package org.KnowledgeHub.dao;

import org.KnowledgeHub.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.KnowledgeHub.database.DatabaseConnection;

import java.sql.*;

public class WishlistDAO {
    int userId;
    int bookId;

    public static void addToWishlist(int userId, int bookId) {
        String sql = "INSERT INTO wishlist (user_id, book_id) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, bookId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(" Book added to wishlist!");
            } else {
                System.out.println(" Failed to add book to wishlist.");
            }

        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }





        // New method to view wishlist for a user
        public static void viewWishlist(int userId) {
            String sql = "SELECT b.id, b.title, b.author, b.year, w.added_at " +
                    "FROM wishlist w " +
                    "JOIN books b ON w.book_id = b.id " +
                    "WHERE w.user_id = ?";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, userId);
                ResultSet rs = pstmt.executeQuery();

                boolean found = false;
                System.out.println("\n===== Your Wishlist =====");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    int year = rs.getInt("year");
                    Timestamp addedAt = rs.getTimestamp("added_at");

                    System.out.println("ID: " + id +
                            ", Title: " + title +
                            ", Author: " + author +
                            ", Year: " + year +
                            ", Added: " + addedAt);
                    found = true;
                }

                if (!found) {
                    System.out.println("Your wishlist is empty.");
                }

            } catch (SQLException e) {
                System.out.println(" Error fetching wishlist: " + e.getMessage());
            }
        }
    }


