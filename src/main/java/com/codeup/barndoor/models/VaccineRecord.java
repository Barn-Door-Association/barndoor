package com.codeup.barndoor.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vaccine_records")
public class VaccineRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long dosageInCcs;

    @Column(nullable = false, columnDefinition = "date")
    private Date dateAdministered;

    @Column(nullable = false)
    private boolean isBooster;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "goat_id")
    private Goat goat;

    public VaccineRecord() {
    }

    public VaccineRecord(long dosageInCcs, Date dateAdministered, boolean isBooster, Vaccine vaccine, Goat goat) {
        this.dosageInCcs = dosageInCcs;
        this.dateAdministered = dateAdministered;
        this.isBooster = isBooster;
        this.vaccine = vaccine;
        this.goat = goat;
    }

    public long getId() {
        return id;
    }

    public long getDosageInCcs() {
        return dosageInCcs;
    }

    public void setDosageInCcs(long dosageInCcs) {
        this.dosageInCcs = dosageInCcs;
    }

    public Date getDateAdministered() {
        return dateAdministered;
    }

    public void setDateAdministered(Date dateAdministered) {
        this.dateAdministered = dateAdministered;
    }

    public boolean isBooster() {
        return isBooster;
    }

    public void setBooster(boolean booster) {
        isBooster = booster;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Goat getGoat() {
        return goat;
    }

    public void setGoat(Goat goat) {
        this.goat = goat;
    }
}
