package com.zakharuk.quickdr.service;

import com.zakharuk.quickdr.entity.Procedure;

/**
 * Created by matvii on 12.04.17.
 */
public interface ProcedureService {
    void add(Procedure procedure);

    Procedure getProcedureById(int id);

    void update(Procedure procedure);

    void remove(Procedure procedure);
}
