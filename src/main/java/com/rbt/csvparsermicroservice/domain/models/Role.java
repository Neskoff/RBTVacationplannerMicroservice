package com.rbt.csvparsermicroservice.domain.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role{
    @Id
    private Long id;
    private String role;

    public Role(){};

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}