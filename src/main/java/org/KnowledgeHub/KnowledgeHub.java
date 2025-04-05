package org.KnowledgeHub;


import java.util.*;
//import org.KnowledgeHub.entity
//import org.KnowledgeHub.entity.LibrarianBM;
//import org.KnowledgeHub.entity.Student;
import org.KnowledgeHub.dao.UserDAO;
import org.KnowledgeHub.model.Role;
//import org.KnowledgeHub.model.User;

class User {
    private int id;
    private String username;
    private String password;
    private String role;

    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User [ID=" + id + ", Username=" + username + ", Role=" + role + "]";
    }
}

class Book {
    private int id;
    private String title;
    private String author;
     private  String year;

    public Book(int id, String title, String author, String year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year =year;
    }

    @Override
    public String toString() {
        return "Book [ID=" + id + ", Title=" + title +", Author=" + author +", Year=" + year + "]";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }



    public void setTitle(String title) {
    }

    public void setAuthor(String author) {
    }

    public void setActive(boolean b) {
    }
    public void setYear (String year){

    }

}


 class Student {
    private String studentId;
    private String name;
    private String title;
    private List<Book> readingHistory;
    private List<Book> wishlist;
    private String libraryBooks;

    // Constructor

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.title = title;
        this.readingHistory = new ArrayList<>();
        this.wishlist = new ArrayList<>();

    }


    public Student(String studentId, String name, String title, List<Book> readingHistory, List<Book> wishlist) {
        this.studentId = studentId;
        this.name = name;
        this.title = title;
        this.readingHistory = readingHistory;
        this.wishlist = wishlist;
    }

    public Student() {

    }

    // Search for books by title
    public void searchBookByTitle(List<Book> books, String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the title: " + title);
        }
    }

    // Read a book
    public void readBook(String title) {
        // Search for the book in the library
        Book book = findBookByTitle(title);

        if (book != null) {
            System.out.println("\n Reading: " + book.getTitle() + " by " + book.getAuthor() + book.getYear());
            readingHistory.add(book);  // Add book to reading history
        } else {
            System.out.println(" Book not found in the library.");
        }
    }

    // Helper method to find a book by title in the library
    private Book findBookByTitle(String title) {
        List<Book> libraryBooks = new ArrayList<>(); // Ensure it's initialized
        for (Book book : libraryBooks) { // Assuming libraryBooks is a list of all books
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book; // Return the matching book
            }
        }
        return null; // Return null if no book is found
    }


    // Save book to wishlist
    public void addToWishlist(Book book) {
        if (!wishlist.contains(book)) {
            wishlist.add(book);
            System.out.println(book.getTitle() + " added to your wishlist.");
        } else {
            System.out.println(book.getTitle() + " is already in your wishlist.");
        }
    }

    // View reading history
    public void viewReadingHistory() {
        if (readingHistory.isEmpty()) {
            System.out.println("You have not read any books yet.");
        } else {
            System.out.println("Your Reading History:");
            for (Book book : readingHistory) {
                System.out.println(book);
            }
        }
    }

    // View wishlist
    public void viewWishlist() {
        if (wishlist.isEmpty()) {
            System.out.println("Your wishlist is empty.");
        } else {
            System.out.println("Your Wishlist:");
            for (Book book : wishlist) {
                System.out.println(book);
            }
        }
    }



    //public void requestBook() {
}
public class KnowledgeHub {
    public static final Scanner scanner = new Scanner(System.in);
    private static final List<User> users = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to KnowledgeHub aka e-Library Management System");
        initializeUsers(); // Preload Admin for testing

        while (true) {
            displayMainMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> adminLogin();
                case 2 -> librarianMenu();
                case 3 -> studentMenu();
                case 4 -> guestMenu();
                case 0 -> exitSystem();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeUsers() {
        users.add(new User(1, "admin", "admin123", "Admin"));
    }

    private static void displayMainMenu() {
        System.out.println("\nSelect User Role:");
        System.out.println("1. Admin");
        System.out.println("2. Librarian");
        System.out.println("3. Student");
        System.out.println("4. Guest");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }

    private static void adminLogin() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getRole().equals("Admin") && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Admin Login Successful!");
                adminMenu();
                return;
            }
        }
        System.out.println("Invalid Admin credentials.");
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Remove User");
            System.out.println("0. Logout");
            System.out.print("Enter choice: ");

            switch (getChoice()) {
                case 1 -> addUser();
                case 2 -> viewUsers();
                case 3 -> removeUser();
                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addUser() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter User ID: ");
        int id = getChoice();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Role (Admin/Librarian/Student/Guest): ");
        String role = scanner.nextLine();

        users.add(new User(id, username, password, role));
        System.out.println("User added successfully!");
    }

    private static void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void removeUser() {
        System.out.print("Enter User ID to remove: ");
        int id = getChoice();

        users.removeIf(user -> user.getId() == id);
        System.out.println("User removed successfully!");
    }

    private static void librarianMenu() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter librarian password: ");
        String password = scanner.nextLine();
        if (!password.equals("Custodian123")) {
            System.out.println("Invalid password. Returning to the main menu.");
            return;
        }

        // Create a Librarian object
       // LibrarianBM librarian = new LibrarianBM();
       // System.out.println("Welcome, " + librarian);

        while (true) {
            System.out.println("\nLibrarian Menu:");
            System.out.println("1. Manage Books");
            System.out.println("2. View Catalog");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice (1-3): ");
            int choice = scanner.nextInt();
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

            System.out.print("Enter book year: ");
            String year = scanner.nextLine().trim();

            books.add(new Book(id, title, author, year));
            System.out.println("Book added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input! Please enter a valid numeric book ID.");
            scanner.nextLine();
        }
    }

    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    private static void updateBook() {
        System.out.print("Enter the ID of the book to update: ");
        int id = getUserChoice(0, Integer.MAX_VALUE);

        for (Book book : books) {
            if (book.getId() == id) {
                System.out.print("Enter new title (leave blank to keep current): ");
                String title = scanner.nextLine().trim();
                if (!title.isEmpty()){
                    book.setTitle(title);
                }

                System.out.print("Enter new author (leave blank to keep current): ");
                String author = scanner.nextLine().trim();
                if (!author.isEmpty()) {
                    book.setAuthor(author);
                }
                System.out.print("Enter book year (leave blank to keep current): ");
                String year = scanner.nextLine().trim();
                if (!year.isEmpty()) {
                    book.setAuthor(year);
                }


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

    private static void studentMenu() {
        Student student = new Student();
        System.out.println("Welcome Student! Access to library content coming soon...");

        while (true) {
            displayStudentMenu(); // Corrected method name
            int choice = getChoice(); // Use getChoice() for user input handling

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book title to search: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine(); // Get book title

                    // Search for book in the list
                    boolean found = false;
                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(title)) {
                            System.out.println(" Book Found: " + book.getTitle() + " by " + book.getAuthor()+ book.getYear());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println(" Book not found. Try another title.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter book title to read: ");
                    String title = scanner.nextLine();
                    student.readBook(title); // Pass the title to readBook()            readingHistory.add(book);  // Add book to history


                }
                case 3 -> {
                    System.out.print("Enter book title to add to wishlist: ");
                    String title = scanner.nextLine();
                    student.addToWishlist((Book) (books = new ArrayList<>())); // Pass the title to addToWishlist()
                }
                case 4 -> student.viewReadingHistory();
                case 5 -> student.viewWishlist();
                //case 6 -> student.requestBook();
                case 0 -> {
                    System.out.println("Exiting... ");
                    scanner.close();
                    return; // Exit the menu
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private static void displayStudentMenu() {
        System.out.println("\nE-Library Menu:");
        System.out.println("1. Search Book by Title");
        System.out.println("2. Read a Book");
        System.out.println("3. Add to Wishlist");
        System.out.println("4. View Reading History");
        System.out.println("5. View Wishlist");
        System.out.println("6. Request a Book");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void guestMenu() {
        System.out.println("Welcome Guest! Browse limited resources coming soon...");

    }

    private static void exitSystem() {
        System.out.println("Exiting KnowledgeHub. Goodbye!");
        System.exit(0);
    }


}


