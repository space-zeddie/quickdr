package com.zakharuk.quickdr;

import java.util.List;

/**
 * Created by matvii on 06.02.17.
 */
public interface Patient {

    String getPatientData();
    void setDiagnosis(String diagnosis);
    List<Procedure> getAssignedProcedures();

}
