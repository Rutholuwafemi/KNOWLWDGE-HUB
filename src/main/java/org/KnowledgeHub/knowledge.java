import java.util.*;
//import org.KnowledgeHub.entity
import org.KnowledgeHub.entity.LibrarianBM;


class KnowledgeHub {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<User> users = new ArrayList<>();
    private static final List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to KnowledgeHub Library Management System");
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
        System.out.print("Enter librarian password: ");
        if (!scanner.nextLine().equals("Custodian123")) {
            System.out.println("Invalid credentials. Returning to the main menu.");
            return;
        }

        // Create a Librarian object
        LibrarianBM librarian = new LibrarianBM();
        System.out.println("Welcome, " + librarian);

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

            books.add(new Book(id, title));
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


    private static void studentMenu() {
        System.out.println("Welcome Student! Access to library content coming soon...");
    }

    private static void guestMenu() {
        System.out.println("Welcome Guest! Browse limited resources coming soon...");
    }

    private static void exitSystem() {
        System.out.println("Exiting KnowledgeHub. Goodbye!");
        System.exit(0);
    }
}

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

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [ID=" + id + ", Title=" + title + "]";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
    }

    public void setAuthor(String author) {
    }

    public void setActive(boolean b) {
    }
}
