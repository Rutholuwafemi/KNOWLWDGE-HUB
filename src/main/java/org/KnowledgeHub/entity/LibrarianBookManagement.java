import org.KnowledgeHub.Knowledge;
import org.KnowledgeHub.entity.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class librarianBookManagement {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Knowledge knowledge = new Knowledge();
        while (true) {
            int choice = 0;

            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book(s)");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Deactivate Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            //System.out.println("Invalid input! Please enter an integer.");
            choice = scanner.nextInt();
            scanner.nextLine();
            boolean exit = false;

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                //case 5 -> deactivateBook();
                case 6 -> {
                    // System.out.println("Exiting... Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }


    }

    private static void deleteBook() {
        System.out.print("Enter the ID of the book to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }


    private static void viewBooks() {
        try {
            if (books.isEmpty()) {
                System.out.println("No books available.");
            } else {
                System.out.println("\nList of Books:");
                for (Book book : books) {
                    System.out.println(book);
                }
            }


        } catch (InputMismatchException | NullPointerException e) {
            System.out.println("Error: Invalid input! Please enter a numeric value for the book ID.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        return;
    }

    private static void updateBook() {
        boolean bookFound = false;
        System.out.print("Enter the ID of the book to update: ");

        if (!scanner.hasNextInt()) { // Prevent crashes due to non-integer input
            System.out.println("Invalid input! Please enter a valid book ID.");
            scanner.next(); // Clear invalid input
            return;
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Book book : books) {
            if (book.getId() == id) {
                bookFound = true;
                System.out.print("Enter new title (leave blank to keep current): ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) {
                    book.setTitle(title);
                }

                System.out.print("Enter new author (leave blank to keep current): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) {
                    book.setAuthor(author);
                }

                System.out.println("Book updated successfully!");
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book not found.");


        }

    }

    private static void addBook() {
        Book book = new Book();
        try {
            System.out.print("Enter book ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            scanner.nextLine(); // Consume newline
            System.out.println("Book added successfully!");
        } catch (InputMismatchException | NullPointerException e) {
            System.out.println("Error: Invalid input! Please enter a numeric value for the book ID.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }


    }
}


