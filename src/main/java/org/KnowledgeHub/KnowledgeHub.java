
import java.util.Scanner;

//import static org.KnowledgeHub.entity.userManagement.userManagement;

public class knowledgeHub {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n Welcome to KNOWLEDGE HUB");
            System.out.println("Please choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. Librarian");
            System.out.println("3. Student");
            System.out.println("4. Guest");
            System.out.println("5. Exit");

            System.out.print("Enter choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> handleAdmin(scanner);
                case 2 -> handleLibrarian(scanner);
                case 3 -> handleStudent(scanner);
                case 4 -> handleGuest();
                case 5 -> {
                    System.out.println("Thank you for using the KNOWLEDGE HUB Goodbye!");
                    exit = true;
                }
                default -> System.out.println(" Invalid choice. Please select a valid option.\n");
            }
        }
        scanner.close();
    }




    private static void handleAdmin(Scanner scanner) {
        System.out.println(" Welcome, Admin! Accessing admin functionalities...");
        scanner.nextLine();
        // Ensure UserService and UserRepository are initialized
        //DatabaseConnection databaseConnection = new DatabaseConnection();
        //DatabaseMetaData DatabaseConnection = null;
//        UserService userService = null;
//        try {
//            userService = new UserService(new RoleRepository(DatabaseConnection.getConnection()));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("Enter admin login credentials:");
        String userPass = scanner.nextLine();
        if (userPass.equals("Admin123")) {
            System.out.println("User validated........WELCOME ADMIN");

        } else {
            System.out.println("Invalid credentials.......Please try again!");
            return;
        }

        System.out.println("What would you love to do today!");
        System.out.println("1. Configuration & Authorization");
        System.out.println("2. User Management");
        System.out.println("3. Book Management");
        System.out.println("4. Reports & Analytics");
        System.out.println("5. Backup & Restore");

        System.out.print("Enter choice (1-5): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        boolean exit = false;


        switch (choice) {
            case 1 -> configurationAuthorization(scanner);
            //case 2 -> userManagement();
            //case 3 -> bookManagement();
            //case 4 -> reportsAnalytics();
            //case 5 -> reportsAnalytics();
            case 6 -> {
                System.out.println("Thank you for using KNOWLEDGE HUB Goodbye!");
                exit = true;
            }
            default -> System.out.println(" Invalid choice. Please select a valid option.\n");
        }
    }
    private static void configurationAuthorization(Scanner scanner) {
        System.out.print("Enter the user ID to assign a role: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Display Role Options
        System.out.println("Choose a role to assign: ");
        System.out.println("1. Librarian");
        System.out.println("2. Student");
        System.out.println("3. Guest");
        System.out.print("Enter your choice: ");

        // Capture Role Choice
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Determine Role Using Switch Expression
        String role = switch (choice) {
            case 1 -> "Librarian";
            case 2 -> "Student";
            case 3 -> "Guest";
            default -> null; // Handle invalid input
        };

        // Validate and Confirm Role Assignment
        if (role == null) {
            System.out.println("Invalid choice. Role assignment failed.");
        } else {
            System.out.println("User with ID " + userId + " has been successfully assigned the role of " + role + ".");
        }

    }
    // Prompt for User ID



}




    //        boolean updated = userService.assignRole(userId, role);
//        if (updated) {
//            System.out.println(" Role assigned successfully: User " + userId + " is now a " + role);
//        } else {
//            System.out.println(" Failed to assign role. User not found.");
//        }
    private static void handleLibrarian (Scanner scanner) {
        System.out.println("Welcome, Librarian! Accessing librarian functionalities...");
        // Call LibrarianController methods here
        System.out.println("Enter login credentials:");
        String userPass = scanner.nextLine();
        if (userPass.equals("Custodian123")) {
            System.out.println("User validated........WELCOME Librarian");

        } else {
            System.out.println("Invalid credentials.......Please try again!");
            return;
        }

        System.out.println("What would you love to do today!");
        System.out.println("1. Book Catalog Management\n");
        System.out.println("2. User Support");
        System.out.println("3. Order Management");
        System.out.println("4. Reports & Analytics");

        System.out.print("Enter choice (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        boolean exit = false;


        switch (choice) {
            case 1 -> bookCatalogManagement(scanner);
            //case 2 -> userSupport();
            //case 3 -> orderManagement();
            //case 4 -> reportsAnalytics();
            case 5 -> {
                System.out.println("Thank you for using KNOWLEDGE HUB Goodbye!");
                exit = true;
            }
            default -> System.out.println(" Invalid choice. Please select a valid option.\n");
        }
    }

    private static void bookCatalogManagement(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Book Catalog Management ===");
            System.out.println("1. Add a New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book Details");
            System.out.println("4. Remove a Book");
            System.out.println("5. Search for a Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    removeBook(scanner);
                    break;
                case 5:
                    searchBook(scanner);
                    break;
                case 6:
                    System.out.println("Exiting Book Catalog Management...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.println("Book added: " + title + " by " + author);
    }

    private static void viewBooks() {
        System.out.println("Displaying all books...");
        // Logic to display books
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter ISBN of book to update: ");
        String isbn = scanner.nextLine();
        System.out.println("Updating book with ISBN: " + isbn);
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Enter ISBN of book to remove: ");
        String isbn = scanner.nextLine();
        System.out.println("Book removed: " + isbn);
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();
        System.out.println("Searching for books with keyword: " + keyword);
    }



    private static void handleStudent (Scanner scanner) {
        System.out.println(" Welcome, Student! Accessing student functionalities...");
        // Call StudentController methods here
        while (true) {
            System.out.println("\n Welcome, Student! Accessing student functionalities...");
            System.out.println("1. Search and Read Digital Books");
            System.out.println("2. Bookmark or Save Favorites");
            System.out.println("3. View Reading History");
            System.out.println("4. Receive Notifications");
            System.out.println("5. Update Profile");
            System.out.println("6. Request New Materials");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchAndReadBooks(scanner);
                    break;
                case 2:
                    bookmarkBook(scanner);
                    break;
                case 3:
                    viewReadingHistory();
                    break;
                case 4:
                    viewNotifications();
                    break;
                case 5:
                    updateProfile(scanner);
                    break;
                case 6:
                    requestNewMaterials(scanner);
                    break;
                case 7:
                    System.out.println("Exiting Student Portal...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void searchAndReadBooks(Scanner scanner) {
        System.out.print("Enter book title, author, or keyword: ");
        String query = scanner.nextLine();
        System.out.println("Searching for: " + query);
        // Simulate book search and reading
        System.out.println("Displaying available digital books...");
    }

    private static void bookmarkBook(Scanner scanner) {
        System.out.print("Enter Book ID to bookmark: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Book with ID " + bookId + " bookmarked successfully.");
    }

    private static void viewReadingHistory() {
        System.out.println("Displaying your reading history...");
        // Logic to retrieve and display reading history
    }

    private static void viewNotifications() {
        System.out.println("Fetching your notifications...");
        // Logic to display alerts about new books and updates
    }

    private static void updateProfile(Scanner scanner) {
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.println("Profile updated with email: " + email);
    }

    private static void requestNewMaterials(Scanner scanner) {
        System.out.print("Enter the book title or material you want to request: ");
        String request = scanner.nextLine();
        System.out.println("Your request for '" + request + "' has been submitted.");
    }


    private static void handleGuest () {
        System.out.println(" Welcome, Guest! Limited access granted...");
        // Call GuestController methods here
    }






