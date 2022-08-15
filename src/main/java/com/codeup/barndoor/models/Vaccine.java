package com.codeup.barndoor.models;


import javax.persistence.*;

@Entity
@Table(name = "Vaccines")

public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String vaccineName;

    @Column(nullable = false)
    private String description;



}
