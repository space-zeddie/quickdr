package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.PatientProcedureDao;
import com.zakharuk.quickdr.entity.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by matvii on 13.04.17.
 */
@Repository
public class PatientProcedureDaoImplJDBC implements PatientProcedureDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_BY_PATIENT =
            "SELECT * FROM procedures WHERE id IN " +
                    "(SELECT assignedProcedures_id FROM patient_procedure WHERE id=?)";
    private static final String INSERT = "INSERT INTO patient_procedure (id, assignedProcedures_id) VALUES (?,?)";

    @Override
    public void assignProcedureToPatient(int procedureId, int patientId) {
        System.out.println("Assigning procedure #" + procedureId + " to patient #" + patientId);
        jdbcTemplate.update(INSERT, patientId, procedureId);
    }

    @Override
    public List<Procedure> getPatientsProcedure(int patientId) {
        return null;
    }

    @Override
    public void update(int procedureId, int patientId) {

    }

    @Override
    public void removeByProcedure(int procedureId) {

    }

    @Override
    public void removeByPatient(int patientId) {

    }
}
