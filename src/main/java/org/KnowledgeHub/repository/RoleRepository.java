package org.KnowledgeHub.repository;

//ublic class RoleRepository {
    //private Connection connection; // Declare connection variable

//    //  Constructor should accept Connection as a parameter
//    public RoleRepository(Connection connection) {
//        this.connection = this.connection;
//    }
//
//    //public Optional<Role> findByName(String name) throws SQLException {
//        String sql = "SELECT * FROM roles WHERE name = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, name);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return Optional.ofNullable(rs.getString("id"))
//                        .map(id -> new Role(id,
//                                rs.getString("name")));
//            }
//        }
//        return Optional.empty();
//    }
//}
