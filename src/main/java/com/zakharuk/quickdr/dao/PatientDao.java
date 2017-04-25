package com.zakharuk.quickdr.dao;

import com.zakharuk.quickdr.entity.Patient;

/**
 * Created by matvii on 09.03.17.
 */
public interface PatientDao {

    void addPatient(Patient patient);
    Patient getPatientById(int id);
    Patient getPatientByName(String name);
    void savePatient(Patient patient);

    void remove(Patient patient);

    Patient findByName(String name);


}
