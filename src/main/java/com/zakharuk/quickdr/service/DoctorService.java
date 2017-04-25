package com.zakharuk.quickdr.service;

import com.zakharuk.quickdr.entity.Doctor;

/**
 * Created by matvii on 13.04.17.
 */
public interface DoctorService {
    void add(Doctor doctor);

    Doctor getDoctorById(int id);

    void update(Doctor doctor);

    void remove(Doctor doctor);

    Doctor findByName(String name);
}
