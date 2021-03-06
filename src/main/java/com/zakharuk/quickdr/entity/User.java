package com.zakharuk.quickdr.entity;

import javax.persistence.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by matvii on 13.04.17.
 */
@Entity
@Table(name = "users")
public class User {

    @NotNull
    @Column(name="username")
    @Id
    private String name;

    @NotNull
    private String password;

    @NotNull
    private String role;

    @NotNull
    private boolean enabled;

    public User() {
    }



    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("<i>");
        res.append(getName());
        res.append("</i>");
        res.append("<br>");
        res.append("Role: ");
        res.append(getRole());
        res.append("<br>");
        res.append("<br>");
        return res.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}