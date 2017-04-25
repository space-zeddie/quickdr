package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.PatientDao;
import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.pojo.PatientPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by matvii on 12.04.17.
 */
@Repository
public class PatientDaoImplJDBC implements PatientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET = "SELECT * FROM ChildPatients WHERE patientId=?";
    private static final String GET_BY_NAME = "SELECT * FROM ChildPatients WHERE name=?";
    private static final String INSERT = "INSERT INTO ChildPatients (name, age, diagnosis) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE ChildPatients SET name=?, age=?, diagnosis=? WHERE patientId=?";
    private static final String DELETE = "DELETE FROM ChildPatients WHERE patientId=?";
    //private static final String TOTALL_PATIENTS = ""

    @Override
    public void addPatient(Patient patient) {
        System.out.println("Saving patient to DB: " + patient.getPatientData());
        jdbcTemplate.update(INSERT, patient.getName(), patient.getAge(), patient.getDiagnosis());
    }

    @Override
    public void remove(Patient patient) {
        System.out.println("Removing: " + patient.getPatientData());
        jdbcTemplate.update(DELETE, patient.getPatientId());
    }

    @Override
    public Patient findByName(String name) {
        System.out.println("Getting patient: " + name);
        return jdbcTemplate.queryForObject(GET_BY_NAME, mapper, name);
    }

    @Override
    public Patient getPatientById(int id) {
        System.out.println("Getting patient: " + id);
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public Patient getPatientByName(String name) {

        System.out.println("Getting patient: " + name);
        return jdbcTemplate.queryForObject(GET_BY_NAME, mapper, name);
    }

    @Override
    public void savePatient(Patient patient) {
        System.out.println("Updating patient: " + patient.getPatientData());
        jdbcTemplate.update(UPDATE, patient.getName(), patient.getAge(), patient.getDiagnosis(), patient.getPatientId());
    }

    private RowMapper<PatientPojo> patientPojoRowMapper = new RowMapper<PatientPojo>() {
        public PatientPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new PatientPojo(rs.getInt("patientId"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("diagnosis"));
        }
    };

    private RowMapper<Patient> mapper = new RowMapper<Patient>() {
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
