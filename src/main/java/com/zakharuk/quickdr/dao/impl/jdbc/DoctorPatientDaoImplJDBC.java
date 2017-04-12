package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.DoctorPatientDao;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by matvii on 13.04.17.
 */
public class DoctorPatientDaoImplJDBC implements DoctorPatientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_BY_DOCTOR = "SELECT * FROM doctor_patient WHERE id=?";
    private static final String GET_BY_PATIENT = "SELECT * FROM doctor_patient WHERE patients_patientId=?";
    private static final String INSERT = "INSERT INTO doctor_patient (id, patients_patientId) VALUES (?,?)";
    private static final String UPDATE = "UPDATE doctors SET id=?, patients_patientId=?";
    private static final String DELETE_BY_PATIENT = "DELETE FROM doctor_patient WHERE patients_patientId=?";
    private static final String DELETE_BY_DOCTOR = "DELETE FROM doctor_patient WHERE id=?";

    @Override
    public void assignPatientToDoctor(int doctorId, int patientId) {
        System.out.println("Assigning patient #" + patientId + " to doctor #" + doctorId);
        jdbcTemplate.update(INSERT, doctorId, patientId);
    }

    @Override
    public List<Patient> getDoctorsPatients(int doctorId) {
        return jdbcTemplate.query(GET_BY_DOCTOR, mapper, doctorId);
    }

    @Override
    public List<Doctor> getPatientsDoctors(int patientId) {
        return jdbcTemplate.query(GET_BY_PATIENT, mapper, patientId);
    }

    @Override
    public void update(int doctorId, int patientId) {
        System.out.println("Updating patient #" + patientId + " to doctor #" + doctorId);
        jdbcTemplate.update(UPDATE, doctorId, patientId);
    }

    @Override
    public void removeByDoctor(int doctorId) {
        System.out.println("Deleting patients of doctor #" + doctorId);
        jdbcTemplate.update(DELETE_BY_DOCTOR, doctorId);
    }

    @Override
    public void removeByPatient(int patientId) {
        System.out.println("Deleting doctors of patient #" + patientId);
        jdbcTemplate.update(DELETE_BY_PATIENT, patientId);
    }
}
