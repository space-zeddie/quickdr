package com.zakharuk.quickdr.service.impl;

import com.zakharuk.quickdr.dao.DoctorDao;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.pojo.DoctorPojo;
import com.zakharuk.quickdr.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by matvii on 13.04.17.
 */
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public void add(Doctor doctor) {
        doctorDao.add(doctor);
    }

    @Override
    public Doctor getDoctorById(int id) {
        return doctorDao.getDoctorById(id);
    }

    @Override
    public void update(Doctor doctor) {
        doctorDao.update(doctor);
    }

    @Override
    public void remove(Doctor doctor) {
        doctorDao.remove(doctor);
    }
}
