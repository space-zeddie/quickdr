package com.zakharuk.quickdr;

import java.util.Date;
import java.util.List;

/**
 * Created by matvii on 14.02.17.
 */
enum Procedures {
    EXAMINATION, OPERATION, BLOOD_ANALYSIS;
}


public class Procedure {
    private Procedures type;
    private List<Doctor> doctors;
    private Date dateOfProcedure;
    private boolean isCompleted;

    public Procedure(Procedures type) {
        this.type = type;
    }

    public Procedure(Procedures type, List<Doctor> doctors, Date dateOfProcedure) {
        this.type = type;
        this.doctors = doctors;
        this.dateOfProcedure = dateOfProcedure;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Procedures getType() {
        return type;
    }

    public void setType(Procedures type) {
        this.type = type;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Date getDateOfProcedure() {
        return dateOfProcedure;
    }

    public void setDateOfProcedure(Date dateOfProcedure) {
        this.dateOfProcedure = dateOfProcedure;
    }
}