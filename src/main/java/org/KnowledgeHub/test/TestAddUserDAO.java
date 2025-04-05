package org.KnowledgeHub.test;

import org.KnowledgeHub.dao.UserDAO;
import org.KnowledgeHub.model.Role;
import org.KnowledgeHub.model.User;

public class TestAddUserDAO {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Test adding a user
        Role adminRole = new Role(1, "Admin");
        User newUser = new User(1, "Ibk", "Phila123", adminRole);
        userDAO.addUser(newUser);

        // Test viewing all users

    }
}
