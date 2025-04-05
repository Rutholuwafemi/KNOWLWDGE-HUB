package org.KnowledgeHub.test;

import org.KnowledgeHub.dao.UserDAO;

public class TestViewUsers {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        // View all users in the database
        userDAO.viewUsers();
    }
}
