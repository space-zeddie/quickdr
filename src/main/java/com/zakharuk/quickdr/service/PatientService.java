package com.zakharuk.quickdr.service;

import com.zakharuk.quickdr.entity.Patient;

/**
 * Created by matvii on 12.04.17.
 */
public interface PatientService {

    void addPatient(Patient patient);
    Patient getPatientById(int id);
    Patient getPatientByName(String name);
    void savePatient(Patient patient);

    void remove(Patient patient);

}
