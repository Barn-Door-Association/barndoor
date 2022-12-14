package com.codeup.barndoor.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "herds")
public class Herd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String herdName;

    @Column(nullable = false)
    private String description;

    // Adds relationship to User table using "user_id" as foreign key
    @ManyToOne
    @JoinColumn(name = "user_id") //assigns foreign key
    private User user;


    // Adds relationship to Goat table
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "herd")
    private List<Goat> goats = new ArrayList<>();

    public Herd() {
    }

    public Herd(long id, String herdName, String description, User user) {
        this.id = id;
        this.herdName = herdName;
        this.description = description;
        this.user = user;

    }

    public Herd(String herdName, String description, User user) {
        this.herdName = herdName;
        this.description = description;
        this.user = user;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHerdName() {
        return herdName;
    }

    public void setHerdName(String herdName) {
        this.herdName = herdName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Goat> getGoats() {
        return goats;
    }

    public void setGoats(List<Goat> goats) {
        this.goats = goats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}