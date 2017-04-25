package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.DoctorDao;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Procedure;
import com.zakharuk.quickdr.entity.Therapist;
import com.zakharuk.quickdr.pojo.DoctorPojo;
import com.zakharuk.quickdr.pojo.ProcedurePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by matvii on 13.04.17.
 */
@Repository
public class DoctorDaoImplJDBC implements DoctorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET = "SELECT * FROM doctors WHERE id=?";
    private static final String GET_BY_NAME = "SELECT * FROM doctors WHERE name=?";
    private static final String INSERT = "INSERT INTO doctors (name, office, whour1, whour2) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE doctors SET name=?, office=?, whour1=?, whour2=?";
    private static final String DELETE = "DELETE FROM doctors WHERE id=?";

    @Override
    public void add(Doctor doctor) {
        System.out.println("Saving doctor to DB: " + doctor);
        jdbcTemplate.update(INSERT, doctor.getName(), doctor.getOffice(),
                doctor.getWorkingHour1(), doctor.getWorkingHour2());
    }

    @Override
    public Doctor getDoctorById(int id) {
        System.out.println("Getting doctor: " + id);
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public void update(Doctor doctor) {
        System.out.println("Updating procedure: " + doctor);
        jdbcTemplate.update(UPDATE, doctor.getName(), doctor.getOffice(),
                doctor.getWorkingHour1(), doctor.getWorkingHour2());
    }

    @Override
    public void remove(Doctor doctor) {
        System.out.println("Removing: " + doctor);
        jdbcTemplate.update(DELETE, doctor.getId());
    }

    @Override
    public Doctor findByName(String name) {
        System.out.println("Getting doctor: " + name);
        return jdbcTemplate.queryForObject(GET_BY_NAME, mapper, name);
    }

    private RowMapper<DoctorPojo> doctorPojoRowMapper = new RowMapper<DoctorPojo>() {
        public DoctorPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new DoctorPojo(rs.getString("name"),
                    rs.getInt("office"),
                    rs.getDate("whour1"),
                    rs.getDate("whour2"));
        }
    };

    private RowMapper<Doctor> mapper = new RowMapper<Doctor>() {
        public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Doctor doctor = new Therapist();
            doctor.setName(rs.getString("name"));
            doctor.setOffice(rs.getInt("office"));
            doctor.setWorkingHour1(rs.getDate("whour1"));
            doctor.setWorkingHour2(rs.getDate("whour2"));
            return doctor;
        }
    };
}
