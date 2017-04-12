package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.ProcedureDao;
import com.zakharuk.quickdr.entity.Procedure;
import org.springframework.stereotype.Repository;

/**
 * Created by matvii on 12.04.17.
 */
@Repository
public class ProcedureDaoImplJDBC implements ProcedureDao {

    

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
