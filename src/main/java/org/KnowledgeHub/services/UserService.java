package org.KnowledgeHub.services;

import org.KnowledgeHub.entity.Role;
import org.KnowledgeHub.entity.User;
import org.KnowledgeHub.repository.UserRepository;
//import org.KnowledgeHub.repository.RoleRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

//public class UserService {
//    private  RoleRepository roleRepository;
//    private final   UserRepository userRepository;
//    private final Connection connection; // Assuming a JDBC connection is available
//
//    public UserService(RoleRepository roleRepository, UserRepository userRepository, Connection connection) {
//        this.roleRepository = roleRepository;
//        this.userRepository = userRepository;
//        this.connection = connection;
//    }
//
//
//    public void createUser(String username, String password, Set<String> roleNames) throws SQLException {
//        connection.setAutoCommit(false); //
//        RoleRepository roleRepository1 = new RoleRepository(DatabaseConnection.getConnection());//
//        try {
//            // Fetch roles manually without using streams to handle SQLException properly
//            Set<Role> roles = new HashSet<>();
//            for (String roleName : roleNames) {
//                javax.management.relation.Role role = roleRepository1.findByName(roleName)
//                        .orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleName));
//
//            }
//
//            // Hash password before storing
//            String hashedPassword = hashPassword(password);
//
//            // Create and save user
//            User user = new User(null, username, hashedPassword, roles);
//            userRepository.save(user);
//
//            connection.commit(); // Commit transaction if everything is successful
//            System.out.println("User created successfully with roles: " + roleNames);
//        } catch (Exception e) {
//            connection.rollback(); // Rollback in case of failure
//            throw new RuntimeException("Error creating user: " + e.getMessage(), e);
//        } finally {
//            connection.setAutoCommit(true); // Reset to default
//        }
//    }
//
//    private String hashPassword(String password) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hashedBytes = md.digest(password.getBytes());
//            StringBuilder hexString = new StringBuilder();
//            for (byte b : hashedBytes) {
//                hexString.append(String.format("%02x", b));
//            }
//            return hexString.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("Error hashing password", e);
//        }
//    }
//
//    public boolean assignRole(int userId, String role) {
//        return false;
//    }
//
//    public RoleRepository getRoleRepository() {
//        return roleRepository;
//    }
//
//    public void setRoleRepository(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//}