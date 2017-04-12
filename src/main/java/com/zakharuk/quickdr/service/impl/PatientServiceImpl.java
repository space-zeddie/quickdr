package com.zakharuk.quickdr.service.impl;

import com.zakharuk.quickdr.dao.PatientDao;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by matvii on 12.04.17.
 */
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public void addPatient(Patient patient) {
        patientDao.addPatient(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientDao.getPatientById();
    }

    @Override
    public Patient getPatientByName(String name) {
        return patientDao.getPatientByName(name);
    }

    @Override
    public void savePatient(Patient patient) {
        patientDao.savePatient(patient);
    }

    @Override
    public void remove(Patient patient) {
        patientDao.remove(patient);
    }
}
