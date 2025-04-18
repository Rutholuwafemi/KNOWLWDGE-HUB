package org.KnowledgeHub.entity;

public class Role {
    private Long id;
    private String name; // e.g., "ADMIN", "LIBRARIAN", "STUDENT", "GUEST"

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters

    public  Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


