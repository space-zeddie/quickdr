package com.zakharuk.quickdr.entity;

import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Procedure;

import java.util.List;

/**
 * Created by matvii on 14.02.17.
 */
public interface IPatientRecord {

    Patient getPatient();
    List<Doctor> getDoctors();
    List<String> getDiagnoses();
    List<Procedure> getProcedures();

}
