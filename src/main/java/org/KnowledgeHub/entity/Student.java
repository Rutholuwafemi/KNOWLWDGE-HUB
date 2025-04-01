//package org.KnowledgeHub.entity;
//import java.util.ArrayList;
//import java.util.List;
//
//   public class Student {
//        private String studentId;
//        private String name;
//        private String title;
//        private List<Book> readingHistory;
//        private List<Book> wishlist;
//
//        // Constructor
//
//        public Student(String studentId, String name) {
//            this.studentId = studentId;
//            this.name = name;
//            this.title = title;
//            this.readingHistory = new ArrayList<>();
//            this.wishlist = new ArrayList<>();
//        }
//
//       public Student() {
//
//       }
//
//       // Search for books by title
//        public void searchBookByTitle(List<Book> books, String title) {
//            boolean found = false;
//            for (Book book : books) {
//                if (book.getTitle().equalsIgnoreCase(title)) {
//                    System.out.println("Book Found: " + book);
//                    found = true;
//                }
//            }
//            if (!found) {
//                System.out.println("No book found with the title: " + title);
//            }
//        }
//
//        // Read a book
//        public void readBook(Book book) {
//            System.out.println("Reading book: " + book.getTitle());
//            readingHistory.add(book);  // Add book to history
//        }
//
//        // Save book to wishlist
//        public void addToWishlist(Book book) {
//            if (!wishlist.contains(book)) {
//                wishlist.add(book);
//                System.out.println(book.getTitle() + " added to your wishlist.");
//            } else {
//                System.out.println(book.getTitle() + " is already in your wishlist.");
//            }
//        }
//
//        // View reading history
//        public void viewReadingHistory() {
//            if (readingHistory.isEmpty()) {
//                System.out.println("You have not read any books yet.");
//            } else {
//                System.out.println("Your Reading History:");
//                for (Book book : readingHistory) {
//                    System.out.println(book);
//                }
//            }
//        }
//
//        // View wishlist
//        public void viewWishlist() {
//            if (wishlist.isEmpty()) {
//                System.out.println("Your wishlist is empty.");
//            } else {
//                System.out.println("Your Wishlist:");
//                for (Book book : wishlist) {
//                    System.out.println(book);
//                }
//            }
//        }
//    }
//
//
