////import org.KnowledgeHub.Knowledge;
////import org.KnowledgeHub.entity.Book;
////
////import java.util.ArrayList;
////import java.util.InputMismatchException;
////import java.util.Scanner;
////
////public class librarianBookManagement {
////    private static ArrayList<Book> books = new ArrayList<>();
////    private static Scanner scanner = new Scanner(System.in);
////
////
////    public static void main(String[] args) {
////        Knowledge knowledge = new Knowledge();
////        while (true) {
////            int choice = 0;
////
////            System.out.println("\nLibrary Management System");
////            System.out.println("1. Add Book(s)");
////            System.out.println("2. View Books");
////            System.out.println("3. Update Book");
////            System.out.println("4. Delete Book");
////            System.out.println("5. Deactivate Book");
////            System.out.println("6. Exit");
////            System.out.print("Enter choice (1-6): ");
////
////            //System.out.println("Invalid input! Please enter an integer.");
////            choice = scanner.nextInt();
////            scanner.nextLine();
////            boolean exit = false;
////
////            switch (choice) {
////                case 1 -> addBook();
////                case 2 -> viewBooks();
////                case 3 -> updateBook();
////                case 4 -> deleteBook();
////                //case 5 -> deactivateBook();
////                case 6 -> {
////                    // System.out.println("Exiting... Goodbye!");
////                    exit = true;
////                }
////                default -> System.out.println("Invalid choice. Please try again.");
////            }
////        }
////
////
////    }
////
////    private static void deleteBook() {
////        System.out.print("Enter the ID of the book to delete: ");
////        int id = scanner.nextInt();
////        scanner.nextLine(); // Consume newline
////
////        for (Book book : books) {
////            if (book.getId() == id) {
////                books.remove(book);
////                System.out.println("Book deleted successfully!");
////                return;
////            }
////        }
////
////        System.out.println("Book not found.");
////    }
////
////
////    private static void viewBooks() {
////        try {
////            if (books.isEmpty()) {
////                System.out.println("No books available.");
////            } else {
////                System.out.println("\nList of Books:");
////                for (Book book : books) {
////                    System.out.println(book);
////                }
////            }
////
////
////        } catch (InputMismatchException | NullPointerException e) {
////            System.out.println("Error: Invalid input! Please enter a numeric value for the book ID.");
////            scanner.nextLine();
////        } catch (Exception e) {
////            System.out.println("Invalid input");
////        }
////        return;
////    }
////
////    private static void updateBook() {
////        boolean bookFound = false;
////        System.out.print("Enter the ID of the book to update: ");
////
////        if (!scanner.hasNextInt()) { // Prevent crashes due to non-integer input
////            System.out.println("Invalid input! Please enter a valid book ID.");
////            scanner.next(); // Clear invalid input
////            return;
////        }
////        int id = scanner.nextInt();
////        scanner.nextLine(); // Consume newline
////
////        for (Book book : books) {
////            if (book.getId() == id) {
////                bookFound = true;
////                System.out.print("Enter new title (leave blank to keep current): ");
////                String title = scanner.nextLine();
////                if (!title.isEmpty()) {
////                    book.setTitle(title);
////                }
////
////                System.out.print("Enter new author (leave blank to keep current): ");
////                String author = scanner.nextLine();
////                if (!author.isEmpty()) {
////                    book.setAuthor(author);
////                }
////
////                System.out.println("Book updated successfully!");
////                break;
////            }
////        }
////        if (!bookFound) {
////            System.out.println("Book not found.");
////
////
////        }
////
////    }
////
////    private static void addBook() {
////        Book book = new Book();
////        try {
////            System.out.print("Enter book ID: ");
////            int id = scanner.nextInt();
////            scanner.nextLine(); // Consume newline
////            System.out.print("Enter book title: ");
////            String title = scanner.nextLine();
////            System.out.print("Enter book author: ");
////            String author = scanner.nextLine();
////            scanner.nextLine(); // Consume newline
////            System.out.println("Book added successfully!");
////        } catch (InputMismatchException | NullPointerException e) {
////            System.out.println("Error: Invalid input! Please enter a numeric value for the book ID.");
////            scanner.nextLine();
////        } catch (Exception e) {
////            System.out.println("Invalid input");
////        }
////
////
////    }
////}
//import java.util.*;
//
//// User class
//class User {
//    private String name;
//    private String role;
//
//    public User(String name, String role) {
//        this.name = name;
//        this.role = role;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getRole() {
//        return role;
//    }
//}
//
//// Book class
//class Book {
//    private String title;
//    private String author;
//
//    public Book(String title, String author) {
//        this.title = title;
//        this.author = author;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    @Override
//    public String toString() {
//        return "Title: " + title + ", Author: " + author;
//    }
//}
//
//// Student class
//class Student {
//    private String name;
//    private List<Book> borrowedBooks;
//
//    public Student(String name) {
//        this.name = name;
//        this.borrowedBooks = new ArrayList<>();
//    }
//
//    public void borrowBook(Book book) {
//        borrowedBooks.add(book);
//    }
//
//    public void returnBook(Book book) {
//        borrowedBooks.remove(book);
//    }
//
//    public List<Book> getBorrowedBooks() {
//        return borrowedBooks;
//    }
//
//    public static void searchBookByTitle(List<Book> books, String title) {
//        books.stream()
//                .filter(book -> book.getTitle().equalsIgnoreCase(title))
//                .findFirst()
//                .ifPresentOrElse(
//                        book -> System.out.println("Book Found: " + book),
//                        () -> System.out.println("Book not found.")
//                );
//    }
//}
//
//// Main Library System
//public class KnowledgeHub {
//    private static final Scanner scanner = new Scanner(System.in);
//    private static final List<User> users = new ArrayList<>();
//    private static final List<Book> books = new ArrayList<>();
//
//    public static void main(String[] args) {
//        System.out.println("Welcome to KnowledgeHub Library Management System");
//        runMenu();
//    }
//
//    private static void runMenu() {
//        while (true) {
//            System.out.println("Select User Type: 1. Admin 2. Librarian 3. Student 4. Guest 5. Exit");
//            int choice = getChoice(1, 5);
//
//            switch (choice) {
//                case 1 -> adminMenu();
//                case 2 -> librarianMenu();
//                case 3 -> studentMenu();
//                case 4 -> guestMenu();
//                case 5 -> {
//                    System.out.println("Exiting system. Goodbye!");
//                    System.exit(0);
//                }
//            }
//        }
//    }
//
//    private static void adminMenu() {
//        System.out.println("Admin Menu: 1. View Users 2. Add User 3. Remove User 4. Back");
//        int choice = getChoice(1, 4);
//
//        switch (choice) {
//            case 1 -> viewUsers();
//            case 2 -> addUser();
//            case 3 -> removeUser();
//            case 4 -> runMenu();
//        }
//    }
//
//    private static void librarianMenu() {
//        System.out.println("Librarian Menu: 1. Add Book 2. Remove Book 3. View Books 4. Back");
//        int choice = getChoice(1, 4);
//
//        switch (choice) {
//            case 1 -> addBook();
//            case 2 -> removeBook();
//            case 3 -> viewBooks();
//            case 4 -> runMenu();
//        }
//    }
//
//    private static void studentMenu() {
//        System.out.println("Student Menu: 1. View Books 2. Search Book 3. Back");
//        int choice = getChoice(1, 3);
//
//        switch (choice) {
//            case 1 -> viewBooks();
//            case 2 -> {
//                System.out.print("Enter book title: ");
//                String title = scanner.nextLine();
//                Student.searchBookByTitle(books, title);
//            }
//            case 3 -> runMenu();
//        }
//    }
//
//    private static void guestMenu() {
//        System.out.println("Guest Menu: 1. View Books 2. Back");
//        int choice = getChoice(1, 2);
//
//        switch (choice) {
//            case 1 -> viewBooks();
//            case 2 -> runMenu();
//        }
//    }
//
//    private static void addUser() {
//        System.out.print("Enter User Name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter Role (Admin/Librarian/Student/Guest): ");
//        String role = scanner.nextLine();
//        users.add(new User(name, role));
//        System.out.println("User added successfully!");
//    }
//
//    private static void removeUser() {
//        System.out.print("Enter User Name to Remove: ");
//        String name = scanner.nextLine();
//        users.removeIf(user -> user.getName().equalsIgnoreCase(name));
//        System.out.println("User removed if found.");
//    }
//
//    private static void addBook() {
//        System.out.print("Enter Book Title: ");
//        String title = scanner.nextLine();
//        System.out.print("Enter Author Name: ");
//        String author = scanner.nextLine();
//        books.add(new Book(title, author));
//        System.out.println("Book added successfully!");
//    }
//
//    private static void removeBook() {
//        System.out.print("Enter Book Title to Remove: ");
//        String title = scanner.nextLine();
//        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
//        System.out.println("Book removed if found.");
//    }
//
//    private static void viewBooks() {
//        if (books.isEmpty()) {
//            System.out.println("No books available.");
//        } else {
//            books.forEach(System.out::println);
//        }
//    }
//
//    private static void viewUsers() {
//        if (users.isEmpty()) {
//            System.out.println("No users available.");
//        } else {
//            users.forEach(user -> System.out.println(user.getName() + " - " + user.getRole()));
//        }
//    }
//
//    private static int getChoice(int min, int max) {
//        int choice;
//        while (true) {
//            try {
//                choice = Integer.parseInt(scanner.nextLine());
//                if (choice >= min && choice <= max) {
//                    return choice;
//                }
//            } catch (NumberFormatException ignored) {}
//            System.out.println("Invalid choice, try again.");
//        }
//    }
//}
//
////
////
