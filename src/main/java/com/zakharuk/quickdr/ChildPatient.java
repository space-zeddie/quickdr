package com.zakharuk.quickdr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matvii on 06.02.17.
 */
public class ChildPatient implements Patient {

    private String name;
    private int age;
    private String diagnosis = null;
    private List<Procedure> assignedProcedures;

    public ChildPatient(){}

    public ChildPatient(String name, int age) {
        this.name = name;
        this.age = age;
        assignedProcedures = new ArrayList<Procedure>();
    }

    public void addProcedure(Procedure procedure) { assignedProcedures.add(procedure); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public List<Procedure> getAssignedProcedures() {
        return null;
    }

    public String getPatientData() {
        return name + ", " + age + ", " + diagnosis;
    }
}
