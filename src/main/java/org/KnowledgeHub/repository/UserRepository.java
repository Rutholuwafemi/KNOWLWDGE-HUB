package org.KnowledgeHub.repository;

import org.KnowledgeHub.entity.Role;
import org.KnowledgeHub.entity.User;

import java.sql.*;
import java.util.Optional;
public class UserRepository {
    private final Connection connection;
    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public Optional<Role> findByName(String name) throws SQLException {
        String sql = "SELECT * FROM roles WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Role(rs.getLong("id"), rs.getString("name")));
            }
        }
        return Optional.empty();
    }

    public void save(User user) {
    }
}