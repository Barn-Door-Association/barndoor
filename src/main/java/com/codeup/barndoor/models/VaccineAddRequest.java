package com.codeup.barndoor.models;

import java.util.Date;

public class VaccineAddRequest {
    private long vaccineId;
    private long dosageInCcs;
    private Date dateAdministered;
    private boolean isBooster;
    private long goatId;

    public VaccineAddRequest() {
    }

    public VaccineAddRequest(long vaccineId, long dosageInCcs, Date dateAdministered, boolean isBooster, long goatId) {
        this.vaccineId = vaccineId;
        this.dosageInCcs = dosageInCcs;
        this.dateAdministered = dateAdministered;
        this.isBooster = isBooster;
        this.goatId = goatId;
    }

    public long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(long vaccineId) {
        this.vaccineId = vaccineId;
    }

    public long getGoatId() {
        return goatId;
    }

    public void setGoatId(long goatId) {
        this.goatId = goatId;
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

    public boolean getIsBooster() {
        return isBooster;
    }

    public void setBooster(boolean booster) {
        isBooster = booster;
    }
}
