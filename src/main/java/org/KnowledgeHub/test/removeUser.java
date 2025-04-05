package org.KnowledgeHub.test;

import org.KnowledgeHub.dao.UserDAO;

public class removeUser {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        userDAO.removeUser(4); // assuming user ID 1 exists

    };
    }



