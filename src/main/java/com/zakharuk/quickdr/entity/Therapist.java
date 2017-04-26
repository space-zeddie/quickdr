package com.zakharuk.quickdr.entity;

import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Procedures;
import javafx.util.Pair;
import javax.persistence.*;

import javax.persistence.Entity;
import java.util.*;

/**
 * Created by matvii on 06.02.17.
 */
@Entity
@Table(name="doctors")
public class Therapist implements Doctor {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="office")
    private int office;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name="doctor_patient", joinColumns = {
            @JoinColumn(name = "id")
    })
    private List<ChildPatient> patients;

    @Column(name="whour1")
    private Date workingHour1;
    @Column(name="whour2")
    private Date workingHour2;

    //private Map<Date, Patient> appointments;
   // private List<Procedures> availableProcedures;

    public Therapist(){
        patients = new ArrayList<ChildPatient>();
    }

    public Therapist(String name, int office) {
        this.name = name;
        this.office = office;
        patients = new ArrayList<ChildPatient>();
        //appointments = new HashMap<Date, Patient>();
    }

    public Therapist(String name, int office, Pair<Date, Date> workingHours, List<Procedures> availableProcedures) {
        this.name = name;
        this.office = office;
        this.workingHour1 = workingHours.getKey();
        this.workingHour2 = workingHours.getValue();
        //this.availableProcedures = availableProcedures;
        patients = new ArrayList<ChildPatient>();
       // appointments = new HashMap<Date, Patient>();
    }

    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public List<ChildPatient> getPatients() {
        return patients;
    }

    public void setWorkingHours(Pair<Date, Date> workingHours) {
        this.workingHour1 = workingHours.getKey();
        this.workingHour2 = workingHours.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Therapist therapist = (Therapist) o;

        return id == therapist.id;
    }

    @Override
    public String toString() {
        return "Therapist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", office=" + office +
                '}';
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public Date getWorkingHour1() {
        return workingHour1;
    }

    public void setWorkingHour1(Date workingHour1) {
        this.workingHour1 = workingHour1;
    }

    @Override
    public Date getWorkingHour2() {
        return workingHour2;
    }

    public void setWorkingHour2(Date workingHour2) {
        this.workingHour2 = workingHour2;
    }

    public void setAvailableProcedures(List<Procedures> availableProcedures) {
        //this.availableProcedures = availableProcedures;
    }

    @Override
    public List<Procedures> getAvailableProcedures() {
        return null;//availableProcedures;
    }

    public void setPatients(List<ChildPatient> patients) {
        this.patients = patients;
    }

    public void examine(ChildPatient patient) {
        if (!patients.contains(patient))
            patients.add(patient);
       // patient.setDiagnosis("cancer");
        System.out.println("Dr. " + name + " examined " + patient.getPatientData());
    }

    @Override
    public Pair<Date, Date> getWorkingHours() {
        return new Pair<>(workingHour1, workingHour2);
    }

    @Override
    public boolean bookAppointment(Patient patient, Date at) {
        /*if (!appointments.keySet().contains(at) &&
                ((workingHour1.getTime()<=at.getTime()) && (at.getTime()<=workingHour2.getTime()))) {
            if (!patients.contains(patient))
                patients.add(patient);
            appointments.put(at, patient);
            return true;
        }*/
        return false;
    }

    @Override
    public Map<Date, Patient> getAppointments() {
        return null;//appointments;
    }
}
