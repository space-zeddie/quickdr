package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.PatientDao;
import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Patient;
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

    private static final String GET = "SELECT * FROM ChildPatients WHERE id=?";
    private static final String INSERT = "INSERT INTO ChildPatients (name, age, diagnosis) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE ChildPatients SET name=?, age=?, diagnosis=?";
    private static final String DELETE = "DELETE FROM ChildPatients WHERE patientId=?";
   // private static final String GET_FREE_BY_DISPATCHER = "SELECT * FROM ChildPatients WHERE patientId NOT IN (SELECT c_d.car_id FROM car_driver c_d WHERE time_till IS NULL OR now() BETWEEN time_from AND time_till) AND serviceable=TRUE AND dept_id=?";

   // private static final String GET_STATS_BY_BRAND_MODEL = "SELECT brand, model, count(DISTINCT id) AS amount FROM car GROUP BY brand, model";

    @Override
    public void addPatient(Patient patient) {

    }

    @Override
    public Patient getPatientById(int id) {
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public Patient getPatientByName(String name) {
        return null;
    }

    @Override
    public void savePatient(Patient patient) {

    }
    private RowMapper<CarStatsPojo> carStatsPojoMapper = new RowMapper<CarStatsPojo>() {
        public CarStatsPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new CarStatsPojo(rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("diagnosis"));
        }
    };

    private RowMapper<Patient> mapper = new RowMapper<Patient>() {
        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Patient patient = new ChildPatient();
            patient.setPatientId(rs.getInt("patientId"));
            patient.setAge(rs.getInt("age"));
            patient.setDiagnosis(rs.getString("diagnosis"));
            return patient;
        }
    };
}
