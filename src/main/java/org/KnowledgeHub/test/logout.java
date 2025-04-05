package org.KnowledgeHub.test;

import org.KnowledgeHub.dao.UserDAO;

public class logout {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        userDAO.logoutUser();

    }

}
