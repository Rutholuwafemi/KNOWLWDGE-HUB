package org.KnowledgeHub.database;

public class TestUpdate {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        bookDAO.updateBook(1, "Why i love Programming", "IBK", "2021");
    }
}
