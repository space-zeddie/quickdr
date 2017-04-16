package com.zakharuk.quickdr.service.impl;

import com.zakharuk.quickdr.dao.DoctorPatientDao;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.service.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by matvii on 13.04.17.
 */
@Service
@Transactional
public class DoctorPatientServiceImpl implements DoctorPatientService{

    @Autowired
    private DoctorPatientDao doctorPatientDao;

    @Override
    public void assignPatientToDoctor(int doctorId, int patientId) {
        doctorPatientDao.assignPatientToDoctor(doctorId, patientId);
    }

    @Override
    public List<Patient> getDoctorsPatients(int doctorId) {
        return doctorPatientDao.getDoctorsPatients(doctorId);
    }

    @Override
    public List<Doctor> getPatientsDoctors(int patientId) {
        return doctorPatientDao.getPatientsDoctors(patientId);
    }

    @Override
    public void update(int doctorId, int patientId) {
        doctorPatientDao.update(doctorId, patientId);
    }

    @Override
    public void removeByDoctor(int doctorId) {
        doctorPatientDao.removeByDoctor(doctorId);
    }

    @Override
    public void removeByPatient(int patientId) {
        doctorPatientDao.removeByPatient(patientId);
    }

    @Override
    public List<Doctor> getAvailableDoctors() {
        return doctorPatientDao.getAvailableDoctors();
    }
    @Override
    public List<Doctor> getBookedDoctors() {
        return doctorPatientDao.getBookedDoctors();
    }

    @Override
    public List<Patient> getUnattendedPatients() {
        return doctorPatientDao.getUnattendedPatients();
    }

    @Override
    public List<Patient> getPatientsWithOneDoctor(int doctorId) {
        return doctorPatientDao.getPatientsWithOneDoctor(doctorId);
    }
}
