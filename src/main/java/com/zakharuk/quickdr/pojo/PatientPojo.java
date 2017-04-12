package com.zakharuk.quickdr.pojo;

/**
 * Created by matvii on 12.04.17.
 */
public class PatientPojo {

    private String name;
    private String diagnosis;
    private int age;

    public PatientPojo(String name, int age, String diagnosis) {
        this.name = name;
        this.diagnosis = diagnosis;
        this.age = age;
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
