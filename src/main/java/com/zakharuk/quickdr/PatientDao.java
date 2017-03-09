package com.zakharuk.quickdr;

/**
 * Created by matvii on 09.03.17.
 */
public interface PatientDao {

    void addPatient(Patient patient);
    Patient getPatientById(int id);
    Patient getPatientByName(String name);
    void savePatient(Patient patient);

}
