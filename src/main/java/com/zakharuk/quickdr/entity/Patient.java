package com.zakharuk.quickdr.entity;

import com.zakharuk.quickdr.entity.Procedure;

import java.util.List;

/**
 * Created by matvii on 06.02.17.
 */
public interface Patient {

    String getPatientData();
    List<Procedure> getAssignedProcedures();

    int getPatientId();

    void setPatientId(int patientId);

    String getName();

    void setName(String name);
    int getAge();
    void setAge(int age);
    String getDiagnosis();
    void setDiagnosis(String diagnosis);


}
