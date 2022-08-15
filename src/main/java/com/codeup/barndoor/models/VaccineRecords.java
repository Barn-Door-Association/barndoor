package com.codeup.barndoor.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vaccine_records")
public class VaccineRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int dosageInCcs;

    @Column(nullable = false, columnDefinition = "date")
    private Date dateAdministered;

    @Column(nullable = false)
    private boolean isBooster;

    @OneToOne
    private Vaccine vaccines;

    @ManyToOne
    @JoinColumn (name = "goat_id")
    private Goat goat;

    public VaccineRecords() {
    }

    public VaccineRecords(long id, int dosageInCcs, Date dateAdministered, boolean isBooster, Vaccine vaccines, Goat goat) {
        this.id = id;
        this.dosageInCcs = dosageInCcs;
        this.dateAdministered = dateAdministered;
        this.isBooster = isBooster;
        this.vaccines = vaccines;
        this.goat = goat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return vaccines;
    }

    public void setVaccines(Vaccine vaccines) {
        this.vaccines = vaccines;
    }

    public Goat getGoat() {
        return goat;
    }

    public void setGoat(Goat goat) {
        this.goat = goat;
    }
}
