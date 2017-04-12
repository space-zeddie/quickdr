package com.zakharuk.quickdr.entity;

import org.omg.CORBA.UNKNOWN;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by matvii on 14.02.17.
 */
enum Procedures {
    EXAMINATION, OPERATION, BLOOD_ANALYSIS, UNKNOWN;
}

@Entity
@Table(name="Procedures")
public class Procedure {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="type")
    private Procedures type;

    //@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinTable(name="doctor_procedure", joinColumns = {
      //      @JoinColumn(name = "doctorId")
    //})

    //private List<Doctor> doctors;

    @Column(name="date")
    private Date dateOfProcedure;

    @Column(name="completed")
    private boolean isCompleted;

    public Procedure(Procedures type) {
        this.type = type;
    }

    public Procedure(){}

    public Procedure(Procedures type, List<Doctor> doctors, Date dateOfProcedure) {
        this.type = type;
        //this.doctors = doctors;
        this.dateOfProcedure = dateOfProcedure;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getTypeString() {
        return typeToString(this.type);
    }

    public void setType(String type) {
        this.type = stringToType(type);
    }

    public Procedures getType() {
        return type;
    }

    public void setType(Procedures type) {
        this.type = type;
    }

    private Procedures stringToType(String t) {
        t = t.toLowerCase();
        switch (t) {
            case "examination": return Procedures.EXAMINATION;
            case "blood analysis": return Procedures.BLOOD_ANALYSIS;
            case "operation": return Procedures.OPERATION;
            default: return Procedures.UNKNOWN;
        }
    }

    private String typeToString(Procedures t) {
        switch (t) {
            case EXAMINATION: return "examination";
            case BLOOD_ANALYSIS: return "blood analysis";
            case OPERATION: return "operation";
            default: return "unknown";
        }
    }

    //public List<Doctor> getDoctors() {return doctors;}

    //public void setDoctors(List<Doctor> doctors) {
        //this.doctors = doctors;
    //}

    public Date getDateOfProcedure() {
        return dateOfProcedure;
    }

    public void setDateOfProcedure(Date dateOfProcedure) {
        this.dateOfProcedure = dateOfProcedure;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "id=" + id +
                ", type=" + type +
                ", dateOfProcedure=" + dateOfProcedure +
                ", isCompleted=" + isCompleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}