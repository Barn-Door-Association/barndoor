package com.codeup.barndoor.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vaccine_records")
public class VaccineRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int dosageInCcs;

    @Column(nullable = false, columnDefinition = "date")
    private Date dateAdministered;

    @Column(nullable = false)
    private boolean isBooster;

//    @OneToOne
//    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "vaccine_id") //assigns foreign key
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "goat_id")
    private Goat goat;

    public VaccineRecord() {
    }

    public VaccineRecord(int dosageInCcs, Date dateAdministered, boolean isBooster, Vaccine vaccine, Goat goat) {
        this.dosageInCcs = dosageInCcs;
        this.dateAdministered = dateAdministered;
        this.isBooster = isBooster;
        this.vaccine = vaccine;
        this.goat = goat;
    }

    public long getId() {
        return id;
    }

    public int getDosageInCcs() {
        return dosageInCcs;
    }

    public void setDosageInCcs(int dosageInCcs) {
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

    public Vaccine getVaccines() {
        return vaccine;
    }

    public void setVaccines(Vaccine vaccines) {
        this.vaccine = vaccine;
    }

    public Goat getGoat() {
        return goat;
    }

    public void setGoat(Goat goat) {
        this.goat = goat;
    }
}
