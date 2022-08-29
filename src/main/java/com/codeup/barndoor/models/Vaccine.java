package com.codeup.barndoor.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vaccines")

public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String vaccineName;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "vaccine", fetch = FetchType.LAZY)
    private List<VaccineRecord> vaccineRecords;

    public Vaccine() {
    }

    public Vaccine(String vaccineName, String description, List<VaccineRecord> vaccinesRecords) {
        this.vaccineName = vaccineName;
        this.description = description;
        this.vaccineRecords = vaccinesRecords;
    }

    public long getId() {
        return id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<VaccineRecord> getVaccineRecords() {
        return vaccineRecords;
    }

    public void setVaccineRecords(List<VaccineRecord> vaccineRecords) {
        this.vaccineRecords = vaccineRecords;
    }
}