package com.zakharuk.quickdr.dao;

import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Procedure;

import java.util.List;

/**
 * Created by matvii on 13.04.17.
 */
public interface PatientProcedureDao {

    void assignProcedureToPatient(int procedureId, int patientId);
    List<Procedure> getPatientsProcedure(int patientId);
    void update(int procedureId, int patientId);
    void removeByProcedure(int procedureId);
    void removeByPatient(int patientId);

}
