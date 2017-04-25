package com.zakharuk.quickdr.pojo;

/**
 * Created by matvii on 12.04.17.
 */
public class PatientPojo {

    private int patientId;
    private String name;
    private String diagnosis;
    private int age;

    public PatientPojo(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.diagnosis = diagnosis;
        this.age = age;
    }

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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
