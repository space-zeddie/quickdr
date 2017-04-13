package com.zakharuk.quickdr.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matvii on 06.02.17.
 */
@Entity
@Table(name="ChildPatients")
public class ChildPatient implements Patient {

    @Id
    @GeneratedValue
    private int patientId;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="diagnosis")
    private String diagnosis = null;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name="patient_procedure", joinColumns = {
          @JoinColumn(name = "id")
    })
    private List<Procedure> assignedProcedures;

    public ChildPatient(){}

    public ChildPatient(String name, int age) {
        this.name = name;
        this.age = age;
        assignedProcedures = new ArrayList<Procedure>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildPatient that = (ChildPatient) o;

        return patientId == that.patientId;
    }

    @Override
    public String toString() {
        return "ChildPatient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return patientId;
    }

    public void addProcedure(Procedure procedure) { assignedProcedures.add(procedure); }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

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
        return assignedProcedures;
    }

    public String getPatientData() {
        return name + ", " + age + ", " + diagnosis;
    }
}
