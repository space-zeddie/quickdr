package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.ProcedureDao;
import com.zakharuk.quickdr.entity.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by matvii on 12.04.17.
 */
@Repository
public class ProcedureDaoImplJDBC implements ProcedureDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET = "SELECT * FROM Procedures WHERE id=?";
    private static final String INSERT = "INSERT INTO ChildPatients (name, age, diagnosis) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE ChildPatients SET name=?, age=?, diagnosis=?";
    private static final String DELETE = "DELETE FROM ChildPatients WHERE patientId=?";

    @Override
    public void add(Procedure procedure) {

    }

    @Override
    public Procedure getProcedureById(int id) {
        return null;
    }

    @Override
    public void update(Procedure procedure) {

    }

    @Override
    public void remove(Procedure procedure) {

    }
}
