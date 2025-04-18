package org.KnowledgeHub.database;

import org.KnowledgeHub.dao.WishlistDAO;
import org.KnowledgeHub.entity.Book;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import static org.KnowledgeHub.KnowledgeHub.scanner;

public class BookDAO {

    // ✅ 1. Insert Book
    public static void insertBook(String title, String author, String year) {
        String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, year);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(" Book added successfully!");
            } else {
                System.out.println(" No book was added.");
            }
        } catch (SQLException e) {
            System.err.println(" Error inserting book: " + e.getMessage());
        }
    }

    // ✅ 2. Get All Books
    public static void getAllBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n📚 Book List:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String year = rs.getString("year");

                System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Year: " + year);
            }

        } catch (SQLException e) {
            System.err.println(" Error fetching books: " + e.getMessage());
        }
    }

    // ✅ 3. Update Book
    public static void updateBook(int id, String newTitle, String newAuthor, String newYear) {
        String sql = "UPDATE books SET title = ?, author = ?, year = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newTitle);
            stmt.setString(2, newAuthor);
            stmt.setString(3, newYear);
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(" Book updated successfully!");
            } else {
                System.out.println(" Book not found.");
            }

        } catch (SQLException e) {
            System.err.println(" Error updating book: " + e.getMessage());
        }
    }

    // ✅ 4. Delete Book
    public static void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println(" Book deleted successfully!");
            } else {
                System.out.println(" Book not found.");
            }

        } catch (SQLException e) {
            System.err.println(" Error deleting book: " + e.getMessage());
        }
    }

    // ✅ 5. Search by Title
    public static void searchBooksByTitle(String title) {
        String sql = "SELECT * FROM books WHERE LOWER(title) LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + title.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("📘 Book Found:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Year: " + rs.getString("year"));
                System.out.println("----------------------");
            }

            if (!found) {
                System.out.println(" No books found with that title.");
            }

        } catch (SQLException e) {
            System.err.println(" Error searching books: " + e.getMessage());
        }
    }

    // ✅ 6. Search by Author
    public static void searchBooksByAuthor(String author) {
        String sql = "SELECT * FROM books WHERE LOWER(author) LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + author.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(" Book Found:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Year: " + rs.getString("year"));
                System.out.println("----------------------");
            }

            if (!found) {
                System.out.println("⚠️ No books found by that author.");
            }

        } catch (SQLException e) {
            System.err.println(" Error: " + e.getMessage());
        }
    }

    // ✅ 7. Read Book by Title
    public static void readBookByTitle(String title) {
        String sql = "SELECT title, author, year, content FROM books WHERE title ILIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + title + "%");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Year: " + rs.getString("year"));
                System.out.println("Content:\n" + rs.getString("content"));
            } else {
                System.out.println(" No book found with that title.");
            }

        } catch (SQLException e) {
            System.err.println(" Error reading book: " + e.getMessage());
        }
    }

    // ✅ 8. Add to Wishlist
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
                System.out.println(" Failed to add to wishlist.");
            }

        } catch (SQLException e) {

        }

    }

    public static void viewReadingHistory(int userId) {
        String query = "SELECT book_title, read_date FROM reading_history WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Reading History:");
            boolean hasHistory = false;
            while (rs.next()) {
                hasHistory = true;
                System.out.println("Book: " + rs.getString("book_title") +
                        " | Read Date: " + rs.getDate("read_date"));
            }

            if (!hasHistory) {
                System.out.println("You haven't read any books yet.");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching reading history: " + e.getMessage());
        }
    }

}