package com.codeup.barndoor.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String ranchName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    // Add relationship to herd @

    public User() {
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.password = copy.password;
        this.email = copy.email;
        this.ranchName = copy.ranchName;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
    }

    public User(long id, String username, String password, String email, String ranchName, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.ranchName = ranchName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRanchName() {
        return ranchName;
    }

    public void setRanchName(String ranchName) {
        this.ranchName = ranchName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}