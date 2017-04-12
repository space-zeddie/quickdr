package com.zakharuk.quickdr.dao;

import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Procedure;

/**
 * Created by matvii on 12.04.17.
 */
public interface ProcedureDao {

    void add(Procedure procedure);

    Procedure getProcedureById(int id);

    void update(Procedure procedure);

    void remove(Procedure procedure);

}
