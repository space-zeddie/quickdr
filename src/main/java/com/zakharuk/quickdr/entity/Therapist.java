package com.zakharuk.quickdr.entity;

import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Procedures;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by matvii on 06.02.17.
 */
public class Therapist implements Doctor {

    private String name;
    private int office;
    private List<Patient> patients;
    private Pair<Date, Date> workingHours;
    private Map<Date, Patient> appointments;
    private List<Procedures> availableProcedures;

    public Therapist(){
        patients = new ArrayList<Patient>();
    }

    public Therapist(String name, int office) {
        this.name = name;
        this.office = office;
        patients = new ArrayList<Patient>();
        appointments = new HashMap<Date, Patient>();
    }

    public Therapist(String name, int office, Pair<Date, Date> workingHours, List<Procedures> availableProcedures) {
        this.name = name;
        this.office = office;
        this.workingHours = workingHours;
        this.availableProcedures = availableProcedures;
        patients = new ArrayList<Patient>();
        appointments = new HashMap<Date, Patient>();
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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setWorkingHours(Pair<Date, Date> workingHours) {
        this.workingHours = workingHours;
    }

    public void setAvailableProcedures(List<Procedures> availableProcedures) {
        this.availableProcedures = availableProcedures;
    }

    @Override
    public List<Procedures> getAvailableProcedures() {
        return availableProcedures;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void examine(Patient patient) {
        if (!patients.contains(patient))
            patients.add(patient);
        patient.setDiagnosis("cancer");
        System.out.println("Dr. " + name + " examined " + patient.getPatientData());
    }

    @Override
    public Pair<Date, Date> getWorkingHours() {
        return workingHours;
    }

    @Override
    public boolean bookAppointment(Patient patient, Date at) {
        if (!appointments.keySet().contains(at) &&
                ((workingHours.getKey().getTime()<=at.getTime()) && (at.getTime()<=workingHours.getValue().getTime()))) {
            if (!patients.contains(patient))
                patients.add(patient);
            appointments.put(at, patient);
            return true;
        }
        return false;
    }

    @Override
    public Map<Date, Patient> getAppointments() {
        return appointments;
    }
}
