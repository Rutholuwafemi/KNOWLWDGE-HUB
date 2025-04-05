package org.KnowledgeHub.database;

public class TestReadAll {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        bookDAO.getAllBooks();
    }
}
