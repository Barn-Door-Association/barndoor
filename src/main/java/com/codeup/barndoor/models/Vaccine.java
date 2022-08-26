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

    @OneToOne(mappedBy = "vaccine")
    private VaccineRecord vaccineRecord;

    public Vaccine() {
    }

    public Vaccine(String vaccineName, String description, VaccineRecord vaccinesRecord) {
        this.vaccineName = vaccineName;
        this.description = description;
        this.vaccineRecord = vaccinesRecord;
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

    public VaccineRecord getVaccinesRecord() {
        return vaccineRecord;
    }

    public void setVaccinesRecord(VaccineRecord vaccinesRecord) {
        this.vaccineRecord = vaccinesRecord;
    }
}
