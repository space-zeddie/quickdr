package com.zakharuk.quickdr.entity;

import com.zakharuk.quickdr.entity.Procedure;

import java.util.List;

/**
 * Created by matvii on 06.02.17.
 */
public interface Patient {

    String getPatientData();
    void setDiagnosis(String diagnosis);
    List<Procedure> getAssignedProcedures();

}
