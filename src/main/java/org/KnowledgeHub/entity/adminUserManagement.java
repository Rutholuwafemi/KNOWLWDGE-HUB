package org.KnowledgeHub.entity;
import org.KnowledgeHub.Knowledge;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
//import org.KnowledgeHub.entity.
//import org.KnowledgeHub.entity.
//import static org.KnowledgeHub.entity.Knowledge.

public class adminUserManagement {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
   // Book book = new Book();


    public static void adminUserManagement (){

    Knowledge knowledge = new Knowledge();
        while (true) {
            int choice = 0;

                System.out.println("\nLibrary Management System");
                System.out.println("1. Create User");
                System.out.println("2. View Users");
                System.out.println("3. Update User");
                System.out.println("4. Delete User");
                System.out.println("5. Deactivate User");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
            System.out.print("Enter choice (1-6): ");

            //System.out.println("Invalid input! Please enter an integer.");
            choice = scanner.nextInt();
            scanner.nextLine();
            boolean exit = false;

            switch (choice) {
                case 1 -> createUser();
                case 2 -> viewUsers();
                case 3 -> updateUser();
                case 4 -> deleteUser();
                case 5 -> deactivateUser();
                case 6 -> {
                   // System.out.println("Exiting... Goodbye!");
                     exit =true;
                }
                default->
                    System.out.println("Invalid choice. Please try again.");
            }
        }




    }



    private static void createUser() {
        //Knowledge knowledge = new Knowledge();

        try {
            System.out.print("Enter user_ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter username: ");
            String name = scanner.nextLine();
            System.out.print("Enter user category: ");
            String category = scanner.nextLine();

            users.add(new User());
            System.out.println("user created successfully!");
        } catch (InputMismatchException | NullPointerException e) {
            System.out.println("Error: Invalid input! Please enter a numeric value for the book ID.");
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("Invalid input");
        }


    }

    private static void viewUsers() {
        try {
            if (users.isEmpty()) {
                System.out.println("No user  available.");
            } else {
                System.out.println("\nList of users:");
                for (User user : users) {
                    System.out.println(user);
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
    private static void updateUser () {
        Knowledge knowledge = new Knowledge();

        boolean userFound= false;
        System.out.print("Enter the ID of the user to update: ");

        if (!scanner.hasNextInt()) { // Prevent crashes due to non-integer input
            System.out.println("Invalid input! Please enter a valid user_ID.");
            scanner.next(); // Clear invalid input
            return;
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (User user : users) {
            if (knowledge.getId() == id) {
                userFound = true;
                System.out.print("Enter new title (leave blank to keep current): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    knowledge.setName(name);
                }

                System.out.print("Enter new author (leave blank to keep current): ");
                String category = scanner.nextLine();
                if (!category.isEmpty()) {
                    knowledge.setCategory(category);
                }

                System.out.println("User updated successfully!");
                break;
            }
        }
        if (!userFound) {
            System.out.println("User not found.");


        }


    }



    private static void deleteUser() {
        Knowledge knowledge = new Knowledge();

        System.out.print("Enter the ID of the user to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (User user : users) {
            if (knowledge.getId() == id) {
                users.remove(user);
                System.out.println("Book deleted successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    private static void deactivateUser() {
    }

    static class Book {
        private int id;
        private String name;
        private String category;

        public Book(int id, String title, String author) {
            this.id = id;
            this.name = title;
            this.category = author;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return "User [ID=" + id + ", Name=\"" + name + "\", category=\"" + category + "\"]";
        }
    }
}
