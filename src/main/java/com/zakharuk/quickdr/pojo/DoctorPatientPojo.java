package com.zakharuk.quickdr.pojo;

import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;

/**
 * Created by matvii on 13.04.17.
 */
public class DoctorPatientPojo {
    private Doctor doctor;
    private Patient patient;

    public DoctorPatientPojo(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
