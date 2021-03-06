package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.DoctorPatientDao;
import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Therapist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by matvii on 13.04.17.
 */
@Repository
public class DoctorPatientDaoImplJDBC implements DoctorPatientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_BY_DOCTOR =
            "SELECT * FROM ChildPatients WHERE patientId IN " +
                    "(SELECT patients_patientId FROM doctor_patient WHERE id=?)";
    private static final String GET_BY_PATIENT =
            "SELECT * FROM doctors WHERE id IN " +
                    "(SELECT id FROM doctor_patient WHERE patients_patientId=?)";
    private static final String INSERT = "INSERT INTO doctor_patient (id, patients_patientId) VALUES (?,?)";
    private static final String UPDATE = "UPDATE doctors SET id=?, patients_patientId=?";
    private static final String DELETE_BY_PATIENT = "DELETE FROM doctor_patient WHERE patients_patientId=?";
    private static final String DELETE_BY_DOCTOR = "DELETE FROM doctor_patient WHERE id=?";

    private static final String GET_UNATTENDED_PATIENTS =
            "SELECT * FROM ChildPatients WHERE patientId NOT IN " +
                    "(SELECT patients_patientId FROM doctor_patient)";
    private static final String GET_AVAILABLE_DOCTORS =
            "(SELECT * FROM doctors WHERE id IN " +
                    "(SELECT id" +
                    " FROM doctor_patient " +
                    " GROUP BY id" +
                    " HAVING COUNT(patients_patientId) < 3)) UNION " +
                    "(SELECT * FROM doctors WHERE id IN " +
                    "(SELECT id FROM doctors WHERE id NOT IN (SELECT id FROM doctor_patient)))";

    private static final String GET_BOOKED_DOCTORS =
            "(SELECT * FROM doctors WHERE id NOT IN " +
                    "(SELECT id" +
                    " FROM doctor_patient " +
                    " GROUP BY id" +
                    " HAVING COUNT(patients_patientId) < 3)) UNION " +
                    "(SELECT * FROM doctors WHERE id NOT IN " +
                    "(SELECT id FROM doctors WHERE id NOT IN (SELECT id FROM doctor_patient)))";

    private static final String PATIENTS_WITH_ONE_DOCTOR =
            "SELECT * FROM ChildPatients WHERE patientId IN" +
                    "(SELECT patients_patientId " +
                    " FROM doctor_patient " +
                    " WHERE patients_patientId IN" +
                    "      (SELECT patients_patientId FROM doctor_patient WHERE id=?) AND NOT patients_patientId IN " +
                    "      (SELECT patients_patientId FROM doctor_patient WHERE id <> ?));";
    @Override
    public void assignPatientToDoctor(int doctorId, int patientId) {
        System.out.println("Assigning patient #" + patientId + " to doctor #" + doctorId);
        jdbcTemplate.update(INSERT, doctorId, patientId);
    }

    @Override
    public List<Patient> getDoctorsPatients(int doctorId) {
        return jdbcTemplate.query(GET_BY_DOCTOR, mapperPatient, doctorId);
    }

    @Override
    public List<Doctor> getPatientsDoctors(int patientId) {
        return jdbcTemplate.query(GET_BY_PATIENT, mapperDoctor, patientId);
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

    @Override
    public List<Patient> getUnattendedPatients() {
        return jdbcTemplate.query(GET_UNATTENDED_PATIENTS, mapperPatient);
    }

    @Override
    public List<Doctor> getAvailableDoctors() {
        return jdbcTemplate.query(GET_AVAILABLE_DOCTORS, mapperDoctor);
    }

    @Override
    public List<Doctor> getBookedDoctors() {
        return jdbcTemplate.query(GET_BOOKED_DOCTORS, mapperDoctor);
    }


    @Override
    public List<Patient> getPatientsWithOneDoctor(int doctorId) {
        return jdbcTemplate.query(PATIENTS_WITH_ONE_DOCTOR, mapperPatient, doctorId, doctorId);
    }

    private RowMapper<Doctor> mapperDoctor = new RowMapper<Doctor>() {
        public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Doctor doctor = new Therapist();
            doctor.setId(rs.getInt("id"));
            doctor.setName(rs.getString("name"));
            doctor.setOffice(rs.getInt("office"));
            doctor.setWorkingHour1(rs.getDate("whour1"));
            doctor.setWorkingHour2(rs.getDate("whour2"));
            return doctor;
        }
    };
    private RowMapper<Patient> mapperPatient = new RowMapper<Patient>() {
        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Patient patient = new ChildPatient();
            patient.setPatientId(rs.getInt("patientId"));
            patient.setName(rs.getString("name"));
            patient.setAge(rs.getInt("age"));
            patient.setDiagnosis(rs.getString("diagnosis"));
            return patient;
        }
    };
}
