package org.KnowledgeHub.entity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarianBM {

    private static final ArrayList<Book> books = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayLibrarianMenu();
            int choice = getUserChoice(1, 3);

            switch (choice) {
                case 1 -> manageBooks();
                case 2 -> manageCatalog();
                case 3 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
            }
        }
    }

    private static void displayLibrarianMenu() {
        System.out.println("\nLibrarian Menu:");
        System.out.println("1. Manage Books");
        System.out.println("2. Manage Catalog");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter choice (1-3): ");
    }

    public static void manageBooks() {
        while (true) {
            displayManageBooksMenu();
            int choice = getUserChoice(1, 6);

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 5 -> deactivateBook();
                case 6 -> {
                    System.out.println("Returning to Librarian Menu...");
                    return;
                }
            }
        }
    }

    private static void displayManageBooksMenu() {
        System.out.println("\nLibrarian Book Management System");
        System.out.println("1. Add Book(s)");
        System.out.println("2. View Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Deactivate Book");
        System.out.println("6. Back to Librarian Menu");
        System.out.print("Enter choice (1-6): ");
    }

    private static int getUserChoice(int min, int max) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void addBook() {
        try {
            System.out.print("Enter book ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter book title: ");
            String title = scanner.nextLine().trim();

            System.out.print("Enter book author: ");
            String author = scanner.nextLine().trim();

            books.add(new Book());
            System.out.println("Book added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input! Please enter a valid numeric book ID.");
            scanner.nextLine();
        }
    }

    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\nList of Books:");
            books.forEach(System.out::println);
        }
    }

    private static void updateBook() {
        System.out.print("Enter the ID of the book to update: ");
        int id = getUserChoice(0, Integer.MAX_VALUE);

        for (Book book : books) {
            if (book.getId() == id) {
                System.out.print("Enter new title (leave blank to keep current): ");
                String title = scanner.nextLine().trim();
                if (!title.isEmpty()) book.setTitle(title);

                System.out.print("Enter new author (leave blank to keep current): ");
                String author = scanner.nextLine().trim();
                if (!author.isEmpty()) book.setAuthor(author);

                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void deleteBook() {
        System.out.print("Enter the ID of the book to delete: ");
        int id = getUserChoice(0, Integer.MAX_VALUE);

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void deactivateBook() {
        System.out.print("Enter the ID of the book to deactivate: ");
        int id = getUserChoice(0, Integer.MAX_VALUE);

        for (Book book : books) {
            if (book.getId() == id) {
                book.setActive(false);
                System.out.println("Book deactivated successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void manageCatalog() {
        System.out.println("Catalog management is under development.");
    }

    public void viewCatalog() {
    }
}
