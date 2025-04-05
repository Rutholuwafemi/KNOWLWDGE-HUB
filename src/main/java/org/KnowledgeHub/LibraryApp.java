package org.KnowledgeHub;

import org.KnowledgeHub.database.BookDAO;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Welcome to KnowledgeHub Library System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String year = scanner.nextLine();

                    BookDAO.insertBook(title, author, year);
                    break;

                case 2:
                    bookDAO.getAllBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // clear buffer

                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("New Author: ");
                    String newYear = scanner.nextLine();


                    bookDAO.updateBook(updateId, newTitle, newAuthor, newYear);
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    bookDAO.deleteBook(deleteId);
                    break;

                case 5:
                    System.out.println(" Exiting. Goodbye!");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }

        } while (choice != 5);
    }
}
