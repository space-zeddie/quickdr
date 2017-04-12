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
    private static final String INSERT = "INSERT INTO Procedures (type, date, completed) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE Procedures SET type=?, date=?, completed=?";
    private static final String DELETE = "DELETE FROM Procedures WHERE id=?";

    @Override
    public void add(Procedure procedure) {
        System.out.println("Saving procedure to DB: " + procedure);
        jdbcTemplate.update(INSERT, procedure.getTypeString(), procedure.getDateOfProcedure(),
                procedure.isCompleted());
    }

    @Override
    public Procedure getProcedureById(int id) {
        return null;
    }

    @Override
    public void update(Procedure procedure) {
        System.out.println("Updating procedure: " + procedure);
        jdbcTemplate.update(UPDATE, procedure.getTypeString(), procedure.getDateOfProcedure(),
                procedure.isCompleted());
    }

    @Override
    public void remove(Procedure procedure) {
        System.out.println("Removing: " + procedure);
        jdbcTemplate.update(DELETE, procedure.getId());
    }
}
