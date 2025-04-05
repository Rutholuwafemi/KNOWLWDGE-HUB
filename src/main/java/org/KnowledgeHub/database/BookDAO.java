package org.KnowledgeHub.database;

//import org.KnowledgeHub.models.Book;
import org.KnowledgeHub.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // 1️⃣ Add a Book
    public static void insertBook(String title, String author, String year) {
        // Adjust SQL statement to exclude 'year'
        String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";  // No 'year'

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set values for the placeholders
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, year);

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Book added successfully!");
            } else {
                System.out.println("⚠️ No book was added.");
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Print the full error stack trace for debugging
            System.out.println(" Error inserting book: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        insertBook("Effective Java", "Joshua Bloch", "2019");
        insertBook("God is Good", "Ruth", "2020");

    }



    // 2️⃣ Get All Books
    public static void getAllBooks() {
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n Book List:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String year = rs.getString("year");

                System.out.println(" ID: " + id + ", Title: " + title + ", Author: " + author + ", Year");
            }

        } catch (SQLException e) {
            System.out.println(" Error fetching books: " + e.getMessage());
        }
    }


    // 3️⃣ Search for a Book by Title



    // 4️⃣ Update a Book
    public void updateBook(int id, String newTitle, String newAuthor, String newYear) {
        String sql = "UPDATE books SET title = ?, author = ?, year =? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newTitle);
            stmt.setString(2, newAuthor);
            stmt.setString(2, newYear);
            stmt.setInt(3, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully! ");
            } else {
                System.out.println("Book not found. ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public class TestDelete {
        public static void main(String[] args) {
            BookDAO bookDAO = new BookDAO();
            bookDAO.deleteBook(2);
        }
    }

    // 5️⃣ Delete a Book
    public void deleteBook(int id) {
        System.out.println("🔍 Trying to delete book with ID: " + id);

        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Book deleted successfully!");
            } else {
                System.out.println("❌ Book not found.");
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Error during delete: " + e.getMessage());
        }
    }
    public static void searchBooksByTitle(String title) {
        String sql = "SELECT * FROM books WHERE LOWER(title) LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + title.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("📚 Book Found:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Year: " + rs.getString("year"));

                System.out.println("--------------------------");
            }

            if (!found) {
                System.out.println(" No books found with that title.");
            }

        } catch (SQLException e) {
            System.out.println(" Error searching for books: " + e.getMessage());
        }
    }

    public static void searchBooksByAuthor(String author) {
        String sql = "SELECT * FROM books WHERE LOWER(author) LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + author.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("📚 Book Found:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Year: " + rs.getInt("year"));
                System.out.println("--------------------------");
            }

            if (!found) {
                System.out.println("❌ No books found by that author.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error searching for books by author: " + e.getMessage());
        }
    }


}
