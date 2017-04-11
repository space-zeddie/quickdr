package com.zakharuk.quickdr.dao;

import com.zakharuk.quickdr.dao.PatientDao;
import com.zakharuk.quickdr.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by matvii on 09.03.17.
 */
@Repository
public class PatientDaoImpl implements PatientDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPatient(Patient patient) {
        currentSession().save(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return (Patient) currentSession().get(Patient.class, id);
    }

    @Override
    public Patient getPatientByName(String name) {
        return (Patient) currentSession().get(Patient.class, name);
    }

    @Override
    public void savePatient(Patient patient) {
        currentSession().update(patient);
    }
}
