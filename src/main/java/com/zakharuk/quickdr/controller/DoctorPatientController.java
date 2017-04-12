package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.service.DoctorService;
import com.zakharuk.quickdr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by matvii on 13.04.17.
 */
@Controller
public class DoctorPatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    /**
     * GET /assign-patient  --> Assign a patient to a doctor by id
     */
    @RequestMapping("/assign-patient")
    @ResponseBody
    public String update(int patientId, int doctorId) {
        try {
            Doctor doctor = doctorService.getDoctorById(doctorId);
            Patient patient = patientService.getPatientById(patientId);
            doctor.examine((ChildPatient) patient);
            doctorService.update(doctor);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error updating the doctor: " + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Doctor succesfully updated!" + Constants.FOOTER;
    }

}
