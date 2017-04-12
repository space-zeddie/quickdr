package com.zakharuk.quickdr.dao;

import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;

import java.util.List;

/**
 * Created by matvii on 13.04.17.
 */
public interface DoctorPatientDao {

    void assignPatientToDoctor(int doctorId, int patientId);
    List<Patient> getDoctorsPatients(int doctorId);
    List<Doctor> getPatientsDoctors(int patientId);
    void update(int doctorId, int patientId);
    void removeByDoctor(int doctorId);
    void removeByPatient(int patientId);

}
