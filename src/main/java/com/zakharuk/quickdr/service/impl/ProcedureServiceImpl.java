package com.zakharuk.quickdr.service.impl;

import com.zakharuk.quickdr.dao.ProcedureDao;
import com.zakharuk.quickdr.entity.Procedure;
import com.zakharuk.quickdr.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by matvii on 12.04.17.
 */
@Service
@Transactional
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcedureDao procedureDao;

    @Override
    public void add(Procedure procedure) {
        procedureDao.add(procedure);
    }

    @Override
    public Procedure getProcedureById(int id) {
        return procedureDao.getProcedureById(id);
    }

    @Override
    public void update(Procedure procedure) {
        procedureDao.update(procedure);
    }

    @Override
    public void remove(Procedure procedure) {
        procedureDao.remove(procedure);
    }
}
